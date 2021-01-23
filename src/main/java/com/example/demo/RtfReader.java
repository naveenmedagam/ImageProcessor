package com.example.demo;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

public class RtfReader {

	public static void main(String[] args) {
		String result = null;
		File file = new File("C:\\Tess4J\\file-sample.rtf");
		try {	    
		    DefaultStyledDocument styledDoc = new DefaultStyledDocument();
		    InputStream is = new FileInputStream(file);
		    new RTFEditorKit().read(is, styledDoc, 0);
		    result = new String(styledDoc.getText(0,styledDoc.getLength()).
                                    getBytes("ISO8859_1"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
  System.out.print(result);

	}

}
