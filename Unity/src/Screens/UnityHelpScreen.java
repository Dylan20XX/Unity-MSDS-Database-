package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

//Suppress serial warnings
@SuppressWarnings("serial")
public class UnityHelpScreen extends JFrame implements ActionListener {

	JButton backButton = new JButton();

	// The constructor method of this class
	public UnityHelpScreen() {

		frameSetup();

	}


	//This method sets up the frame
	private void frameSetup() {
		
		//Set the title and frame size
		setTitle("Unity");
		setSize(1280, 720);
		setLayout(null);
		//getContentPane().setBackground(new Color(191,231,247)); //Blue
		getContentPane().setBackground(new Color(82,66,209)); //Dark purple
		//getContentPane().setBackground(new Color(140,100,209)); //Light purple
		
		//Prevent the program from running when the frame is closed, prevent the 
		//frame from being resized, and make the frame visible
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	// This is the acitonPerformed class where it takes action of each button in
	// this screen.
	@Override
	public void actionPerformed(ActionEvent e) {

	}
	
}

