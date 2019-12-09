
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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
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

public class UnityNewUserScreen extends JFrame implements ActionListener {

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
	JPanel enterp = new JPanel();
	JButton enterb = new JButton();

	// Panel + Button of the Game 1 Image
	JPanel savep = new JPanel();
	JButton saveb = new JButton();

	// The text area
	JTextArea userText = new JTextArea();
	JTextArea passText = new JTextArea();
	JTextArea passText2 = new JTextArea();
	JTextArea userText2 = new JTextArea();

	// Clip variable for the music method
	static Clip clip;

	User[] userArray = new User[2];
	int access = 0;

	/*
	 * A constructor method that reads in the different methods as well as
	 * playing the startup music
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
		saveb.setIcon(new ImageIcon("./M/images/exit.png"));
		savep.setBounds(1100, 575, 70, 10);
		saveb.setBounds(1100, 575, 95, 35);
		savep.add(saveb);
		saveb.addActionListener(this);
		inputPanel.add(saveb);
		inputPanel.add(savep);

		// This sets up the border color and boundaries
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		inputPanel.setBounds(0, 0, 1280, 720);
		inputPanel.setLayout(null);
		// This is the background color of the panel
		inputPanel.setBackground(Color.CYAN);
		inputPanel.setVisible(true);

		// inputPanel.add(userText);
		// inputPanel.add(passText);
		// This sets up the font, and implements the label's boundaries in the
		// panel
		// titleLabel.setFont(new Font(null));
		// titleLabel.setBounds(100, 25, 200, 25);
		// inputPanel.add(titleLabel);

		// This makes the questions and the drop boxes implemented in the panel
		// setupWeightings();

		// report button with its dimensions as well as its action listener so
		// it can react when its clicked
		// reportButton.setBounds(575, 575, 200, 50);
		// add(reportButton);
		// reportButton.addActionListener(this);

		// This is the font of the report button as well as its border with its
		// thickness.
		// reportButton.setFont(new Font("impact", Font.PLAIN, 18));
		// reportButton.setBorder(BorderFactory.createLineBorder(Color.yellow,
		// 2));
	}

	private void loginPanel() {

		Font newFont = new Font("Serif", Font.BOLD, 22);
		userText.setFont(newFont);
		userText.setBounds(300, 100, 300, 30);
		userText.setEditable(true);
		userText.setText("Type NEW Username here:");
		userText.setBackground(Color.red);

		userText2.setFont(newFont);
		userText2.setBounds(300, 150, 300, 30);
		userText2.setEditable(true);
		userText2.setText("Retype NEW Username here:");
		userText2.setBackground(Color.red);

		passText2.setFont(newFont);
		passText2.setBounds(300, 250, 300, 30);
		passText2.setEditable(true);
		passText2.setText("Type NEW Password here:");
		passText2.setBackground(Color.red);

		Font newFont2 = new Font("Serif", Font.BOLD, 22);
		passText.setFont(newFont2);
		passText.setBounds(300, 300, 300, 30);
		passText.setEditable(true);
		passText.setText("Retype NEW Password here:");
		passText.setBackground(Color.red);
		loginPanel.add(userText);
		loginPanel.add(passText);
		loginPanel.add(userText2);
		loginPanel.add(passText2);

		// This sets the location and image of the enter button
		enterb.setIcon(new ImageIcon("./M/images/exit.png"));
		enterp.setBounds(450, 450, 70, 10);
		enterb.setBounds(450, 450, 95, 35);
		enterp.add(enterb);
		enterb.addActionListener(this);
		loginPanel.add(enterb);
		loginPanel.add(enterp);

		// This sets up the border color and boundaries
		loginPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		loginPanel.setBounds(25, 25, 1025, 600);
		loginPanel.setLayout(null);
		loginPanel.setVisible(true);
		// This is the background color of the panel
		// loginPanel.setBackground(Color.black);

		// This sets up the font, and implements the label's boundaries in the
		// panel
		// titleLabel.setFont(new Font(null));
		// titleLabel.setBounds(100, 25, 200, 25);
		// inputPanel.add(titleLabel);

		// This makes the questions and the drop boxes implemented in the panel
		// setupWeightings();

		// report button with its dimensions as well as its action listener so
		// it can react when its clicked
		// reportButton.setBounds(575, 575, 200, 50);
		// add(reportButton);
		// reportButton.addActionListener(this);

		// This is the font of the report button as well as its border with its
		// thickness.
		// reportButton.setFont(new Font("impact", Font.PLAIN, 18));
		// reportButton.setBorder(BorderFactory.createLineBorder(Color.yellow,
		// 2));
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
		add(savep);

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

		if (e.getSource() == enterb) {
			
		}
		if (e.getSource() == saveb) {

			String fileContent = userText.getText();

			BufferedWriter writer = null;

			try {
				writer = new BufferedWriter(new FileWriter("LoginUP.csv"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {

				writer.write(UnityLoginScreen.userinfo);
				writer.write(fileContent);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch blockhvjjj
				e1.printStackTrace();
			}

			System.out.println("Save User");

		}

	}

}


