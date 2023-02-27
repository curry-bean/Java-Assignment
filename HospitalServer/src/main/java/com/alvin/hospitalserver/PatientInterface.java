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

public interface PatientInterface extends Remote {
    void register(Patient patient) throws RemoteException;
    Patient getPatient(int id) throws RemoteException;
    Patient[] getAllPatients() throws RemoteException;
    void updatePatient(Patient patient) throws RemoteException;
    void deletePatient(int id) throws RemoteException;
}
