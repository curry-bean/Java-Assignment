/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvin.hospitalserver;

/**
 *
 * @author aloha-tech
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HospitalInterface extends Remote {
    List<PatientInterface> getPatients() throws RemoteException;

    PatientInterface getPatient(int id) throws RemoteException;

    void addPatient(PatientInterface patient) throws RemoteException;

    void removePatient(int id) throws RemoteException;
}
