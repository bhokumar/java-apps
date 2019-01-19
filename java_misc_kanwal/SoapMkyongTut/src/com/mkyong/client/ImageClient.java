package com.mkyong.client;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.mkyong.ws.ImageServer;
import com.mkyong.ws.ImageServerImpl;

public class ImageClient {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:9999/ws/image?wsdl");
        QName qname = new QName("http://ws.mkyong.com/", "ImageServerImplService");
        
        Service service =Service.create(url, qname);
        
        ImageServer imageServer = service.getPort(ImageServer.class);
        Image image = imageServer.downloadImage("soap_messages.jpg");
        JFrame frame = new JFrame("Kanwal");
        frame.setSize(500, 400);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
        System.out.println("imageServer.downloadImage() : Download Successful!");
        
        
	}
}
