package com.pratiques.files;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestFiles01 {

	
	public static void run() {
		
		try {

            File f = new File("../scripts/data.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }	
	} 
}
