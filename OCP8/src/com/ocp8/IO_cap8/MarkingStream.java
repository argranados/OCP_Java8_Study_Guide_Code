package com.ocp8.IO_cap8;

import java.io.FileInputStream;
import java.io.InputStream;

public class MarkingStream {

	public static void main(String[] args) throws Exception{

		InputStream is = new FileInputStream("c:\\data\\zoo.txt"); 
		
		System.out.print (( char) is.read());
		System.out.print (( char) is.read()); 
		if( is.markSupported()) { 
			is.mark(100); 
			System.out.print(( char) is.read());
			System.out.print(( char) is.read()); 
			is.reset(); 
		} 
		System.out.print(( char) is.read()); 
		System.out.print(( char) is.read()); 
		System.out.print(( char) is.read());
	}

}
