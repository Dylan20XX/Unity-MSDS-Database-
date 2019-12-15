package Screens;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import Objects.Database;
import Objects.Material;
import Objects.Project;
import Objects.User;
import Utility.Assets;
import Utility.FileInput;
import Utility.UnityApplication;
	/** * @author Kavish Urethireswaran
	 * Date: December 15, 2019
	 * Course: ICS4U1
	 * Topic: Unity Project
	 * Title: ProjectListScreen
	 * Description: This class controls the ProjectList Screen where a user can choose to 
	 * 				create a project, delete a project, and/or edit a project. They can also delete
	 * 				themselves from our database using the "Delete User" option in the menubar.
	 * 				The user will be sent here after loggin in and whenever they choose to edit a project 
	 * 				while using the program
	 */
@SuppressWarnings({ "serial", "unused" })
public class UnityProjectListScreen extends JFrame implements ActionListener {

	JPanel projectListPanel = new JPanel();
	JMenuBar menu = new JMenuBar();
	JMenu accountMenu = new JMenu("Account");
	JMenuItem deleteUserMenuItem = new JMenuItem("Delete User");
	JMenuItem logoutMenuItem = new JMenuItem("Logout");
	//JButton createButton = new JButton("Create New Project");
	JButton createButton = new JButton(Assets.createButton);
	JButton editButton = new JButton("Edit");
	//JButton deleteButton = new JButton("Delete");
	JButton deleteButton = new JButton(Assets.deleteButton);
	JScrollPane projectsScrollPane = new JScrollPane();
	JLabel titleLabel = new JLabel("Create Or Edit Projects");
	ArrayList<JButton> list = new ArrayList<JButton>();
	ArrayList<JLabel> namelist = new ArrayList<JLabel>();
	boolean clicked = false;
	int numproj = 0;
	JPanel scrollPanel = new JPanel();
	JPanel labelScrollPanel = new JPanel();
	JPanel buttonScrollPanel = new JPanel();

	public UnityProjectListScreen() {
		panelSetup();
		frameSetup();
		setupProjectList();
	}

	private void frameSetup() {
		setSize(1280, 720);
		setLayout(null);
		add(projectListPanel);
		setVisible(true);
		getContentPane().setBackground(Color.blue);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Unity");
		setResizable(true);
		setJMenuBar(menu);
	}

