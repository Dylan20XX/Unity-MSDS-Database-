import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
	
	public static void readMaterials() {
		
		try {
			
			Database.materials.clear();
			
			Scanner input = new Scanner(new File("MSDS Database Info.csv")); //Take input from the .csv file
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
				
				//since commas can't be used in .csv file values, use ] and input.next().replace("]", ",");
				
				//input.next(); //Material type
				
				material.setName(input.next().replace("]", ","));
				material.setBrand(input.next().replace("]", ","));
				material.setHyperlink(input.next().replace("]", ","));
				material.setStorageArea(input.next().replace("]", ","));
				material.setPrecautions(input.next().replace("]", ","));
				material.setToxic(input.next().replace("]", ","));
				material.setStability(input.next().replace("]", ","));
				material.setFirstAid(input.next().replace("]", ","));
				material.setDangers(input.next().replace("]", ","));
				material.setMsdsLink(input.next().replace("]", ","));
				input.nextLine();
				
				System.out.println(material);
				
				Database.materials.add(material);
				
			}
			
			input.close(); //Close the scanner
			
		} catch(FileNotFoundException error) {
			//Display a message if the file is not found
			System.out.println("Wrong file");
		}
		
	}
	
	//This method reads usernames and passwords from the .csv file and adds them to user arrayList
	public static void readUsers() {
		
		//NOTE: passwords may not contain commas
		
		try {
			
			Scanner input = new Scanner(new File("Login.csv")); //Take input from the .csv file
			input.useDelimiter(","); //Use commas to separate each piece of data
			
			input.nextLine(); //Skip the header line
			
			//Reads data from .csv file
			while(input.hasNextLine()) {
				
				User user = new User();
				
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
				
				//since commas can't be used in .csv file values, use ] and input.next().replace("]", ",");
				
				//input.next(); //Material type
				
				user.setUser(input.next());
				user.setPass(input.next());
				input.nextLine();
				
				System.out.println(user);
				
				Database.users.add(user);
				
			}
			
			input.close(); //Close the scanner
			
		} catch(FileNotFoundException error) {
			//Display a message if the file is not found
			System.out.println("Wrong file");
		}
		
	}
	
	public static void readProject(String filename) {
		
		if(!Database.currentUser.equals(null)) {
			
			try {
				
				Project p = new Project();
				
				Scanner input = new Scanner(new File(String.format("Users/%s/%s", Database.currentUser, filename)));
				
				p.setName(input.nextLine());
				p.setProjectDescription(input.nextLine().replace("@", "\n"));
				System.out.println(p.getName());
				p.setSources(input.nextLine().replace("@", "\n"));
				System.out.println(p.getSources());
				
				int numMaterials = input.nextInt();
				System.out.println(numMaterials);
				input.nextLine();
				
				for(int i = 0; i < numMaterials; i++) {
					Material m = new Material();
					String materialName = input.nextLine();
					System.out.println(materialName);
					int quantity = input.nextInt();
					input.nextLine();
					
					for(Material currentMaterial: Database.materials) {
						if(currentMaterial.getName().equals(materialName)) {
							m.copyMaterial(currentMaterial);
							m.setQuantity(quantity);
						}
					}
					
					p.getMaterialList().add(m);
					
				}
				
				Database.projectList.add(p);
				
				input.close(); //Close the scanner
				
			} catch (FileNotFoundException e) {
				System.out.println("Save Failed");
			}
			
			
		}
		
	}
	
}
