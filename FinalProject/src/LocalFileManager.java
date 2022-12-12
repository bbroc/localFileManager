import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Scanner;

public class LocalFileManager {

	public static void main(String[] args) {

		String directory = System.getProperty("user.dir"); // used to obtain progam file structure path

		checkForBaseFolderthenCreate(directory);

		// initiate variable to end while to jump out of a method and back to the main
		// menu

		int roll = 1;

		Scanner scanner = new Scanner(System.in);

		// this will allow you to locate and load your file in any project

		try {

			// while loop to assist in navigation

			while (roll >= 1) {

				// Display instructions

				StringBuilder sb1 = new StringBuilder();

				sb1.append("=================================================================================\n");

				sb1.append("\n");

				sb1.append("                    Welcome to the Final Java Project\n");

				sb1.append("                         Developer: Elmer Fudd\n");

				sb1.append("\n");

				sb1.append("=================================================================================\n");

				sb1.append("\n");

				System.out.println(sb1);

				// File.seperator adjusts for both Unix and Windows environments

				getFileManifest(directory + File.separator + "stuff" + File.separator);

				// initialize your choice variable

				String choice = "";

				// Display instructions

				StringBuilder sb2 = new StringBuilder();

				sb2.append("=================================================================================\n");

				sb2.append("\n");

				sb2.append("                         Progrsm Activity Choices:\n");

				sb2.append("                         a - Add a Text File\n");

				sb2.append("                         b - Delete s Text File \n");

				sb2.append("                         c - Search for a Text File\n");

				sb2.append("                         d - Display List of Current Files\n");

				sb2.append("                         e - Close Program\n");

				sb2.append("\n");

				sb2.append("\n");

				sb2.append("               Please please place your cursor on the console\n");

				sb2.append("                       then type s desired choice\n");

				sb2.append("                       then click the enter key:\n");

				System.out.println(sb2);

				// place scanned choice into the choice variable

				choice = scanner.nextLine();

				// Switch statement

				switch (choice) {

				case "a":

					roll = 0;

					System.out.println("                   Add a file");

					System.out.println(
							"                   Place Cursor on the Console and Type a Desired file name then click Enter");

					String a = scanner.nextLine(); // get a filename from the user less the .txt file extension

					File f1a = new File(directory + File.separator + "stuff" + File.separator + a + ".txt");

					if (f1a.exists() && !f1a.isDirectory()) {

						getFileManifest(directory + File.separator + "stuff" + File.separator); // lets display the
																								// updated manifest

						endModuleMessage();

					} else {

						try {

							f1a.createNewFile();

							System.out.println("file " + a + ".txt succesfully addedto the manifest\n\n");

						} catch (IOException e) {

							e.printStackTrace();

							System.out.println("file " + a + ".txt not addedto the manifest\n\n");

							endModuleMessage();

						}

					}

					getFileManifest(directory + File.separator + "stuff" + File.separator); // lets display the updated
																							// manifest

					endModuleMessage();

					roll = scanner.nextInt(); // and leave

					break;

				case "b":

					roll = 0;

					System.out.println("                    Delete a File");

					System.out.println("Place Cursor on the Console and Type a Desired file name then click Enter\n\n");

					String b = scanner.nextLine();

					File f1b = new File(directory + File.separator + "stuff" + File.separator + b + ".txt");

					if (f1b.exists() && !f1b.isDirectory()) {

						if (f1b.delete()) { // simply delete the file from the File API .delete method

							System.out.println(b + ".txt fle deleted\n\n");

							getFileManifest(directory + File.separator + "stuff" + File.separator); // lets display the
																									// updated manifest

							System.out.println("\n\nType a numerical one in the console to start over.");

							roll = scanner.nextInt();

						} else {

							System.out.println(b + "txt not deleted");

							endModuleMessage();

							roll = scanner.nextInt();

						}

					} else {

						System.out.println(b + "txt on file.");

						endModuleMessage();

						roll = scanner.nextInt();

					}

					break;

				case "c":

					roll = 0;

					System.out.println("                    Search for a file");

					System.out.println(
							"                   Place Cursor on the Console and Type a Desired file name then click Enter");

					String c = scanner.nextLine(); // pick a file

					File f3 = new File(directory + File.separator + "stuff" + File.separator + c + ".txt");

					if (f3.exists() && !f3.isDirectory()) { // determine if it exsists

						System.out.println("                   File Exists");

						endModuleMessage();

						roll = scanner.nextInt(); // leave

					} else {

						System.out.println("                   File Does Not Exists");

						endModuleMessage();

						roll = scanner.nextInt();

					}

					break;

				case "d":

					roll = 0;

					System.out.println("                    Curent File Manifest");

					getFileManifest(System.getProperty("user.dir") + File.separator + "stuff" + File.separator);

					endModuleMessage();

					roll = scanner.nextInt();

					break;

				case "e":

					roll = 0;

					System.out.println("That's All Folks!");

					System.exit(0); // system exit it seems to just stop the program no really clear the screen

					break;

				default:

					// if we type a bad choice we return again

					roll = 1;

					break;

				}

			}

			// close the scanner object

			scanner.close();

		} catch (Exception e) {

			// System.out.println(e.getMessage());

		}

	}

	/**
	 * 
	 * Method to check for required base folder
	 * 
	 * if missing create and confirm
	 * 
	 * @param dir
	 * 
	 */

	public static void checkForBaseFolderthenCreate(String dir) {

		File fz = new File(dir + File.separator + "stuff");

		if (fz.exists()) {

			System.out.println("File Folder Structure already exists, full speed ahead!\n\n");

		} else {

			fz.mkdir();

			System.out.println("File Folder Structure is now ready, anchors away!\n\n");

		}

	}

	/**
	 * 
	 * Method to display current text files in ascending order
	 *
	 * 
	 * 
	 * @param path
	 * 
	 */

	public static void getFileManifest(String path) {

		File folder = new File(path);

		File[] files = folder.listFiles();

		ArrayList<String> ar = new ArrayList<String>();

		for (File f : files) {

			String fl = f + "";

			int g = fl.lastIndexOf("\\") + 1;

			ar.add((f + "").substring(g));

		}

		Collections.sort(ar);

		ArrayList<String> asd = ar;

		System.out.println("     Current Available Text Files on Record:");

		for (String art : asd) {

			System.out.println("      " + art);

		}

		System.out.println("");

		System.out.println("");

	}

	public static void endModuleMessage() {

		System.out.println("Type a numerical one in the console to start over.");

		System.out.println("Type a numerical zero in the console to start end the program.");

	}

}
