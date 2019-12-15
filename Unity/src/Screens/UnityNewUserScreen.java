package Screens;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Objects.Database;
import Objects.User;
import Utility.FileInput;
/** * @author Momin Naeem
 * Date: Dec 2, 2019
 * Course: ICS4U1
 * Topic: Unity Project
 * Title: NewUserScreen
 * Description: This class controls the new user screen, where a user who doesn't have a 
 * 				"USERNAME" and "PASSWORD" will have to make valid credentials. This screen 
 * 				write their new information in a file to save for next time the user opens 
 * 				the program.
 */
public class UnityNewUserScreen extends JFrame implements ActionListener {
	/**
	 * this class creates the new user GUI
	 * @param null;
	 */

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String [] args) {
		FileInput.readUsers();
		new UnityNewUserScreen();
	}

	// Game panel as well as the menu bar
	JPanel inputPanel = new JPanel();
	JPanel loginPanel = new JPanel();
	JMenuBar jmb = new JMenuBar();

	// The menu bar variables/MenuItems
	JMenu jmFile = new JMenu("File");
	JMenuItem jmiExit = new JMenuItem("Exit");
	JMenu jmOptions = new JMenu("Options");
	JMenu a = new JMenu("Change Style");
	JMenuItem b = new JMenuItem("Background");
	JMenuItem c = new JMenuItem("Theme");
	JMenuItem d = new JMenuItem("Set to Default");
	JMenu jmHelp = new JMenu("More");
	JMenuItem jmiHelp = new JMenuItem("Help");

	// JLabels for the images in the menu screen
	// JLabel title, background

	// Panel + Button of the Game 1 Image
	JButton createUserButton = new JButton("Create User");

	// Panel + Button of the Game 1 Image
	JButton backButton = new JButton("Back");

	// Prompts
	JLabel userPrompt = new JLabel("Type NEW Username here:");
	JLabel passPrompt = new JLabel("Type NEW Password here:");
	JLabel userPrompt2 = new JLabel("Retype NEW Username here:");
	JLabel passPrompt2 = new JLabel("Retype NEW Password here:");

	// The text area
	JTextField userText = new JTextField();
	JPasswordField passText = new JPasswordField();
	JTextField userText2 = new JTextField();
	JPasswordField passText2 = new JPasswordField();

	JLabel titleLabel = new JLabel("<html><center>Create A New User</centre></html>");
	JLabel errorLabel = new JLabel("error label");

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
	public UnityNewUserScreen() {

		frameSetup();
		inputPanelSetup();
		loginPanelSetup();
		menuBarSetup();

	}
	/**
	 * This method sets up the input panel
	 * @param null
	 */
	private void inputPanelSetup() {

		// This sets up the border color and boundaries
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		inputPanel.setBounds(0, 0, 1280, 720);
		inputPanel.setLayout(null);
		// This is the background color of the panel
		//inputPanel.setBackground(new Color(191,231,247));
		inputPanel.setBackground(new Color(82,66,209));
		inputPanel.setVisible(true);

	}
	/**
	 * This method sets up the login panel
	 * @param null
	 */
	private void loginPanelSetup() {

		Font newFont = new Font("Serif", Font.BOLD, 22);
		userText.setFont(newFont);
		userText.setBounds(600, 200, 300, 30);
		userText.setEditable(true);
		//userText.setText("Type NEW Username here:");

		userText2.setFont(newFont);
		userText2.setBounds(600, 250, 300, 30);
		userText2.setEditable(true);
		//userText2.setText("Retype NEW Username here:");

		passText2.setFont(newFont);
		passText2.setBounds(600, 350, 300, 30);
		passText2.setEditable(true);
		//passText2.setText("Type NEW Password here:");

		passText.setFont(newFont);
		passText.setBounds(600, 400, 300, 30);
		passText.setEditable(true);
		//passText.setText("Retype NEW Password here:");

		loginPanel.add(userText);
		loginPanel.add(passText);
		loginPanel.add(userText2);
		loginPanel.add(passText2);

		userPrompt.setFont(newFont);
		userPrompt.setBounds(300, 200, 300, 30);
		userPrompt2.setFont(newFont);
		userPrompt2.setBounds(300, 250, 300, 30);
		passPrompt.setFont(newFont);
		passPrompt.setBounds(300, 350, 300, 30);
		passPrompt2.setFont(newFont);
		passPrompt2.setBounds(300, 400, 300, 30);

		loginPanel.add(userPrompt);
		loginPanel.add(userPrompt2);
		loginPanel.add(passPrompt);
		loginPanel.add(passPrompt2);

		// This sets the location and image of the create user and back buttons
		backButton.setBounds(100, 550, 120, 35);
		backButton.setBackground(Color.orange);
		backButton.addActionListener(this);
		loginPanel.add(backButton);
		createUserButton.setBounds(990, 550, 120, 35);
		createUserButton.setBackground(Color.orange);
		createUserButton.addActionListener(this);
		loginPanel.add(createUserButton);

		// This sets up the title and error labels
		titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
		titleLabel.setBounds(455, 25, 300, 50);
		loginPanel.add(titleLabel);

		//errorLabel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(newFont);
		errorLabel.setBounds(405, 450, 400, 70);
		loginPanel.add(errorLabel);

		// This sets up the border color and boundaries
		loginPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		loginPanel.setBackground(new Color(140,100,209));
		loginPanel.setBounds(25, 25, 1210, 600);
		loginPanel.setLayout(null);
		loginPanel.setVisible(true);
	}

	// The frame setup method where it sets up the frame
	/**
	 * This method sets up the JFrame
	 * @param null
	 */
	private void frameSetup() {

		// This sets up the size of the frame
		setSize(1280, 720);
		setLayout(null);
		// setBackground(Color.CYAN);
		// setForeground(Color.CYAN);

		// Adds in the MenuBar
		setJMenuBar(jmb);

		// This makes the whole application close and makes the GUI visible
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(true);

		// This adds in the gamePanel
		add(loginPanel);
		add(inputPanel);
		setVisible(true);

	}

	// This contains the menu bar method where it states each MenuItem
	/**
	 * This method sets up the menubar
	 * @param null
	 */
	private void menuBarSetup() {

		// File menuitem
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);

		// Options menu items
		a.add(b);
		a.add(c);
		a.add(d);
		jmOptions.add(a);

		// Adds in the options menuitem to the menu bar
		jmb.add(jmOptions);

		// New menuitem to the menu bar, which is the help portion
		jmHelp.add(jmiHelp);
		jmb.add(jmHelp);

		// Adds an action listener to the require menu item and makes the
		// menubar
		// visible
		jmiExit.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		jmiHelp.addActionListener(this);
		setVisible(true);

	}

	@Override
	/**
	 * This method checks for user input and preforms tasks 
	 * @param User Input
	 */
	public void actionPerformed(ActionEvent e) {

		// Actions when back button clicked
		if (e.getSource() == jmiExit) {
			// Play sound effect
			// music("./sounds/exit.wav");
			System.exit(0);

		}

		if (e.getSource() == jmiHelp) {
			// Play sound effect
			// music("./sounds/exit.wav");

			// new Help();
		}

		if (e.getSource() == b) {
			// Play sound effect
			// music("./sounds/exit.wav");

			// new Background
		}

		if (e.getSource() == c) {
			// Play sound effect
			// music("./sounds/exit.wav");

			// new Theme
		}

		if (e.getSource() == createUserButton) {

			if(checkUserInfo()) {
				rewriteLoginFile();
				createUser();
				Database.currentUser = userText.getText();
				new UnityProjectListScreen();
				this.dispose();
			}

			repaint();
			revalidate();

		}
		if (e.getSource() == backButton) {

			new UnityLoginScreen();
			this.dispose();

		}

	}
	/**
	 * This method checks for user information
	 * @param null
	 */
	private boolean checkUserInfo() {

		//If any check is failed, give error message in a label and return from the method

		//Check if usernames in both text fields match
		if(!userText.getText().equals(userText2.getText())) {
			errorLabel.setText("<html><center>Make sure that usernames match</centre></html>");
			return false;
		}

		//Check if username is taken
		for(User currentUser: Database.users) {
			if(userText.getText().equals(currentUser.getUser())) {
				errorLabel.setText("<html><center>Usernames is taken</centre></html>");
				return false;
			}
		}

		//Check if passwords match
		if(!readPassword(passText).equals(readPassword(passText2))) {
			errorLabel.setText("<html><center>Make sure that passwords match</centre></html>");
			return false;
		}

		//Check if username or password contains commas
		if(readPassword(passText).contains(",") || userText.getText().contains(",")) {
			errorLabel.setText("<html><center>Usernames or passwords can't contain commas</centre></html>");
			return false;
		}

		//Check if username or password contains spaces
		if(readPassword(passText).contains(" ") || userText.getText().contains(" ")) {
			errorLabel.setText("<html><center>Usernames or passwords can't contain spaces</centre></html>");
			return false;
		}

		//Check if a username has been entered
		if(userText.getText().isEmpty()) {
			errorLabel.setText("<html><center>Enter a username</centre></html>");
			return false;
		}

		//Check if a password has been entered
		if(readPassword(passText).equals("")) {
			errorLabel.setText("<html><center>Enter a password</centre></html>");
			return false;
		}

		return true;
	}
	/**
	 * This method reads the users password
	 * @param passText
	 * @return password
	 */
	private String readPassword(JPasswordField passText) {

		char[] passArray = passText.getPassword();
		String password;

		if(passArray.length >= 1)
			password = Arrays.toString(passArray).substring(1, 3* passArray.length - 1).replace(", ", "");
		else
			password = "";

		return password;

	}
	/**
	 * This method copies file contents
	 * @return fileContents
	 */
	private String copyFileContents() {

		String fileContents = "";

		try {

			Scanner input = new Scanner(new File("Login.csv"));

			fileContents = input.nextLine();

			while(input.hasNextLine()) {
				fileContents += "\n" + input.nextLine();
			}

			input.close();

		} catch(FileNotFoundException error) {
			//Display a message if the file is not found
			System.out.println("Wrong file");
		}

		return fileContents;

	}
	/**
	 * This method rewrites login files
	 */
	private void rewriteLoginFile() {

		String fileContents = copyFileContents();

		String file = String.format("Login.csv");
		File filepath = new File(file);

		//if(!filepath.exists() && !filepath.isDirectory()) {
		if(!filepath.isDirectory()) {

			try {

				//Write data to a file
				PrintWriter pr = new PrintWriter(file);

				pr.print(fileContents + "\n");
				pr.print(userText.getText() + "," + readPassword(passText) + ",");

				pr.close();

			} catch (FileNotFoundException e) {
				System.out.println("Save Failed");
			}

		}

	}
	/**
	 * This method creats a new user
	 */
	private void createUser() {

		File file = new File(String.format("Users/%s", userText.getText()));
		boolean directoryCreated = file.mkdir();

		if(directoryCreated) {
			System.out.println("User folder created");
		} else {
			System.out.println("User folder was not created");
		}

	}

}


