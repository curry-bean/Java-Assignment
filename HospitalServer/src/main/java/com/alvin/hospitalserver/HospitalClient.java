/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvin.hospitalserver;

/**
 *
 * @author aloha-tech
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HospitalClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            HospitalInterface stub = (HospitalInterface) registry.lookup("Hospital");

            Patient patient = new Patient("John", "Doe", "12345", "john.doe@example.com", "555-1234");
            boolean success = stub.addPatient(patient);

            if (success) {
                System.out.println("Successfully added patient: " + patient.getId());
            } else {
                System.out.println("Failed to add patient.");
            }
        } catch (Exception e) {
            System.err.println("Hospital client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
