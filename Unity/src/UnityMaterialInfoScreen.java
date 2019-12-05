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

public class UnityMaterialInfoScreen extends JFrame {
	
	private JPanel materialPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Material Info");
	private JButton backButton = new JButton("Back");
	private JButton addButton = new JButton("Add");
	
	//Main method for testing GUI
	public static void main(String[] args) {
		new UnityMaterialSelectionScreen();
	}
	
	//Constructor method
	public UnityMaterialInfoScreen() {
		panelSetup();
		infoSetup();
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
		
		//Setup the add material and back buttons
		addButton.setBounds(940, 620, 200, 50);
		addButton.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(addButton);
		
		backButton.setBounds(140, 620, 200, 50);
		backButton.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(backButton);
		
	}
	
	//This method sets up the scroll pane used 
	private void infoSetup() {
		
		
		
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
