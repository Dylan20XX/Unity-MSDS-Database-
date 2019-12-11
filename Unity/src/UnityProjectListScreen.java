import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import java.awt.*;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class UnityProjectListScreen extends JFrame implements ActionListener {

	JPanel projectListPanel = new JPanel();
	JMenuBar menu = new JMenuBar();
	JMenu file = new JMenu("file");
	JMenu edit = new JMenu("Edit");
	JMenuItem deleteUser = new JMenuItem("Delete User");
	JMenuItem SAVE = new JMenuItem("SAVE");
	JMenuItem BACK = new JMenuItem("BACK");
	JButton createButton = new JButton("CREATE NEW PROJECT");
	JButton editButton = new JButton("Edit");
	JButton deleteButton = new JButton("Delete");
	JScrollPane projectsScrollPane = new JScrollPane();
	JLabel titleLabel = new JLabel("Create or Edit Projects");
	ArrayList<JButton> list = new ArrayList<JButton>();
	ArrayList<JLabel> namelist = new ArrayList<JLabel>();
	boolean clicked = false;
	int numproj = 0;
	JPanel scrollPanel = new JPanel();
	JPanel labelScrollPanel = new JPanel();
	JPanel buttonScrollPanel = new JPanel();

	// String for name deleted
	String deletename;

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
		setTitle("PROJECT LIST");
		setJMenuBar(menu);
	}

	private void panelSetup() {
		projectListPanel.setBounds(0, 0, 1270, 710);
		projectListPanel.setLayout(null);
		projectListPanel.setBackground(new Color(191, 231, 247));
		file.add(SAVE);
		file.add(BACK);
		edit.add(deleteUser);
		menu.add(file);
		menu.add(edit);
		deleteUser.addActionListener(this);

		titleLabel.setBounds(450, 0, 750, 100);
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 48));
		projectListPanel.add(titleLabel);

		createButton.setBounds(235, 475, 200, 100);
		createButton.addActionListener(this);
		projectListPanel.add(createButton);

		editButton.setBounds(546, 475, 200, 100);
		editButton.addActionListener(this);
		projectListPanel.add(editButton);

		deleteButton.setBounds(857, 475, 200, 100);
		deleteButton.addActionListener(this);
		projectListPanel.add(deleteButton);

		scrollPanel.setBounds(0, 0, 750, 250);
		buttonScrollPanel.setLayout(new BoxLayout(buttonScrollPanel, BoxLayout.Y_AXIS));
		scrollPanel.add(buttonScrollPanel);
		labelScrollPanel.setLayout(new BoxLayout(labelScrollPanel, BoxLayout.Y_AXIS));
		scrollPanel.add(labelScrollPanel);

		projectsScrollPane = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.X_AXIS));
		projectsScrollPane.setBounds(280, 100, 750, 250);
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
			}
			
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
			new UnityReportScreen();
			this.dispose();
			}
		}
		
		
		
		if (e.getSource() == deleteButton){
			if(clicked == true){
			removeActionListeners();
			
			clicked = false;
			}
		}
		
		if (e.getSource() == deleteUser) {
			String confirm = null;
			
			for(User currentUser: Database.users) {
				
			System.out.println("Request to delete user");
			
			// OptionPane that pops up to enter the name of the user wanting to be deleted
			deletename = JOptionPane.showInputDialog("Enter your passowrd:");
			System.out.println(deletename);
			System.out.println(Database.currentUser);
			
			if (deletename == currentUser.getPass())
				confirm = JOptionPane.showInputDialog("Type Yes to confirm deleting:" + Database.currentUser);
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
}