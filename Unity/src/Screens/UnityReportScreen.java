package Screens;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Objects.Database;
import Objects.Material;
import Utility.Assets;

public class UnityReportScreen extends JFrame implements ActionListener {
	
	private String projectName;
	private String projectDescription;
	private String projectSources;
	
	private JMenuBar menubar = new JMenuBar();
	
	private JLabel projectNameLabel = new JLabel("<html><font color='black'>Project Name</font></html>");
	private JLabel userInputLabel = new JLabel("<html><font color='black'>Project Description</font></html>");
	private JLabel sourcesLabel = new JLabel("<html><font color='black'>Information Sources</font></html>");	
	
	private JTextField projectNameTextArea = new JTextField();
	private JTextArea descriptionTextArea = new JTextArea();
	private JTextArea sourcesTextArea = new JTextArea();	
	private JScrollPane descriptionScrollPane;
	private JScrollPane sourcesScrollPane;
	
	private JPanel materialPanel = new JPanel();
	private JScrollPane materialScrollPane;
	
	//Panels within material panel
	private JPanel quantityButtonPanel = new JPanel();
	private JPanel materialQuantityPanel = new JPanel();
	private JPanel infoButtonPanel = new JPanel();
	private JPanel materialNamePanel = new JPanel();
	private JPanel environmentPanel = new JPanel();
	
	private JButton saveButton = new JButton(Assets.saveButton);
	private JButton exitButton = new JButton("<html><center><font color='black'>Exit Without<br>Saving</font></center></html>");
	private JButton materialSelectButton = new JButton("<html><center><font color='black'>Return to<br>Material Selection</font></center></html>");
	
	//Menu bar
	private JMenu fileMenu = new JMenu ("File");
	private JMenuItem fileSave = new JMenuItem ("Save");
	private JMenuItem fileExport = new JMenuItem ("Export as .txt file");
    
	private JMenu exitMenu = new JMenu ("Exit");
	private JMenuItem exitProgram = new JMenuItem ("Exit Program");
	private JMenuItem exitSave = new JMenuItem ("Exit & Save");

	
	public UnityReportScreen() {
		setContentPane(new JLabel(Assets.reportBackground));
		menuBarSetup();
		textAreaSetup();
		materialPanelSetup();
		addMaterialButtons();
		buttonSetup();
		frameSetup();
	}
	
	//This method sets up the menu bar
	private void menuBarSetup() {
		
        //construct preComponents
        fileSave.addActionListener(this);
        fileMenu.add (fileSave);
        fileExport.addActionListener(this);
        fileMenu.add (fileExport);
        
        exitProgram.addActionListener(this);
        exitMenu.add (exitProgram);
        exitSave.addActionListener(this);
        exitMenu.add (exitSave);
        
        menubar.add (fileMenu);
        menubar.add (exitMenu);
        
        menubar.setBounds (0, 0, 1280, 25);
        
        add(menubar);
	}
	
