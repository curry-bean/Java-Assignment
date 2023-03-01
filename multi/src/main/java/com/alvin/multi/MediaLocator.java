/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvin.multi;

/**
 *
 * @author aloha-tech
 */
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MediaLocator {
    private String locator;

    public MediaLocator(String locator) {
        this.locator = locator;
    }

    public MediaLocator(URL url) {
        this.locator = url.toExternalForm();
    }

    public MediaLocator(URI uri) {
        this.locator = uri.toASCIIString();
    }

    public String getLocator() {
        return locator;
    }

    public URL getURL() throws MalformedURLException {
        return new URL(locator);
    }

    public URI getURI() throws URISyntaxException {
        return new URI(locator);
    }
}
