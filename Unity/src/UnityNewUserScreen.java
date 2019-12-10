
/*
 * Name: Momin Naeem
 * Date: Dec 2, 2019
 * Course: ICS4U1
 * Topic: Unity Project
 * Title: NewUserScreen
 * Description: This class controls the new user screen, where a user who doesn't have a 
 * 				"USERNAME" and "PASSWORD" will have to make valid credentials. This screen 
 * 				write their new information in a file to save for next time the user opens 
 * 				the program.
 */

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
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

public class UnityNewUserScreen extends JFrame implements ActionListener {

	JLabel titleLabel = new JLabel("Unity");

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

	JButton saveb = new JButton();

	// The text area
	JTextField userText = new JTextField();
	JPasswordField passText = new JPasswordField(8);
	JPasswordField passText1 = new JPasswordField(8);
	JTextField userText1 = new JTextField();
	JLabel userPrompt = new JLabel("Username:");
	JLabel passPrompt = new JLabel("Password:");
	JLabel userPrompt1 = new JLabel("Retype Username:");
	JLabel passPrompt1 = new JLabel("Retype Password:");

	// Clip variable for the music method
	static Clip clip;

	User[] userArray = new User[2];
	int access = 0;

	/*
	 * A constructor method that reads in the different methods as well as playing
	 * the startup music
	 * 
	 */
	public UnityNewUserScreen() {

		frameSetup();
		inputPanel();
		loginPanel();
		MenuBar();
		// music("./sounds/game.wav");

		Scanner input;
		try {

			// Reads in the csv file and sets the delimiter to commas
			input = new Scanner(new File("LoginUP.csv"));
			input.useDelimiter(",");
			// input.nextLine(); //Get rid of header row
			int i = 0; // Tracks the index

			// Reads in data from the csv file.
			while (input.hasNextLine()) {

				// Creates a new user
				userArray[i] = new User();

				// smartphone information fields
				userArray[i].setUser(input.next().replace("\"", "").replace("\n", ""));
				userArray[i].setPass(input.next());

				System.out.println(userArray[i]);
				i++;

				if (i == 2) {
					break;
				}
			}

			input.close();

		} catch (FileNotFoundException error) {

			System.out.println("Error! File not found.");
		}

	}

	private void inputPanel() {

		// This sets the location and image of the save button
		// saveb.setIcon(save ImageIcon("./M/images/save.png"));
		saveb.setFont(new Font("Arial", Font.BOLD, 24));
		saveb.setText("Save User");
		saveb.setBounds(1100, 575, 160, 45);
		saveb.addActionListener(this);
		inputPanel.add(saveb);

		// This sets up the border color and boundaries
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		inputPanel.setBounds(0, 0, 1280, 720);
		inputPanel.setLayout(null);
		// This is the background color of the panel
		inputPanel.setBackground(new Color(191, 231, 247));
		inputPanel.setVisible(true);

		// Add title label
		titleLabel.setBounds(580, 30, 160, 50);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
		inputPanel.add(titleLabel);

	}

	private void loginPanel() {

		Font serifFont = new Font("Serif", Font.BOLD, 24);
		userText.setFont(serifFont);
		userText.setBounds(375, 100, 250, 30);
		userText.addActionListener(this);

		passText.setFont(serifFont);
		passText.setBounds(375, 150, 250, 30);
		passText.addActionListener(this);

		userPrompt.setFont(serifFont);
		userPrompt.setBounds(180, 100, 250, 30);

		passPrompt.setFont(serifFont);
		passPrompt.setBounds(180, 150, 250, 30);

		userText1.setFont(serifFont);
		userText1.setBounds(375, 200, 250, 30);
		userText1.addActionListener(this);

		passText1.setFont(serifFont);
		passText1.setBounds(375, 250, 250, 30);
		passText1.addActionListener(this);

		userPrompt1.setFont(serifFont);
		userPrompt1.setBounds(180, 200, 250, 30);

		passPrompt1.setFont(serifFont);
		passPrompt1.setBounds(180, 250, 250, 30);

		loginPanel.add(userPrompt);
		loginPanel.add(passPrompt);
		loginPanel.add(userText);
		loginPanel.add(passText);
		loginPanel.add(userPrompt1);
		loginPanel.add(passPrompt1);
		loginPanel.add(userText1);
		loginPanel.add(passText1);

		// This sets up the border color and boundaries
		loginPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		loginPanel.setBounds(200, 100, 850, 500);
		loginPanel.setLayout(null);
		loginPanel.setVisible(true);

		inputPanel.add(loginPanel);
	}

	// The frame setup method where it sets up the frame
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
		add(saveb);

	}

	// This is the music method where it allows music to be played from anywhere
	// in
	// this class.
	public static void music(String musicLocation) {

		try {
			File Sound = new File(musicLocation);
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(Sound);
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// This contains the menu bar method where it states each MenuItem
	private void MenuBar() {

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

		if (e.getSource() == userText) {

			// Checks if username is available
		}

		if (e.getSource() == saveb) {

			// Play sound effect
			// music("./sounds/exit.wav");

		}

	}

	private String readPassword() {

		char[] passArray = passText.getPassword();
		String password;

		if (passArray.length >= 1)
			password = Arrays.toString(passArray).substring(1, 3 * passArray.length - 1).replace(", ", "");
		else
			password = "";

		return password;

	}

	private String readPassword1() {

		char[] passArray = passText1.getPassword();
		String password1;

		if (passArray.length >= 1)
			password1 = Arrays.toString(passArray).substring(1, 3 * passArray.length - 1).replace(", ", "");
		else
			password1 = "";

		return password1;

	}

	private void login() {

		for (User currentUser : Database.users) {

			if ((userText.getText()).equals(currentUser.getUser()) && readPassword().equals(currentUser.getPass())) {

				System.out.println("Access granted");

				Database.currentUser = currentUser.getUser();

				new UnityProjectListScreen();
				this.dispose();
				return;

			}

		}

		System.out.println("Incorrect Username or password");

	}
}
