import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnityReportScreen extends JFrame implements ActionListener {
	
	public static void main (String[] args) {
		FileInput.readMaterials();
		new UnityReportScreen();
	}
	
	private String projectName;
	private String projectDescription;
	private String projectSources;
	
	private JMenuBar menubar = new JMenuBar();
	
	private JLabel titleLabel = new JLabel("UNITY");
	
	private JLabel projectNameLabel = new JLabel("Project Name");
	private JLabel userInputLabel = new JLabel("Project Description");
	private JLabel sourcesLabel = new JLabel("Information Sources");	
	
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
	
	private JButton saveButton = new JButton("Save Project");
	private JButton exitButton = new JButton("<html><center>Exit Without<br>Saving</center></html>");
	private JButton materialSelectButton = new JButton("<html><center>Return to<br>Material Selection</center></html>");
	
	public UnityReportScreen() {
		menuBarSetup();
		labelSetup();
		textAreaSetup();
		materialPanelSetup();
		addMaterialButtons();
		buttonSetup();
		frameSetup();
	}
	
	private void menuBarSetup() {
		
        //construct preComponents
        JMenu fileMenu = new JMenu ("File");
        JMenuItem file_option_1Item = new JMenuItem ("File Option 1");
        fileMenu.add (file_option_1Item);
        JMenuItem file_option_2Item = new JMenuItem ("File Option 2");
        fileMenu.add (file_option_2Item);
        JMenu editMenu = new JMenu ("Edit");
        JMenuItem project_1Item = new JMenuItem ("Project 1");
        editMenu.add (project_1Item);
        JMenuItem project_2Item = new JMenuItem ("Project 2");
        editMenu.add (project_2Item);
        JMenu exitMenu = new JMenu ("Exit");
        JMenuItem exit_programItem = new JMenuItem ("Exit Program");
        exitMenu.add (exit_programItem);
        JMenuItem exit___saveItem = new JMenuItem ("Exit & Save");
        exitMenu.add (exit___saveItem);
        
        menubar.add (fileMenu);
        menubar.add (editMenu);
        menubar.add (exitMenu);
        
        menubar.setBounds (0, 0, 1280, 25);
        
        add(menubar);
	}
	
	private void labelSetup() {
        titleLabel.setFont(new Font( "Serif", Font.PLAIN, 36));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds (600, 15, 480, 80);
		add(titleLabel);
	}
	
	private void textAreaSetup() {
		
		projectNameLabel.setBounds (35, 100, 400, 20);
		userInputLabel.setBounds (35, 150, 400, 20);
		sourcesLabel.setBounds (35, 530, 400, 20);
		
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
		
		//Add the scroll pane 
		materialScrollPane = new JScrollPane(materialPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		materialScrollPane.setBounds(450,120,800,400);
		add(materialScrollPane);
		
	}
	
	//This method sets up the save and back buttons
	private void buttonSetup() {
		
		materialSelectButton.addActionListener(this);
		materialSelectButton.setFont(new Font( "Arial", Font.PLAIN, 24));
		materialSelectButton.setBounds (450, 550, 200, 105);
		add(materialSelectButton);
		
		exitButton.addActionListener(this);
		exitButton.setFont(new Font( "Arial", Font.PLAIN, 24));
		exitButton.setBounds (670, 550, 200, 105);
		add(exitButton);
		
		saveButton.addActionListener(this);
		saveButton.setFont(new Font( "Arial", Font.PLAIN, 24));
		saveButton.setBounds (950, 550, 300, 105);
		add(saveButton);
		
	}
	
	//This method sets up the frame
	private void frameSetup() {
		
		//Set the title and frame size
		setTitle("Unity");
		setSize(1280, 720);
		setLayout(null);
		getContentPane().setBackground(new Color(191,231,247));
		
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
		
		removeActionListeners();
		
		for(Material currentMaterial: Database.currentProject.getMaterialList()) {
			
			currentMaterial.setupComponents();
			
			currentMaterial.getQuantityButton().addActionListener(this);
			quantityButtonPanel.add(currentMaterial.getQuantityButton());
			
			currentMaterial.getInfoButton().addActionListener(this);
			infoButtonPanel.add(currentMaterial.getInfoButton());
			
			materialNamePanel.add(currentMaterial.getNameLabel());
			
			materialQuantityPanel.add(currentMaterial.getQuantityField());
			
		}
		
		repaint();
		revalidate();
		
//		for(Material currentMaterial: Database.materials) {
//			
//			currentMaterial.setupComponents();
//			
//			currentMaterial.getQuantityButton().addActionListener(this);
//			quantityButtonPanel.add(currentMaterial.getQuantityButton());
//			
//			currentMaterial.getInfoButton().addActionListener(this);
//			infoButtonPanel.add(currentMaterial.getInfoButton());
//			
//			materialNamePanel.add(currentMaterial.getNameLabel());
//			
//			materialQuantityPanel.add(currentMaterial.getQuantityField());
//			
//		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(Material currentMaterial: Database.currentProject.getMaterialList()) {
			
			if(e.getSource() == currentMaterial.getQuantityButton()) {
				currentMaterial.setQuantity(Integer.parseInt(currentMaterial.getQuantityField().getText()));
				return;
			} else if (e.getSource() == currentMaterial.getInfoButton()) {
				removeActionListeners();
				new UnityMaterialInfoScreen(currentMaterial, 1);
				this.dispose();
				return;
			}
			
		}
		
		if(e.getSource() == saveButton) {
			if(!checkValidProjectName())
				return;
			saveProject();
			new UnityProjectListScreen();
			this.dispose();
		} else if(e.getSource() == materialSelectButton) {
			Database.currentProject.setName(projectNameTextArea.getText());
			Database.currentProject.setProjectDescription(descriptionTextArea.getText());
			Database.currentProject.setSources(sourcesTextArea.getText());
			new UnityMaterialSelectionScreen();
			this.dispose();
		} else if (e.getSource() == exitButton) {
			new UnityProjectListScreen();
			this.dispose();
		}
		
	}
	
	//This method removes the action listers from material buttons
	private void removeActionListeners() {
		
//		for(Material currentMaterial: Database.currentProjectMaterials) {
//			currentMaterial.getQuantityButton().removeActionListener(this);
//			currentMaterial.getInfoButton().removeActionListener(this);
//		}
		
		for(Material currentMaterial: Database.materials) {
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
	
}
