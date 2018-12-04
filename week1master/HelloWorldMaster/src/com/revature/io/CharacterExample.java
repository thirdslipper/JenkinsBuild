package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharacterExample {
	public static void main(String[] args) {
		String filename = "samplefile.txt";
		writeCharacterStream(filename, "Hello World\n");
		readCharacterStream(filename);
		System.out.println();
		readScanner(filename);
	}

	private static void readScanner(String filename) {
		try(FileInputStream stream = new FileInputStream(filename); Scanner scan = new Scanner(stream)) {
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readCharacterStream(String filename) {
		try(FileReader reader = new FileReader(filename)) {
			int i;
			while((i = reader.read())!=-1) {
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeCharacterStream(String filename, String message) {
		/*FileWriter writer = null;
		try {
			writer = new FileWriter(filename, true);
			writer.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		try(FileWriter writer = new FileWriter(filename, true)) {
			writer.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
