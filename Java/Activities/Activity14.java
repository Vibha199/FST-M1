package activities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			File file=new File("C:\\Users\\SwagatikaBiswal\\Documents\\FST\\newfile.txt");
			boolean fStatus = file.createNewFile();
			if(fStatus) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists at this path.");
                
            }
 
			//get the file Object
			File fileUtil = FileUtils.getFile("C:\\Users\\SwagatikaBiswal\\Documents\\FST\\newfile.txt");
			//Read file
			System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
			//Create directory
			File destDir = new File("resources");
			//Copy file to directory
			FileUtils.copyFileToDirectory(file, destDir);
			//Get file from new directory
			File newFile = FileUtils.getFile(destDir, "newfile.txt");
			//Read data from file
			String newFileData = FileUtils.readFileToString(newFile, "UTF8");
			System.out.println("Data in new file: " + newFileData);
		} catch(IOException errMessage) {
            System.out.println(errMessage);
		

	}
		
	}	
}