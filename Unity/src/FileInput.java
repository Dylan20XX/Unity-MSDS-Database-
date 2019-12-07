import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
	
	public FileInput(ArrayList<Material> materialList) {
		
		try {
			
			Scanner input = new Scanner(new File("material.csv")); //Take input from the .csv file
			input.useDelimiter(","); //Use commas to separate each piece of data
			
			input.nextLine(); //Skip the header line
			
			//Reads data from .csv file
			while(input.hasNextLine()) {
				
				Material material = new Material();
				
				//Material type
				//MaterialName
				//Brand
				//Hyperlink
				//StorageArea
				//Precautions
				//Toxic
				//Stability and Reactivity
				//First aid measures
				//Dangers
				//Link to MSDS
				
				//input.next(); //Material type
				
				material.setName(input.next());
				material.setBrand(input.next());
				material.setHyperlink(input.next());
				material.setStorageArea(input.next());
				material.setPrecautions(input.next());
				material.setToxic(input.next());
				material.setStability(input.next());
				material.setFirstAid(input.next());
				material.setDangers(input.next());
				material.setMsdsLink(input.next());
				
				materialList.add(material);
				
			}
			
			input.close(); //Close the scanner
			
		} catch(FileNotFoundException error) {
			//Display a message if the file is not found
			System.out.println("Wrong file");
		}
		
	}
	
}
