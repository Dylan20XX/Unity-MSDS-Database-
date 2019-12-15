package Screens;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Objects.Database;
import Objects.User;
import Utility.Assets;
import Utility.FileInput;
/**
 * 
 * @author Momin Naeem
 * Date: Dec 2, 2019
 * Course: ICS4U1
 * Topic: Unity Project
 * Title: LoginScreen
 * Description: This class controls the login part of the GUI. It involves the "USERNAME"
 * 				and "PASSWORD" for the user to enter. It will connect to a database, saving 
 * 				their information.
 */

public class UnityLoginScreen extends JFrame implements ActionListener {
	
	//Title Label
	//JLabel titleLabel = new JLabel("Unity");
	
	// Game panel as well as the menu bar
	JLabel inputPanel = new JLabel(Assets.loginBackground);
	JPanel loginPanel = new JPanel();
	JMenuBar jmb = new JMenuBar();

	// The menu bar variables/MenuItems
	JMenu jmExit = new JMenu("Exit");
	JMenuItem jmiExit = new JMenuItem("Exit");
	JMenu jmHelp = new JMenu("Help");
	JMenuItem jmiHelp = new JMenuItem("Instructions");

	// JLabels for the images in the menu screen
	// JLabel title, background

	// The text area
	JLabel userPrompt = new JLabel("Username:");
	JLabel passPrompt = new JLabel("Password:");
	JTextField userText = new JTextField();
	JPasswordField passText = new JPasswordField(8);
	
	// New USER BUTTON
	JButton newUserButton = new JButton();
		
		
	// Clip variable for the music method
	static Clip clip;

	User[] userArray = new User[2];
	int access = 0;

	/*
	 * A constructor method that reads in the different methods as well as
	 * playing the startup music
	 * 
	 */
	/**
	 * This is the constructor method
	 * @param null
	 */
	public UnityLoginScreen() {

		frameSetup();
		inputPanel();
		loginPanel();
		MenuBar();

	}
/**
 * creates input panel
 * @param null;
 */
	private void inputPanel() {

		// This sets the location and image of the new button
		//newb.setIcon(new ImageIcon("./M/images/new.png"));
		newUserButton.setFont(new Font("Arial", Font.BOLD, 24));
		newUserButton.setText("New User");
		newUserButton.setBackground(Color.ORANGE);
		newUserButton.setBounds(1000, 575, 160, 45);
		newUserButton.addActionListener(this);
		inputPanel.add(newUserButton);
		
		// This sets up the border color and boundaries
		//inputPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		inputPanel.setBounds(0, 0, 1280, 720);
		//inputPanel.setLayout(null);
		// This is the background color of the panel
		//inputPanel.setBackground(new Color(191,231,247));
		inputPanel.setVisible(true);

	}
	/**
	 * Creates Login panel
	 * @param null
	 */
	private void loginPanel() {
		
		Font serifFont = new Font("Serif", Font.BOLD, 24);
		userText.setFont(serifFont);
		userText.setBounds(250, 125, 250, 30);
		userText.addActionListener(this);

		passText.setFont(serifFont);
		passText.setBounds(250, 175, 250, 30);
		passText.addActionListener(this);
		
		userPrompt.setFont(serifFont);
		userPrompt.setBounds(125, 125, 250, 30);
		
		passPrompt.setFont(serifFont);
		passPrompt.setBounds(125, 175, 250, 30);
		
		loginPanel.add(userPrompt);
		loginPanel.add(passPrompt);
		loginPanel.add(userText);
		loginPanel.add(passText);
		
		// This sets up the border color and boundaries
		loginPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
		//loginPanel.setBackground(new Color(82,66,209));
		loginPanel.setBackground(new Color(140,100,209));
		loginPanel.setBounds(332, 277, 622, 365);
		loginPanel.setLayout(null);
		loginPanel.setVisible(true);
		
		inputPanel.add(loginPanel);
	}

	// The frame setup method where it sets up the frame
	/**
	 * Sets up the frame
	 * @param null
	 */
	private void frameSetup() {

		// This sets up the size of the frame
		setSize(1280, 720);
		setTitle("Unity");
		setLayout(null);
		//setBackground(Color.CYAN);
		//setForeground(Color.CYAN);

		// Adds in the MenuBar
		setJMenuBar(jmb);

		// This makes the whole application close and makes the GUI visible
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		// This adds in the gamePanel
		add(inputPanel);
		setVisible(true);
		
	}

	// This contains the menu bar method where it states each MenuItem
	/**
	 * Sets up the Menubar
	 * @param null
	 */
	private void MenuBar() {

		// File menu item
		jmExit.addSeparator();
		jmExit.add(jmiExit);
		jmb.add(jmExit);

		// New menu item to the menu bar, which is the help portion
		jmHelp.add(jmiHelp);
		jmb.add(jmHelp);

		// Adds an action listener to the require menu item and makes the
		// menubar
		// visible
		jmiExit.addActionListener(this);
		jmiHelp.addActionListener(this);
		setVisible(true);

	}

	@Override
	/** Tests for userinput then preforms a task
	 * @param userinput
	 */
	public void actionPerformed(ActionEvent e) {

		// Actions when back button clicked
		if (e.getSource() == jmiExit) {
			System.exit(0);
		} else if (e.getSource() == jmiHelp) {
			new UnityHelpScreen();
			this.dispose();
		} else if (e.getSource() == newUserButton) {
			new UnityNewUserScreen();
			this.dispose();
		} else if(e.getSource() == userText || e.getSource() == passText) {
			login();
		}
		
	}
	/**
	 * @return password
	 */
	private String readPassword() {
		
		char[] passArray = passText.getPassword();
		String password;
		
		if(passArray.length >= 1)
			password = Arrays.toString(passArray).substring(1, 3* passArray.length - 1).replace(", ", "");
		else
			password = "";
		
		return password;
		
	}
	/**
	 * @return login
	 */
	private void login() {
		
		for(User currentUser: Database.users) {
			
			if ((userText.getText()).equals(currentUser.getUser())
					&& readPassword().equals(currentUser.getPass())) {
				
				System.out.println("Access granted");
				
				Database.currentUser = currentUser.getUser();
				
				new UnityProjectListScreen();
				this.dispose();
				return;
				
			}
			
		}
		
		System.out.println("Incorrect Username or password");
		JOptionPane.showMessageDialog(null, "Invalid Username or Password!","INVALID", JOptionPane.WARNING_MESSAGE);		
	}
	
}
