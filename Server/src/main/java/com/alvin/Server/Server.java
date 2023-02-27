/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvin.Server;

/**
 *
 * @author aloha-tech
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static PatientDatabase patientDatabase = new PatientDatabase();

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started at " + new java.util.Date());

            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create an input stream to receive data from the client
            ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());

            // Create an output stream to send data to the client
            ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                // Receive data from the client
                String patientID = inputFromClient.readUTF();

                // Search for the patient in the database
                Patient patient = patientDatabase.getPatient(patientID);

                // Send the patient data to the client
                outputToClient.writeObject(patient);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

