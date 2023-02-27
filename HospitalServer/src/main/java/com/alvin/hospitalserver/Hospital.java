/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvin.hospitalserver;

/**
 *
 * @author aloha-tech
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hospital extends UnicastRemoteObject implements HospitalInterface {
    private String name;
    private int numberOfPatients;

    public Hospital(String name) throws RemoteException {
        this.name = name;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    public int getNumberOfPatients() throws RemoteException {
        return numberOfPatients;
    }

    public void setNumberOfPatients(int numberOfPatients) throws RemoteException {
        this.numberOfPatients = numberOfPatients;
    }

    public void addPatient(PatientInterface patient) throws RemoteException {
        numberOfPatients++;
        System.out.println("Patient added to " + name + " hospital. Total number of patients: " + numberOfPatients);
    }

    public void removePatient(PatientInterface patient) throws RemoteException {
        numberOfPatients--;
        System.out.println("Patient removed from " + name + " hospital. Total number of patients: " + numberOfPatients);
    }
}
