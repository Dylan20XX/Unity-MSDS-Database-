import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UnityMaterialSelectionScreen extends JFrame {
	
	private JPanel materialPanel = new JPanel();
	private JLabel titleLabel = new JLabel("Select Materials");
	private JPanel materialButtonPanel = new JPanel();
	private JPanel addButtonPanel = new JPanel();
	private JPanel infoButtonPanel = new JPanel();
	private JPanel materialNamePanel = new JPanel();
	private JPanel materialQuantityPanel = new JPanel();
	private JScrollPane materialButtonScrollPane = new JScrollPane();
	
	//Main method for testing GUI
	public static void main(String[] args) {
		//Test
		new UnityMaterialSelectionScreen();
	}
	
	//Constructor method
	public UnityMaterialSelectionScreen() {
		panelSetup();
		frameSetup();
	}
	
	//This method sets up the panel with the scroll pane
	private void panelSetup() {

		//Setup the panel
		materialPanel.setBounds(0,0,1280,720);
		materialPanel.setLayout(null);
		materialPanel.setBackground(new Color(191,231,247));
		materialPanel.setVisible(true); //Initially hide the highscore panel 
		
		//Setup the label
		titleLabel.setBounds(480, 30, 400, 50);
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		materialPanel.add(titleLabel);
		
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
		materialQuantityPanel.setBackground(Color.DARK_GRAY);
		materialButtonPanel.add(materialQuantityPanel);
				
		//Add the scroll pane
		materialButtonScrollPane = new JScrollPane(materialButtonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		materialButtonScrollPane.setBounds(125,200,1000,400);
		materialPanel.add(materialButtonScrollPane);
		
		
		//Test Buttons
		JButton addButton = new JButton("Add");
		//savedGames.addActionListener(this);
		addButton.setSize(100, 50);
		addButton.setMaximumSize(addButton.getSize());
		addButton.setMinimumSize(addButton.getSize());
		addButton.setPreferredSize(addButton.getSize());
		addButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		addButtonPanel.add(addButton);
		
		JButton infoButton = new JButton("Info");
		//savedGames.addActionListener(this);
		infoButton.setSize(100, 50);
		infoButton.setMaximumSize(infoButton.getSize());
		infoButton.setMinimumSize(infoButton.getSize());
		infoButton.setPreferredSize(infoButton.getSize());
		infoButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		infoButtonPanel.add(infoButton);
		
		JLabel nameLabel = new JLabel("Material Name");
		//savedGames.addActionListener(this);
		nameLabel.setSize(500, 50);
		nameLabel.setMaximumSize(nameLabel.getSize());
		nameLabel.setMinimumSize(nameLabel.getSize());
		nameLabel.setPreferredSize(nameLabel.getSize());
		nameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		materialNamePanel.add(nameLabel);
		
		JLabel quantityLabel = new JLabel("Quantity: 0");
		//savedGames.addActionListener(this);
		quantityLabel.setSize(150, 50);
		quantityLabel.setMaximumSize(quantityLabel.getSize());
		quantityLabel.setMinimumSize(quantityLabel.getSize());
		quantityLabel.setPreferredSize(quantityLabel.getSize());
		quantityLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
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