	private void textAreaSetup() {
		
		projectNameLabel.setBounds (35, 100, 400, 20);
		//projectNameLabel.setBackground(Color.ORANGE);
		projectNameLabel.setBackground(new Color(140,100,209));
		projectNameLabel.setOpaque(true);
		projectNameLabel.setFont(new Font( "Arial", Font.BOLD, 20));
		userInputLabel.setBounds (35, 150, 400, 20);
		//userInputLabel.setBackground(Color.ORANGE);
		userInputLabel.setBackground(new Color(140,100,209));
		userInputLabel.setOpaque(true);
		userInputLabel.setFont(new Font( "Arial", Font.BOLD, 20));
		sourcesLabel.setBounds (35, 530, 400, 20);
		//sourcesLabel.setBackground(Color.ORANGE);
		sourcesLabel.setBackground(new Color(140,100,209));
		sourcesLabel.setOpaque(true);
		sourcesLabel.setFont(new Font( "Arial", Font.BOLD, 20));
		
		add(projectNameLabel);
		add(userInputLabel);
		add(sourcesLabel);
		
		projectNameTextArea.setBounds (35, 120, 400, 20);
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setWrapStyleWord(true);
		sourcesTextArea.setLineWrap(true);
		sourcesTextArea.setWrapStyleWord(true);
		
		descriptionScrollPane = new JScrollPane(descriptionTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descriptionScrollPane.setBounds (35, 170, 400, 350);
		
		sourcesScrollPane = new JScrollPane(sourcesTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sourcesScrollPane.setBounds (35, 550, 400, 105);
		
		projectNameTextArea.setText(Database.currentProject.getName());
		descriptionTextArea.setText(Database.currentProject.getProjectDescription());
		sourcesTextArea.setText(Database.currentProject.getSources());
		
		add(projectNameTextArea);
		add(descriptionScrollPane);
		add(sourcesScrollPane);
		
	}
	
	private void materialPanelSetup() {
		
		materialPanel.setLayout(new BoxLayout(materialPanel, BoxLayout.X_AXIS));
		materialPanel.setBackground(Color.DARK_GRAY);
		
		//Panels within the material panel
		quantityButtonPanel.setLayout(new BoxLayout(quantityButtonPanel, BoxLayout.Y_AXIS));
		quantityButtonPanel.setBackground(Color.DARK_GRAY);
		materialPanel.add(quantityButtonPanel);
		materialQuantityPanel.setLayout(new BoxLayout(materialQuantityPanel, BoxLayout.Y_AXIS));
		materialQuantityPanel.setBackground(Color.LIGHT_GRAY);
		materialPanel.add(materialQuantityPanel);
		infoButtonPanel.setLayout(new BoxLayout(infoButtonPanel, BoxLayout.Y_AXIS));
		infoButtonPanel.setBackground(Color.DARK_GRAY);
		materialPanel.add(infoButtonPanel);
		materialNamePanel.setLayout(new BoxLayout(materialNamePanel, BoxLayout.Y_AXIS));
		materialNamePanel.setBackground(Color.WHITE);
		materialPanel.add(materialNamePanel);
		environmentPanel.setLayout(new BoxLayout(environmentPanel, BoxLayout.Y_AXIS));
		environmentPanel.setBackground(Color.WHITE);
		materialPanel.add(environmentPanel);
		
		//Add the scroll pane 
		materialScrollPane = new JScrollPane(materialPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		materialScrollPane.setBounds(450,120,800,400);
		add(materialScrollPane);
		
	}
	
	//This method sets up the save and back buttons
	private void buttonSetup() {
		
		materialSelectButton.addActionListener(this);
		materialSelectButton.setFont(new Font( "Arial", Font.PLAIN, 24));
		materialSelectButton.setBackground(Color.ORANGE);
		materialSelectButton.setBackground(new Color(140,100,209));
		materialSelectButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		materialSelectButton.setBounds (450, 550, 200, 105);
		add(materialSelectButton);
		
		exitButton.addActionListener(this);
		exitButton.setFont(new Font( "Arial", Font.PLAIN, 24));
		exitButton.setBackground(Color.ORANGE);
		exitButton.setBackground(new Color(140,100,209));
		exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		exitButton.setBounds (670, 550, 200, 105);
		add(exitButton);
		
		saveButton.addActionListener(this);
		saveButton.setFont(new Font( "Arial", Font.PLAIN, 24));
		saveButton.setBackground(Color.ORANGE);
		saveButton.setBackground(new Color(140,100,209));
		saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		saveButton.setBounds (1050, 550, 200, 105);
		add(saveButton);
		
	}
	
	//This method sets up the frame
	private void frameSetup() {
		
		//Set the title and frame size
		setTitle("Unity");
		setSize(1280, 720);
		setLayout(null);
		//getContentPane().setBackground(new Color(191,231,247)); //Blue
		//getContentPane().setBackground(new Color(82,66,209)); //Dark purple
		//getContentPane().setBackground(new Color(140,100,209)); //Light purple
		
		//Prevent the program from running when the frame is closed, prevent the 
		//frame from being resized, and make the frame visible
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	
	private void addMaterialButtons() {
		
		quantityButtonPanel.removeAll();
		infoButtonPanel.removeAll();
		materialNamePanel.removeAll();
		materialQuantityPanel.removeAll();
		environmentPanel.removeAll();
		
		removeActionListeners();
		
		for(Material currentMaterial: Database.currentProject.getMaterialList()) {
			
			currentMaterial.setupComponentsReport();
			
			currentMaterial.getQuantityButton().addActionListener(this);
			quantityButtonPanel.add(currentMaterial.getQuantityButton());
			
			currentMaterial.getInfoButton().addActionListener(this);
			infoButtonPanel.add(currentMaterial.getInfoButton());
			
			materialNamePanel.add(currentMaterial.getNameLabel());
			
			materialQuantityPanel.add(currentMaterial.getQuantityField());
			
			environmentPanel.add(currentMaterial.getEnvironmentLabel());
			
		}
		
		repaint();
		revalidate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(Material currentMaterial: Database.currentProject.getMaterialList()) {
			
			if(e.getSource() == currentMaterial.getQuantityButton()) {
				if(!currentMaterial.getQuantityField().getText().matches("-?\\d+"))
					return;
				currentMaterial.setQuantity(Integer.parseInt(currentMaterial.getQuantityField().getText()));
				return;
			} else if (e.getSource() == currentMaterial.getInfoButton()) {
				removeActionListeners();
				new UnityMaterialInfoScreen(currentMaterial, 1);
				this.dispose();
				return;
			}
			
		}
		
		if(e.getSource() == saveButton || e.getSource() == exitSave) {
			removeActionListeners();
			if(!checkValidProjectName())
				return;
			saveProject();
			new UnityProjectListScreen();
			this.dispose();
		} else if(e.getSource() == materialSelectButton) {
			removeActionListeners();
			Database.currentProject.setName(projectNameTextArea.getText());
			Database.currentProject.setProjectDescription(descriptionTextArea.getText());
			Database.currentProject.setSources(sourcesTextArea.getText());
			new UnityMaterialSelectionScreen();
			this.dispose();
		} else if (e.getSource() == exitButton) {
			removeActionListeners();
			new UnityProjectListScreen();
			this.dispose();
		} else if(e.getSource() == fileSave) {
			if(!checkValidProjectName())
				return;
			saveProject();
		} else if(e.getSource() == exitProgram) {
			System.exit(0);
		} else if(e.getSource() == fileExport) {
			if(!checkValidProjectName())
				return;
			exportProject();
		} 
		
	}
	
	//This method removes the action listers from material buttons
	private void removeActionListeners() {
		
		for(Material currentMaterial: Database.currentProject.getMaterialList()) {
			currentMaterial.getQuantityButton().removeActionListener(this);
			currentMaterial.getInfoButton().removeActionListener(this);
		}
		
	}
	
	private boolean checkValidProjectName() {
		//A filename can't contain any of the following characters
		//\/:*?"<>|
		if(projectNameTextArea.getText().contains("\\") || projectNameTextArea.getText().contains("/") || 
				projectNameTextArea.getText().contains(":") || projectNameTextArea.getText().contains("*") || 
				projectNameTextArea.getText().contains("?") || projectNameTextArea.getText().contains("\"") || 
				projectNameTextArea.getText().contains("<") || projectNameTextArea.getText().contains(">") || 
				projectNameTextArea.getText().contains("|") || projectNameTextArea.getText().isEmpty() || projectNameTextArea.getText().matches("[ ]+")) {
			JOptionPane.showMessageDialog(null, "A filename can't contain any of the following characters:\n\\/:*?\"<>|","INVALID", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			projectName = projectNameTextArea.getText();
			projectDescription = descriptionTextArea.getText();
			projectSources = sourcesTextArea.getText();
			return true;
		}
		
	}
	
	private void saveProject() {
		
		String file = String.format("Users/%s/%s", Database.currentUser, projectName);
		File filepath = new File(file);

		//if(!filepath.exists() && !filepath.isDirectory()) {
		if(!filepath.isDirectory()) {
			
			try {

				//Write data to a file
				PrintWriter pr = new PrintWriter(file);
				
				pr.println(projectName);
				
				//Replace all carriage returns with @
				pr.print(projectDescription.replace("\n", "@"));
				pr.println();
				
				pr.print(projectSources.replace("\n", "@"));
				pr.println();
				
				pr.println(Database.currentProject.getMaterialList().size());
				for(Material currentMaterial: Database.currentProject.getMaterialList()) {
					pr.println(currentMaterial.getName() + "\n" + currentMaterial.getQuantity());
				}
				
				pr.close();

			} catch (FileNotFoundException e) {
				System.out.println("Save Failed");
			}

		}
		
	}
	
	//This allows the user to export the project as a text file
	private void exportProject() {
		
		//Open a file dialog
	    FileDialog fileDialog = new FileDialog((Frame) null, "Select Where to Save the File");
	    fileDialog.setMode(FileDialog.SAVE);
	    fileDialog.setVisible(true);
	    //String file = fileDialog.getFile();
	    String file = fileDialog.getDirectory() + fileDialog.getFile() + ".txt";
	    System.out.println(file + ".txt");
	    File filepath = new File(file);
	    
		if(!filepath.isDirectory()) {
			
			try {

				//Write data to a file
				PrintWriter pr = new PrintWriter(file);
				
				pr.println("Project Name: " + projectName+ "\n");
				
				pr.println("Project Description: ");
				pr.print(projectDescription);
				pr.println("\n");
				
				pr.println("Sources: ");
				pr.print(projectSources);
				pr.println("\n");
				
				pr.println("Number of Materials: " + Database.currentProject.getMaterialList().size());
				pr.println();
				
				for(Material currentMaterial: Database.currentProject.getMaterialList()) {
					
					pr.println(currentMaterial.getName()); 
					pr.println("Quantity: " + currentMaterial.getQuantity());
					pr.println("Brand: " + currentMaterial.getBrand());
					pr.println("Purchased From: " + currentMaterial.getHyperlink());
					pr.println("Storage Area: " + currentMaterial.getStorageArea());
					pr.println("Precautions: " + currentMaterial.getPrecautions());
					pr.println("Toxic: " + currentMaterial.getToxic());
					pr.println("Stability: " + currentMaterial.getStability());
					pr.println("First Aid Measures: " + currentMaterial.getFirstAid());
					pr.println("Dangers: " + currentMaterial.getDangers());
					pr.println("MSDS Link: " + currentMaterial.getMsdsLink());
					pr.println("Environmental Impact Rating: " + currentMaterial.getEnvironmentImpact());
					pr.println();
					
				}
				
				pr.close();

			} catch (FileNotFoundException e) {
				System.out.println("Save Failed");
			}

		} else {
			System.out.println("Invalid Filepath");
		}
	    
	}
	
}
