/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvin.multi;

/**
 *
 * @author aloha-tech
 */
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioPlayer {

    public static void main(String[] args) throws Exception {
        String audioFile = "file:///C:/path/to/audio.wav";
        MediaLocator locator = new MediaLocator(audioFile);

        try (AudioInputStream stream = AudioSystem.getAudioInputStream(locator.getURL())) {
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, stream.getFormat());
            try (SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info)) {
                line.open(stream.getFormat());
                line.start();
                
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = stream.read(buffer)) != -1) {
                    line.write(buffer, 0, bytesRead);
                }
                
                line.drain();
                line.stop();
            }
        }
    }
}
