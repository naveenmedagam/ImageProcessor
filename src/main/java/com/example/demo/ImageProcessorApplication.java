package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@SpringBootApplication
public class ImageProcessorApplication {

	public static void main(String[] args) throws IOException, TesseractException {
		Tesseract tesseract = new Tesseract();

		String searchWord = "ентификатор";

		String PROPERTY_ID = "[0-9]\\d*(\\.[0-9]\\d*)*";

		tesseract.setDatapath("C:\\Tess4J\\Tess4J\\tessdata");
		tesseract.setLanguage("rus");

		// the path of your tess data folder
		// inside the extracted file

		String text = tesseract.doOCR(new File("C:\\Tess4J\\ОБЯВЛЕНИЕ ЗА ПП 2.pdf"));
      int index = 0;
		while (index != -1) {
			index = text.toLowerCase().indexOf(searchWord, index);
			if (index != -1) {

				// String inputString =
				// ipString.substring(ipString.indexOf(searchWord),ipString.indexOf(searchWord)
				// + 35);
				String inputString = text.substring(index, index + 30);

				Pattern pattern = Pattern.compile(PROPERTY_ID);
				Matcher matcher = pattern.matcher(inputString);
				if (matcher.find()) {
					System.out.println(matcher.group());
				}
				index++;

			}

		}

	}
}
