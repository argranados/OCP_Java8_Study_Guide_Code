package com.ocp8.IO_cap8;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StreamBaseClasses {

	public static void main(String[] args) {
		try {
		new BufferedInputStream(new FileInputStream("zoo-data.txt")); // DOES NOT COMPILE 
		new BufferedWriter(new FileWriter("zoo-data.txt"));// DOES NOT COMPILE 
		new ObjectInputStream(new FileInputStream("zoo-data.txt")); // DOES NOT COMPILE 
		new BufferedInputStream(new FileInputStream("zoo-data.txt"));// DOES NOT COMPILE
		} catch(IOException ex) {
			
		}
		

	}

}
