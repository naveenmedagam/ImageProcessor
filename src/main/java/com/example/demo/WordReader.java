package com.example.demo;

import java.io.*;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class WordReader {
 
	public static void main(String[] args) {
		String result = null;
		File file = new File("C:\\Tess4J\\TestDoc.doc");
		try{
			FileInputStream fis = new FileInputStream(file);
			WordExtractor  wordExtractor = new WordExtractor(fis);
			result = wordExtractor.getText();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		};
System.out.println(result);
	}
	
}
