import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class UnityMaterialSelectionScreen extends JFrame implements ActionListener{
	
	private JPanel materialPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Select Materials");
	private JLabel searchBarLabel = new JLabel("Search");
	private JTextField searchBar = new JTextField();
	private JLabel sortComboBoxLabel = new JLabel("Sort By:");
	private JComboBox<String> sortComboBox = new JComboBox<String>();
	private JButton backButton = new JButton("Back");
	private JButton submitButton = new JButton("Submit");
	private JButton viewAllButton = new JButton("View All Materials");
	
	private JPanel materialButtonPanel = new JPanel();
	private JPanel quantityButtonPanel = new JPanel();
	private JPanel infoButtonPanel = new JPanel();
	private JPanel materialNamePanel = new JPanel();
	private JPanel materialQuantityPanel = new JPanel();
	private JScrollPane materialButtonScrollPane = new JScrollPane();
	
	//Main method for testing GUI
	public static void main(String[] args) {
		FileInput.readMaterials();
		new UnityMaterialSelectionScreen();
	}
	
	//Constructor method
	public UnityMaterialSelectionScreen() {
		panelSetup();
		//addScreenTestButtons();
		addMaterialButtons();
		scrollPaneSetup();
		frameSetup();
	}

	//This method sets up the panel with the scroll pane
	private void panelSetup() {

		//Setup the panel
		materialPanel.setBounds(0,0,1280,720);
		materialPanel.setLayout(null);
		materialPanel.setBackground(new Color(191,231,247));
		materialPanel.setVisible(true); //Initially hide the highscore panel 
		
		//Setup the title label
		titleLabel.setBounds(480, 30, 400, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
		materialPanel.add(titleLabel);
		
		//Setup the search bar and label
		searchBarLabel.setBounds(140, 110, 270, 30);
		searchBarLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(searchBarLabel);
		
		searchBar.setBounds(140, 140, 270, 30);
		searchBar.setFont(new Font("Arial", Font.PLAIN, 24));
		searchBar.addActionListener(this);
		materialPanel.add(searchBar);
		
		//Setup the combo box
		sortComboBoxLabel.setBounds(940, 140, 100, 30);
		sortComboBoxLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(sortComboBoxLabel);
		
		sortComboBox.setBounds(1040, 140, 100, 30);
		sortComboBox.setFont(new Font("Arial", Font.PLAIN, 24));
		materialPanel.add(sortComboBox);
		
		//Setup the submit and back buttons
		submitButton.setBounds(940, 620, 200, 50);
		submitButton.setFont(new Font("Arial", Font.BOLD, 24));
		submitButton.addActionListener(this);
		materialPanel.add(submitButton);
		
		backButton.setBounds(140, 620, 200, 50);
		backButton.setFont(new Font("Arial", Font.BOLD, 24));
		backButton.addActionListener(this);
		materialPanel.add(backButton);
		
		//Setup button to view full material list after a search
		viewAllButton.setBounds(500, 620, 280, 50);
		viewAllButton.setFont(new Font("Arial", Font.BOLD, 24));
		viewAllButton.addActionListener(this);
		materialPanel.add(viewAllButton);
		
	}
	
	//This method sets up the scroll pane used 
	private void scrollPaneSetup() {
		
		//materialPanel <- materialButtonScrollPane <- materialButtonPanel
		
		//materialButtonPanel 
		//	<- addButtonPanel
		//	<- infoButtonPanel
		//	<- materialNamePanel
		//	<- materialQuantityPanel
		
		//Setup the button panel
		//materialButtonPanel.setLayout(new BoxLayout(materialButtonPanel, BoxLayout.Y_AXIS));
		materialButtonPanel.setLayout(new BoxLayout(materialButtonPanel, BoxLayout.X_AXIS));
		materialButtonPanel.setBackground(Color.DARK_GRAY);
		
		//Panels within the material button panel
		quantityButtonPanel.setLayout(new BoxLayout(quantityButtonPanel, BoxLayout.Y_AXIS));
		quantityButtonPanel.setBackground(Color.DARK_GRAY);
		materialButtonPanel.add(quantityButtonPanel);
		materialQuantityPanel.setLayout(new BoxLayout(materialQuantityPanel, BoxLayout.Y_AXIS));
		materialQuantityPanel.setBackground(Color.LIGHT_GRAY);
		materialButtonPanel.add(materialQuantityPanel);
		infoButtonPanel.setLayout(new BoxLayout(infoButtonPanel, BoxLayout.Y_AXIS));
		infoButtonPanel.setBackground(Color.DARK_GRAY);
		materialButtonPanel.add(infoButtonPanel);
		materialNamePanel.setLayout(new BoxLayout(materialNamePanel, BoxLayout.Y_AXIS));
		materialNamePanel.setBackground(Color.WHITE);
		materialButtonPanel.add(materialNamePanel);
				
		//Add the scroll pane 
		materialButtonScrollPane = new JScrollPane(materialButtonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		materialButtonScrollPane.setBounds(140,200,1000,400);
		materialPanel.add(materialButtonScrollPane);
		
	}
	
	private void addMaterialButtons() {
		
		quantityButtonPanel.removeAll();
		infoButtonPanel.removeAll();
		materialNamePanel.removeAll();
		materialQuantityPanel.removeAll();
		
		removeActionListeners();
		
		for(Material currentMaterial: Database.materials) {
			
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
		
	}
	
	//This method sets up the frame
	private void frameSetup() {
		
		//Set the title and frame size
		setTitle("Unity");
		setSize(1280, 720);
		setLayout(null);
		//getContentPane().setBackground(new Color(191,231,247));
		
		add(materialPanel);
		
		//Prevent the program from running when the frame is closed, prevent the 
		//frame from being resized, and make the frame visible
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(Material currentMaterial: Database.materials) {
			
			if(e.getSource() == currentMaterial.getQuantityButton()) {
				currentMaterial.setQuantity(Integer.parseInt(currentMaterial.getQuantityField().getText()));
				return;
			} else if (e.getSource() == currentMaterial.getInfoButton()) {
				removeActionListeners();
				new UnityMaterialInfoScreen(currentMaterial, 0);
				this.dispose();
				return;
			}
			
		}
		
		if(e.getSource() == submitButton) {
			
			removeActionListeners();
			
			Database.currentProject.getMaterialList().clear();
			
			for(Material currentMaterial: Database.materials) {
				if(currentMaterial.getQuantity() != 0) {
					
					Material m = new Material();
					m.copyMaterial(currentMaterial);
					Database.currentProject.getMaterialList().add(currentMaterial);
					
				}
			}
			
			new UnityReportScreen();
			this.dispose();
			
		} else if(e.getSource() == backButton) {
			removeActionListeners();
			new UnityProjectListScreen();
			this.dispose();
		} else if(e.getSource() == viewAllButton) {
			addMaterialButtons();
		}else if(e.getSource() == searchBar) {
			System.out.println("search");
			
			quantityButtonPanel.removeAll();
			infoButtonPanel.removeAll();
			materialNamePanel.removeAll();
			materialQuantityPanel.removeAll();
			
			removeActionListeners();
			
			for(Material currentMaterial: Database.materials) {
				
				if(currentMaterial.getName().toLowerCase().contains(searchBar.getText().toLowerCase())) {
					
					System.out.println(currentMaterial.getName() + " " + searchBar.getText());
					
					currentMaterial.setupComponents();
					
					currentMaterial.getQuantityButton().addActionListener(this);
					quantityButtonPanel.add(currentMaterial.getQuantityButton());
					
					currentMaterial.getInfoButton().addActionListener(this);
					infoButtonPanel.add(currentMaterial.getInfoButton());
					
					materialNamePanel.add(currentMaterial.getNameLabel());
					
					materialQuantityPanel.add(currentMaterial.getQuantityField());
					
				}
				
			}
			
			repaint();
			revalidate();
			
		}
		
	}
	
	//This method removes the action listers from material buttons
	//Use this method before changing screens
	private void removeActionListeners() {
		
		for(Material currentMaterial: Database.materials) {
			currentMaterial.getQuantityButton().removeActionListener(this);
			currentMaterial.getInfoButton().removeActionListener(this);
		}
		
	}

}
