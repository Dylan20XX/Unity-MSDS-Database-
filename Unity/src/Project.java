import java.util.ArrayList;

public class Project {
	
	private String name;
	private String projectDescription;
	private ArrayList<Material> materialList = new ArrayList<Material>();
	
	//Constructor methods
	public Project() {
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public ArrayList<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(ArrayList<Material> materialList) {
		this.materialList = materialList;
	}
	
	//This method adds a specific quantity of a material to a project
	public void addMaterial(Material material, int count) {
		
		boolean containsMaterial = false;
		
		//Check if the project contains the material
		for(int i = 0; i < materialList.size(); i++) {
			
			//If the material is in the project, set its quantity
			if(materialList.get(i).getName().equalsIgnoreCase(material.getName())) {
				containsMaterial = true;
				materialList.get(i).setQuantity(count);
			}
		}
		
		//If the project didn't contain the material, add the material 
		//to the project and set its quantity
		if(!containsMaterial) {
			material.setQuantity(count);
			materialList.add(material);
		}
		
	}
	
}
