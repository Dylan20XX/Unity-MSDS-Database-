import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Project {
	
	private String name;
	private String projectDescription;
	private String sources;
	private ArrayList<Material> materialList = new ArrayList<Material>();

	//Components to be used in project list screen
	private JButton selectButton = new JButton("Select");
	private JLabel nameLabel = new JLabel();
	
	//Constructor methods
	public Project() {
	}

	//Getters and setters
	public Project(String name) {
		this.name = name;
		componentSetup();
	}
	
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

	public String getSources() {
		return sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	public ArrayList<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(ArrayList<Material> materialList) {
		this.materialList = materialList;
	}
	
	public JButton getSelectButton() {
		return selectButton;
	}

	public void setSelectButton(JButton selectButton) {
		this.selectButton = selectButton;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	//This method sets up the components to be used in the 
	public void componentSetup() {
		
		//Set up the button
		selectButton.setSize(100, 70);
		selectButton.setMaximumSize(selectButton.getSize());
		selectButton.setMinimumSize(selectButton.getSize());
		selectButton.setPreferredSize(selectButton.getSize());
		
		//Set up the label
		nameLabel.setSize(650, 70);
		nameLabel.setMaximumSize(nameLabel.getSize());
		nameLabel.setMinimumSize(nameLabel.getSize());
		nameLabel.setPreferredSize(nameLabel.getSize());
		nameLabel.setText(name);
		
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