	private void panelSetup() {
		projectListPanel.setBounds(0, 0, 1270, 710);
		projectListPanel.setLayout(null);
		//projectListPanel.setBackground(new Color(75,0,130));
		projectListPanel.setBackground(new Color(82,66,209));
		//projectListPanel.setBackground(new Color(140,100,209));
		accountMenu.add(logoutMenuItem);
		logoutMenuItem.addActionListener(this);
		accountMenu.add(deleteUserMenuItem);
		menu.add(accountMenu);
		menu.add(accountMenu);
		deleteUserMenuItem.addActionListener(this);

		titleLabel.setBounds(200, -25, 1000, 200);
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
		titleLabel.setForeground(new Color(255,0,255));
		projectListPanel.add(titleLabel);

		createButton.setBounds(235, 475, 200, 100);
		createButton.setBackground(Color.LIGHT_GRAY);
		createButton.addActionListener(this);
		projectListPanel.add(createButton);

		editButton.setBounds(546, 475, 200, 100);
		editButton.setFont(new Font("Arial", Font.BOLD, 46));
		editButton.setBackground(Color.LIGHT_GRAY);
		editButton.addActionListener(this);
		projectListPanel.add(editButton);

		deleteButton.setBounds(857, 475, 200, 100);
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.addActionListener(this);
		projectListPanel.add(deleteButton);

		scrollPanel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
		scrollPanel.setBounds(0, 0, 750, 250);
		buttonScrollPanel.setLayout(new BoxLayout(buttonScrollPanel, BoxLayout.Y_AXIS));
		scrollPanel.add(buttonScrollPanel);
		labelScrollPanel.setLayout(new BoxLayout(labelScrollPanel, BoxLayout.Y_AXIS));
		scrollPanel.add(labelScrollPanel);

		projectsScrollPane = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.X_AXIS));
		projectsScrollPane.setBounds(280, 150, 750, 250);
		scrollPanel.setBackground(Color.DARK_GRAY);
		projectListPanel.add(projectsScrollPane);
	}

	// This method sets up the list of saved game buttons
	private void setupProjectList() {

		// reset the array lists
		Database.projectList.clear();

		// setup the world select buttons
		System.out.println(Database.currentUser);
		File files = new File(String.format("Users/%s", Database.currentUser));
		// System.out.println(files.listFiles().length);

		for (int i = 0; i < files.listFiles().length; i++) {
			FileInput.readProject(files.listFiles()[i].getName());
		}

		for (Project currentProject : Database.projectList) {
			currentProject.componentSetup();
			currentProject.getSelectButton().addActionListener(this);
			buttonScrollPanel.add(currentProject.getSelectButton());
			labelScrollPanel.add(currentProject.getNameLabel());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(Project currentProject: Database.projectList) {

			if(e.getSource() == currentProject.getSelectButton()) {
				clicked = true;
				Database.currentProject = currentProject;
				for(Project unselectedProject: Database.projectList) 
					if(!unselectedProject.getName().equals(currentProject.getName()))
						unselectedProject.getSelectButton().setBackground(null);
				currentProject.getSelectButton().setBackground(Color.YELLOW);

			}

		}
		if(e.getSource() == logoutMenuItem){
			this.dispose();
			UnityApplication.main(null);
		}
		if(e.getSource() == createButton){

			removeActionListeners();
			FileInput.readMaterials();
			Database.currentProject = new Project("New Project");
			new UnityMaterialSelectionScreen();
			this.dispose();

			//			list.add(new JButton());
			//			list.get(numproj).setSize(100, 70);
			//			list.get(numproj).setMaximumSize(list.get(numproj).getSize());
			//			list.get(numproj).setMinimumSize(list.get(numproj).getSize());
			//			list.get(numproj).setPreferredSize(list.get(numproj).getSize());
			//			list.get(numproj).setText("edit");
			//			list.get(numproj).setBounds(0, 0, 200, 100);
			//			buttonScrollPanel.add(list.get(numproj));	
			//
			//			namelist.add(new JLabel());
			//			namelist.get(numproj).setSize(650, 70);
			//			namelist.get(numproj).setMaximumSize(namelist.get(numproj).getSize());
			//			namelist.get(numproj).setMinimumSize(namelist.get(numproj).getSize());
			//			namelist.get(numproj).setPreferredSize(namelist.get(numproj).getSize());
			//			namelist.get(numproj).setText("Project #" + (numproj+1));
			//			namelist.get(numproj).setBounds(200, 0, 200, 100);
			//			labelScrollPanel.add(namelist.get(numproj));

			scrollPanel.revalidate();
			scrollPanel.repaint();

			numproj++;
		}

		if (e.getSource() == editButton) {
			if(clicked == true){
				removeActionListeners();
				FileInput.readMaterials();
				setMaterialQuantities();
				
				Database.currentProject.getMaterialList().clear();
				
				//Add materials to the current project
				for(Material currentMaterial: Database.materials) {
					if(currentMaterial.getQuantity() != 0) {
						
						Material m = new Material();
						m.copyMaterial(currentMaterial);
						Database.currentProject.getMaterialList().add(currentMaterial);
						
					}
				}
				
				new UnityReportScreen();
				this.dispose();
			}
		}
		if (e.getSource() == deleteButton){
			if(clicked == true){

				removeActionListeners();

				//Remove the button and label
				buttonScrollPanel.remove(Database.currentProject.getSelectButton());
				labelScrollPanel.remove(Database.currentProject.getNameLabel());
				//Repaint and revalidate 
				repaint();
				revalidate();
				//Remove the project from project list
				Database.projectList.remove(Database.currentProject);

				//Delete the file
				deleteCurrentProject();

				//Set the current project to null
				Database.currentProject = null;


				clicked = false;

			}
		}

		if (e.getSource() == deleteUserMenuItem) {

			String confirm = null;
			User currentUser = new User();

			for(User user: Database.users) {

				if(user.getUser().equals(Database.currentUser)) {
					currentUser = user;
				}

			}

			System.out.println("Request to delete user");

			// OptionPane that pops up to enter the name of the user wanting to be deleted
			String pass = JOptionPane.showInputDialog("Deleting your account will delete all of your projects\nEnter your passowrd to confirm:");
			System.out.println(pass + " " + currentUser.getPass());
			System.out.println(Database.currentUser);
			
			if (pass != null && pass.equals(currentUser.getPass())) {
				System.out.println("deleting");
				deleteCurrentUser();
			}


		}

	}

	// This method removes the action listers from material buttons
	// Use this method before changing screens
	private void removeActionListeners() {

		for (Project currentProject : Database.projectList) {
			currentProject.getSelectButton().removeActionListener(this);
		}

	}

	private void setMaterialQuantities() {

		for (Material currentMaterial : Database.currentProject.getMaterialList()) {

			for (Material currentDatabaseMaterial : Database.materials) {

				if (currentMaterial.getName().equals(currentDatabaseMaterial.getName())) {
					currentDatabaseMaterial.setQuantity(currentMaterial.getQuantity());
				}

			}

		}

	}

	private void deleteCurrentProject() {

		String projectData = String.format("Users/%s/%s", Database.currentUser, Database.currentProject.getName());
		File projectDataFilepath = new File(projectData);

		if(projectDataFilepath.exists()) {
			System.out.println(Database.currentProject.getName() + " was deleted");
			projectDataFilepath.delete();
		} else {
			System.out.println("Couldn't delete project");
		}

	}

	private void deleteCurrentUser() {

		//Remove the deleted user from the user list
		for(int i = 0; i < Database.users.size(); i++) {

			if(Database.users.get(i).getUser().equals(Database.currentUser)) {
				Database.users.remove(i);
				break;
			}

		}

		//Re-write the login file
		String file = "Login.csv";
		File filepath = new File(file);

		try {

			//Write data to a file
			PrintWriter pr = new PrintWriter(file);

			pr.print("Username,Password,");

			for(User currentUser: Database.users) {	
				pr.print("\n");
				pr.print(currentUser.getUser() + "," + currentUser.getPass() + ",");
			}

			pr.close();

		} catch (FileNotFoundException e) {
			System.out.println("Save Failed");
		}

		//Delete the user's folder
		String userFolder = String.format("Users/%s", Database.currentUser);
		File userFolderFilepath = new File(userFolder);

		String[] fileList = userFolderFilepath.list();

		for(String projectFile: fileList){

			File currentFile = new File(userFolderFilepath.getPath(), projectFile);
			currentFile.delete();

		}

		userFolderFilepath.delete();

		Database.currentUser = null;

		new UnityLoginScreen();
		this.dispose();

	}


}
