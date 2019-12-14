import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Database {
	
	public static String currentUser;
	public static Project currentProject;
	public static ArrayList<Material> currentProjectMaterials = new ArrayList<Material>();
	
	public static ArrayList<Project> projectList = new ArrayList<Project>();
	
	public static ArrayList<User> users = new ArrayList<User>();
	
	public static ArrayList<Material> materials = new ArrayList<Material>();
	
	//Sorts materials in alphabetical order
	public static Comparator<Material> alphaSorter = new Comparator<Material>(){
		public int compare(Material mat1, Material mat2) {
			return mat1.getName().compareTo(mat2.getName());
		}
	};
	
	//Sorts materials in order of their environmental impact
//	public static Comparator<Material> environmentSorter =new Comparator<Material>(){
//		public int compare(Material mat1, Material mat2) {
//			return Integer.compare(mat1.getEvironmentImpact(), mat2.getEvironmentImpact());
//		}
//	};
	
	public static void sortAlpha() {
		Collections.sort(materials, alphaSorter);
	}
	
//	public static void sortEnvironment() {
//		Collections.sort(materials, environmentSorter);
//	}
	
}
