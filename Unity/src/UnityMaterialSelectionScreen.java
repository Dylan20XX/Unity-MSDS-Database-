import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class UnityMaterialSelectionScreen extends JFrame {
	
	private JPanel materialPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Select Materials");
	private JLabel searchBarLabel = new JLabel("Search");
	private JTextArea searchBar = new JTextArea();
	private JLabel sortComboBoxLabel = new JLabel("Sort By:");
	private JComboBox<String> sortComboBox = new JComboBox<String>();
	private JButton backButton = new JButton("Back");
	private JButton submitButton = new JButton("Submit");
	
	private JPanel materialButtonPanel = new JPanel();
	private JPanel addButtonPanel = new JPanel();
	private JPanel infoButtonPanel = new JPanel();
	private JPanel materialNamePanel = new JPanel();
	private JPanel materialQuantityPanel = new JPanel();
	private JScrollPane materialButtonScrollPane = new JScrollPane();
	
	//Main method for testing GUI
	public static void main(String[] args) {
		new UnityMaterialSelectionScreen();
	}
	
	//Constructor method
	public UnityMaterialSelectionScreen() {
		panelSetup();
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
		searchBar.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent key) {
				if(key.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("x");
				}
			}

			@Override
			public void keyReleased(KeyEvent key) {
				
			}

			@Override
			public void keyTyped(KeyEvent key) {
				
			}
			
		});
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
		materialPanel.add(submitButton);
		
		backButton.setBounds(140, 620, 200, 50);
		backButton.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(backButton);
		
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
		//savedGameButtonPanel.setBounds(220, 100 ,250, 550);
		materialButtonPanel.setBackground(Color.DARK_GRAY);
		
		//Panels within the material button panel
		addButtonPanel.setLayout(new BoxLayout(addButtonPanel, BoxLayout.Y_AXIS));
		addButtonPanel.setBackground(Color.DARK_GRAY);
		materialButtonPanel.add(addButtonPanel);
		infoButtonPanel.setLayout(new BoxLayout(infoButtonPanel, BoxLayout.Y_AXIS));
		infoButtonPanel.setBackground(Color.DARK_GRAY);
		materialButtonPanel.add(infoButtonPanel);
		materialNamePanel.setLayout(new BoxLayout(materialNamePanel, BoxLayout.Y_AXIS));
		materialNamePanel.setBackground(Color.WHITE);
		materialButtonPanel.add(materialNamePanel);
		materialQuantityPanel.setLayout(new BoxLayout(materialQuantityPanel, BoxLayout.Y_AXIS));
		materialQuantityPanel.setBackground(Color.LIGHT_GRAY);
		materialButtonPanel.add(materialQuantityPanel);
				
		//Add the scroll pane 
		materialButtonScrollPane = new JScrollPane(materialButtonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		materialButtonScrollPane.setBounds(140,200,1000,400);
		materialPanel.add(materialButtonScrollPane);
		
		for(int i = 0; i < 10; i++) {
			addTestButtons();
		}
		
	}
	
	//This method adds testing materials to the scroll pane panels
	private void addTestButtons() {
		
		//Test Buttons
		JButton addButton = new JButton("Add");
		//savedGames.addActionListener(this);
		addButton.setSize(100, 50);
		addButton.setMaximumSize(addButton.getSize());
		addButton.setMinimumSize(addButton.getSize());
		addButton.setPreferredSize(addButton.getSize());
		addButton.setFont(new Font("Arial", Font.BOLD, 24));
		addButtonPanel.add(addButton);
		
		JButton infoButton = new JButton("Info");
		//savedGames.addActionListener(this);
		infoButton.setSize(100, 50);
		infoButton.setMaximumSize(infoButton.getSize());
		infoButton.setMinimumSize(infoButton.getSize());
		infoButton.setPreferredSize(infoButton.getSize());
		infoButton.setFont(new Font("Arial", Font.BOLD, 24));
		infoButtonPanel.add(infoButton);
		
		JLabel nameLabel = new JLabel("Material Name");
		//savedGames.addActionListener(this);
		//nameLabel.setBackground(Color.WHITE);
		//nameLabel.setEditable(false);
		
		nameLabel.setSize(600, 50);
		nameLabel.setMaximumSize(nameLabel.getSize());
		nameLabel.setMinimumSize(nameLabel.getSize());
		nameLabel.setPreferredSize(nameLabel.getSize());
		nameLabel.setFont(new Font("Arial", Font.BOLD, 36));
		materialNamePanel.add(nameLabel);
		
		JLabel quantityLabel = new JLabel("Quantity: 0");
		//savedGames.addActionListener(this);
		//quantityLabel.setBackground(Color.LIGHT_GRAY);
		//quantityLabel.setEditable(false);
		quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		quantityLabel.setSize(200, 50);
		quantityLabel.setMaximumSize(quantityLabel.getSize());
		quantityLabel.setMinimumSize(quantityLabel.getSize());
		quantityLabel.setPreferredSize(quantityLabel.getSize());
		quantityLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialQuantityPanel.add(quantityLabel);
		
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
	
}
