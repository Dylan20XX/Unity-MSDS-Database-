package Objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * @author everyone
 */
public class Database {
	/**
	 * This class sorts Materials. 
	 * @param MDSD Database, Login, Users
	 */
	//Current user and project variables
	public static String currentUser;
	public static Project currentProject;
	public static ArrayList<Material> currentProjectMaterials = new ArrayList<Material>();
	
	//Store the users, projects, and all materials from the .csv file
	public static ArrayList<Project> projectList = new ArrayList<Project>();
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Material> materials = new ArrayList<Material>();
	
	//Sorts materials in alphabetical order
	/**
	 * @return Sorted Materials in Alpha order
	 */
	public static Comparator<Material> alphaSorter = new Comparator<Material>(){
		public int compare(Material mat1, Material mat2) {
			return mat1.getName().compareTo(mat2.getName());
		}
	};
	
	//Sorts materials in order of their environmental impact
	public static Comparator<Material> environmentSorter =new Comparator<Material>(){
		public int compare(Material mat1, Material mat2) {
			return Integer.compare(mat1.getEnvironmentImpact(), mat2.getEnvironmentImpact());
		}
	};
	
	//Sorting methods
	public static void sortAlpha() {
		Collections.sort(materials, alphaSorter);
	}
	
	public static void sortEnvironment() {
		Collections.sort(materials, environmentSorter);
	}
	
}
