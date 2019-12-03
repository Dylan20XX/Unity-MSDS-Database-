import java.awt.Color;
import java.awt.Font;

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
		
		//Setup the button panel
		materialButtonPanel.setLayout(new BoxLayout(materialButtonPanel, BoxLayout.Y_AXIS));
		//savedGameButtonPanel.setBounds(220, 100 ,250, 550);
		materialButtonPanel.setBackground(Color.DARK_GRAY);
				
		//Add the scroll pane
		materialButtonScrollPane = new JScrollPane(materialButtonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		materialButtonScrollPane.setBounds(220,100,400,550);
		materialPanel.add(materialButtonScrollPane);
		
		
		//Test Button
		JButton savedGames = new JButton("Test");
		//savedGames.addActionListener(this);
		savedGames.setSize(400, 150);
		savedGames.setMaximumSize(savedGames.getSize());
		savedGames.setMinimumSize(savedGames.getSize());
		savedGames.setPreferredSize(savedGames.getSize());
		savedGames.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		materialButtonPanel.add(savedGames);
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
