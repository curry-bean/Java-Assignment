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
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Connected to the server");

            // Create an input stream to receive data from the server
            ObjectInputStream inputFromServer = new ObjectInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());

            // Create a scanner to read input from the user
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Prompt the user for the patient ID
                System.out.print("Enter patient ID (or 'exit' to quit): ");
                String patientID = scanner.nextLine();

                // Check if the user wants to exit
                if (patientID.equals("exit")) {
                    break;
                }

                // Send the patient ID to the server
                outputToServer.writeUTF(patientID);
                outputToServer.flush();

                // Receive the patient data from the server
                Patient patient = (Patient) inputFromServer.readObject();

                // Print the patient data
                System.out.println(patient);
            }

            // Close the socket
            socket.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
