package com.ocp8.IO_cap8;

import java.io.File;

public class FileSimple {

	public static void main(String[] args) {
				
//		File file = new File("C:\\Users\\Poncho\\data\\zoo.txt"); 	
//		System.out.println(file.exists());
		
		File parent = new File("C:\\Users\\Poncho"); 
		File child = new File(parent,"data\\zoo.txt");
		System.out.println(child.exists());		
	}
}
