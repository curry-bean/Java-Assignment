/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.alvin.hospitalserver;

/**
 *
 * @author aloha-tech
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HospitalServer implements HospitalInterface {
    
    private Hospital hospital;

    public HospitalServer() {
        hospital = new Hospital();
    }

    public static void main(String[] args) {
        try {
            HospitalServer server = new HospitalServer();
            HospitalInterface stub = (HospitalInterface) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Hospital", stub);
            System.out.println("Hospital server is ready.");
        } catch (Exception e) {
            System.err.println("Hospital server failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean addPatient(Patient patient) throws RemoteException {
        return hospital.addPatient(patient);
    }

    public boolean removePatient(String id) throws RemoteException {
        return hospital.removePatient(id);
    }

    public Patient getPatient(String id) throws RemoteException {
        return hospital.getPatient(id);
    }

    public Patient[] getAllPatients() throws RemoteException {
        return hospital.getAllPatients();
    }
}
