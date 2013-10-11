package net.skillfullearning.contactslist;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import android.os.Environment;

/**
 * Handles storing of contacts in a text file.
 * It provides a way to open/create a text 
 * file for storing all contact's information
 * and for reading stored data.
 * @author cyb
 *
 */
public class ContactStore {

	private PrintWriter fileWriter = null; // For storing logged results on a file
	
	public ContactStore() {
		// Allow file appending
		boolean allowAppend = true;
				
		// Capture file extension (i.e. CSV, TXT)
		String captureFileExt = "TXT";
			
		// Create/open file
		File captureFileName = new File(Environment.getExternalStorageDirectory(), "capture." + captureFileExt);
			
		// Initialize fileWriter
		try { fileWriter = new PrintWriter(new FileWriter(captureFileName, allowAppend)); }
		catch( IOException ex ) {System.out.println("ContactStore: Error creating/opening file.");} 
	}
	
	
	/**
	 * Stores all data of contact into the 
	 * capture text file. Returns true if
	 * contact was stored successfully. 
	 * @param contact The contact to be stored.
	 * @return boolean If stored successfully, return true. Return false, otherwise.
	 */
	public boolean storeContact(Contact contact) {
		
		// Get contact data into a string array
		String[] contactData = {
				contact.getFirstname(),
				contact.getLastname(),
				contact.getCellphone(),
				contact.getWorkphone(),
				contact.getEmail()				
		};
		
		// Format data into a newline separated string
		String stringToAppend = "";
		for (String d : contactData) {
			stringToAppend += d + "\n";			
		}		
		
		// Try to append it to capture file
		try {
			fileWriter.print(stringToAppend);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

	public void closeCaptureFile() {
		if (fileWriter != null) {
			fileWriter.close();
			fileWriter = null;		
		}
	}
	
}
