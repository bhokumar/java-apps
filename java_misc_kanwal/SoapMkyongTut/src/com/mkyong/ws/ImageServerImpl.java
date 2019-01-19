package com.mkyong.ws;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface = "com.mkyong.ws.ImageServer")
public class ImageServerImpl implements ImageServer {

	@Override
	public Image downloadImage(String name) {
	try{
		File image = new File("C:\\pictures\\"+ name);
		return ImageIO.read(image);
	}catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	
	}

	@Override
	public String uploadImage(Image image) {
		if(image!=null){
			return "Upload Succesfull";
		}
		throw new WebServiceException("Upload Failed!");
	}
	
	

}
