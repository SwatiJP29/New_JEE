/**
 * 
 */
package com.synergetics.xml_parsing;

/**
 * @author Smita
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class XmlParsing {
	public static void main(String[] args) {
		XmlParsing xp1 = new XmlParsing();
	}

	public XmlParsing() {
		try {
			File xmlFile = new File("src\\my_xml_file.xml");
			if (xmlFile.exists()) {
				System.out.println("file exits");
				FileInputStream inputStream = new FileInputStream(xmlFile);
				Reader in = new InputStreamReader(inputStream, "UTF-16");
				int read;
				while ((read = in.read()) != -1) {
					System.out.print(Character.toChars(read));
				}
				in.close();
			} else
				System.out.println("file not exits");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}