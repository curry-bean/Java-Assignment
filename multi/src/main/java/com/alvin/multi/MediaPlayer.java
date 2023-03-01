/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.alvin.multi;

/**
 *
 * @author aloha-tech
 */

import javax.media.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class MediaPlayer extends JFrame {

    private Player player;
    private File mediaFile;

    public MediaPlayer() {
        super("Java Media Player");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Show the file chooser dialog and get the selected file
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            mediaFile = fileChooser.getSelectedFile();
            playMedia();
        } else {
            JOptionPane.showMessageDialog(this, "No file selected.");
        }
    }

    private void playMedia() {
        try {
            // Create a media locator
            MediaLocator mediaLocator = new MediaLocator(mediaFile.toURI().toURL());

            // Create a player
            player = Manager.createPlayer(mediaLocator);

            // Add the player to the content pane
            getContentPane().add(player.getVisualComponent(), BorderLayout.CENTER);

            // Add the player's controls to the content pane
            getContentPane().add(player.getControlPanelComponent(), BorderLayout.SOUTH);

            // Start playing the media
            player.start();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(this, "Error playing media.");
        }
    }

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setVisible(true);
    }

    private static class Manager {

        public Manager() {
        }
    }
}
