package com.ocp8.IO_cap8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileSample {	
		
	public static void copy( File source, File destination) throws IOException { 
		try (InputStream in  = new FileInputStream( source); 
			OutputStream out = new FileOutputStream( destination)) { 
			int b; 
			while(( b = in.read()) != -1) { 
				out.write( b); 
			} 
		} 
		System.out.println("copiado");
	} 
	
	public static void main( String[] args) throws IOException { 
		File source = new File("zoo.txt"); 
		File destination = new File("ZooCopy.txt"); 
//		copy( source, destination); 
		copy_Modified( source, destination); 
	}
	
	//Modificado
	public static void copy_Modified( File source, File destination) throws IOException { 
		try ( InputStream in = new BufferedInputStream( new FileInputStream( source)); 
			  OutputStream out = new BufferedOutputStream( new FileOutputStream( destination))) { 
			  
			  byte[] buffer = new byte[ 1024]; 
			  int lengthRead; 
			  
			  while (( lengthRead = in.read( buffer)) > 0) { 
				  out.write( buffer, 0, lengthRead); 
				  out.flush();
			  }
		}
	}

	

	
}
