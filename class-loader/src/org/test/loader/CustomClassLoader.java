package org.test.loader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {
	public CustomClassLoader(final ClassLoader parent) {
		super(parent);
		System.out.println("Loader to load CustomClassLoader"+getClass().getClassLoader());
	}
	
	@SuppressWarnings("unchecked")
	private Class getCustomClass(final String name){
		try{
			final String fileName = name.replace('.', File.separatorChar)+".class";
			byte[] b=loadClassFileData(fileName);
			Class c = defineClass(name, b, 0, b.length);
			resolveClass(c);
			return c;
		}catch(IOException e){
			System.out.println("Error occured!");
		}
		return null;
	}
	
	private byte[] loadClassFileData(final String name) throws IOException{
		final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name);
		final int size = inputStream.available();
		final byte[] bytes = new byte[size];
		final DataInputStream dataInputStream = new DataInputStream(inputStream);
		dataInputStream.readFully(bytes);
		dataInputStream.close();
		return bytes;
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		System.out.println("Loading Class '" + name + "'");
        if (name.startsWith("org.test.loader")) {
            System.out.println("Loading Class using CustomClassLoader");
            return getCustomClass(name);
        }
		return super.loadClass(name);
	}
}
