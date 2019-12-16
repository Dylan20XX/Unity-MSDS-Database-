package Screens;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Objects.Material;
/**
 * 
 * @author Dylan
 *
 */
public class UnityMaterialInfoScreen extends JFrame implements ActionListener {
/**
 * This class creates the Material Info GUI
 * @param Material info
 */
	
	private Material material; //Material that is having its info viewed
	private int previousScreen;
	
	private JPanel materialPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Material Info"); 
	private JButton backButton = new JButton("Back");
	private JButton setQuantityButton = new JButton("Set Amount");
	
	//MaterialName - put in title label
	//Brand
	private JLabel brandLabel = new JLabel("Material Brand");
	private JTextArea brandTextArea = new JTextArea();
	private JScrollPane brandScrollPane = new JScrollPane(brandTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//Hyperlink
	private JButton hyperlinkButton = new JButton("<html><center>Purchase<br>Material</center></html>");
	
	//StorageArea
	private JLabel storageAreaLabel = new JLabel("Storage Area");
	private JTextArea storageAreaTextArea = new JTextArea();
	private JScrollPane storageAreaScrollPane = new JScrollPane(storageAreaTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//Precautions
	private JLabel precautionsLabel = new JLabel("Precautions");
	private JTextArea precautionsTextArea = new JTextArea();
	private JScrollPane precautionsScrollPane = new JScrollPane(precautionsTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//Toxic
	private JLabel toxicLabel = new JLabel("Toxic?");
	private JTextArea toxicTextArea = new JTextArea();
	private JScrollPane toxicScrollPane = new JScrollPane(toxicTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//Stability and Reactivity
	private JLabel stabilityLabel = new JLabel("Stability & Reactivity");
	private JTextArea stabilityTextArea = new JTextArea();
	private JScrollPane stabilityScrollPane = new JScrollPane(stabilityTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//First aid measures
	private JLabel firstAidLabel = new JLabel("First Aid Measures");
	private JTextArea firstAidTextArea = new JTextArea();
	private JScrollPane firstAidScrollPane = new JScrollPane(firstAidTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//Dangers
	private JLabel dangersLabel = new JLabel("Dangers");
	private JTextArea dangersTextArea = new JTextArea();
	private JScrollPane dangersScrollPane = new JScrollPane(dangersTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//Dangers
	private JLabel environmentLabel = new JLabel("Environmental Impact");
	private JTextArea environmentTextArea = new JTextArea();
	private JScrollPane environmentScrollPane = new JScrollPane(environmentTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//Link to MSDS
	private JButton msdsButton = new JButton("View MSDS");
	
	//Material Image Label
	private JLabel imageLabel = new JLabel();
	
	//Menu bar components
	private JMenuBar menubar = new JMenuBar();
	private JMenu exitMenu = new JMenu ("Exit");
	private JMenuItem exitProgram = new JMenuItem ("Exit Program");
	
	/**
	 * This is the constructor method
	 * @param null
	 */	
	public UnityMaterialInfoScreen(Material material, int previousScreen) {
		this.material = material;
		this.previousScreen = previousScreen;
		menuBarSetup();
		panelSetup();
		infoSetup();
		frameSetup();
	}
	
	//This method sets up the menu bar
	private void menuBarSetup() {
        
        exitProgram.addActionListener(this);
        exitMenu.add (exitProgram);
        menubar.add (exitMenu);
        
        menubar.setBounds (0, 0, 1280, 25);
        add(menubar);
        
	}
	
	 /**
		 *This method sets up the panel with a scroll pane
		 * @param null
		 */
	private void panelSetup() {

		//Setup the panel
		materialPanel.setBounds(0,0,1280,720);
		materialPanel.setLayout(null);
		materialPanel.setBackground(new Color(140,100,209));
		materialPanel.setVisible(true); 
		
		//Set up the title label
		titleLabel.setBounds(480, 30, 400, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
		titleLabel.setText(material.getName());
		materialPanel.add(titleLabel);
		
		//Set up the set quantity button
		setQuantityButton.setBounds(1020, 620, 200, 50);
		setQuantityButton.setFont(new Font("Arial", Font.BOLD, 24));
		setQuantityButton.setBackground(Color.ORANGE);
		setQuantityButton.addActionListener(this);
		materialPanel.add(setQuantityButton);
		
		//Set up the back button
		backButton.setBounds(140, 620, 200, 50);
		backButton.setFont(new Font("Arial", Font.BOLD, 24));
		backButton.setBackground(Color.ORANGE);
		backButton.addActionListener(this);
		materialPanel.add(backButton);
		
		//Set up the quantity field
		material.getQuantityField().setLocation(950, 620);
		materialPanel.add(material.getQuantityField());
		
	}
	
	/**
	 * This method sets up the scroll pane used
	 * @param null
	 */
	private void infoSetup() {
		
		//Image Label
		imageLabel.setBounds(140, 80, 200, 200);
		imageLabel.setIcon(material.getImage());
		materialPanel.add(imageLabel);
		
		//Brand
		brandLabel.setBounds(400, 100, 400, 50);
		brandLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(brandLabel);
		brandScrollPane.setBounds(400, 150, 400, 75);
		brandTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
		brandTextArea.setText(material.getBrand());
		brandTextArea.setEditable(false);
		brandTextArea.setLineWrap(true);
		brandTextArea.setWrapStyleWord(true);
		brandTextArea.setSelectionStart(0);
		brandTextArea.setSelectionEnd(0); 
		materialPanel.add(brandScrollPane);
		
		//Hyperlink
		hyperlinkButton.setBounds(140, 300, 200, 100);
		hyperlinkButton.setFont(new Font("Arial", Font.BOLD, 24));
		hyperlinkButton.setBackground(Color.ORANGE);
		hyperlinkButton.addActionListener(this);
		materialPanel.add(hyperlinkButton);
		
		//StorageArea
		storageAreaLabel.setBounds(400, 225, 400, 50);
		storageAreaLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(storageAreaLabel);
		storageAreaScrollPane.setBounds(400, 275, 400, 75);
		storageAreaTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
		storageAreaTextArea.setText(material.getStorageArea());
		storageAreaTextArea.setEditable(false);
		storageAreaTextArea.setLineWrap(true);
		storageAreaTextArea.setWrapStyleWord(true);
		storageAreaTextArea.setSelectionStart(0);
		storageAreaTextArea.setSelectionEnd(0); 
		materialPanel.add(storageAreaScrollPane);
		
		//Precautions
		precautionsLabel.setBounds(400, 350, 400, 50);
		precautionsLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(precautionsLabel);
		precautionsScrollPane.setBounds(400, 400, 400, 75);
		precautionsTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
		precautionsTextArea.setText(material.getPrecautions());
		precautionsTextArea.setEditable(false);
		precautionsTextArea.setLineWrap(true);
		precautionsTextArea.setWrapStyleWord(true);
		precautionsTextArea.setSelectionStart(0);
		precautionsTextArea.setSelectionEnd(0);
		materialPanel.add(precautionsScrollPane);
		
		//Toxic
		toxicLabel.setBounds(400, 475, 400, 50);
		toxicLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(toxicLabel);
		toxicScrollPane.setBounds(400, 525, 400, 75);
		toxicTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
		toxicTextArea.setText(material.getToxic());
		toxicTextArea.setEditable(false);
		toxicTextArea.setLineWrap(true);
		toxicTextArea.setWrapStyleWord(true);
		toxicTextArea.setSelectionStart(0);
		toxicTextArea.setSelectionEnd(0);
		materialPanel.add(toxicScrollPane);
		
		//Stability and Reactivity
		stabilityLabel.setBounds(820, 100, 400, 50);
		stabilityLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(stabilityLabel);
		stabilityScrollPane.setBounds(820, 150, 400, 75);
		stabilityTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
		stabilityTextArea.setText(material.getStability());
		stabilityTextArea.setEditable(false);
		stabilityTextArea.setLineWrap(true);
		stabilityTextArea.setWrapStyleWord(true);
		stabilityTextArea.setSelectionStart(0);
		stabilityTextArea.setSelectionEnd(0); 
		materialPanel.add(stabilityScrollPane);
		
		//First aid measures
		firstAidLabel.setBounds(820, 225, 400, 50);
		firstAidLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(firstAidLabel);
		firstAidScrollPane.setBounds(820, 275, 400, 75);
		firstAidTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
		firstAidTextArea.setText(material.getFirstAid());
		firstAidTextArea.setEditable(false);
		firstAidTextArea.setLineWrap(true);
		firstAidTextArea.setWrapStyleWord(true);
		firstAidTextArea.setSelectionStart(0);
		firstAidTextArea.setSelectionEnd(0);
		materialPanel.add(firstAidScrollPane);
		
		//Dangers
		dangersLabel.setBounds(820, 350, 400, 50);
		dangersLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(dangersLabel);
		dangersScrollPane.setBounds(820, 400, 400, 75);
		dangersTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
		dangersTextArea.setText(material.getDangers());
		dangersTextArea.setEditable(false);
		dangersTextArea.setLineWrap(true);
		dangersTextArea.setWrapStyleWord(true);
		dangersTextArea.setSelectionStart(0);
		dangersTextArea.setSelectionEnd(0);
		materialPanel.add(dangersScrollPane);
		
		//Environment
		environmentLabel.setBounds(820, 475, 400, 50);
		environmentLabel.setFont(new Font("Arial", Font.BOLD, 24));
		materialPanel.add(environmentLabel);
		environmentScrollPane.setBounds(820, 525, 400, 75);
		environmentTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
		environmentTextArea.setText(Integer.toString(material.getEnvironmentImpact()));
		environmentTextArea.setEditable(false);
		environmentTextArea.setLineWrap(true);
		environmentTextArea.setWrapStyleWord(true);
		environmentTextArea.setSelectionStart(0);
		environmentTextArea.setSelectionEnd(0);
		materialPanel.add(environmentScrollPane);
		
		//Link to MSDS
		msdsButton.setBounds(140, 450, 200, 100);
		msdsButton.setFont(new Font("Arial", Font.BOLD, 24));
		msdsButton.setBackground(Color.ORANGE);
		msdsButton.addActionListener(this);
		materialPanel.add(msdsButton);
		
	}
	
	/**
	 * This method sets up the JFrame
	 * @param null
	 */
	private void frameSetup() {
		
		//Set the title and frame size
		setTitle("Unity");
		setSize(1280, 720);
		setLayout(null);
		
		add(materialPanel);
		
		//Prevent the program from running when the frame is closed, prevent the 
		//frame from being resized, and make the frame visible
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	/**
	 * This method opens a hyperlink
	 * @param hyperlink
	 */
	private void openWebBrowser(String hyperlink) {
		
		if(hyperlink.equals(""))
			return;
		
		if(Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(hyperlink));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}

	}

	@Override
	/**
	 * This method checks for user inputs in order to perform tasks
	 * @param userinput
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == hyperlinkButton) { //Open a link to purchase the material
			openWebBrowser(material.getHyperlink());
		} else if(e.getSource() == msdsButton) { //Open a link to the material's MSDS
			openWebBrowser(material.getMsdsLink());
		} else if(e.getSource() == backButton) { //Return to the previous screen
			
			if(previousScreen == 0)
				new UnityMaterialSelectionScreen();
			else if(previousScreen == 1)
				new UnityReportScreen();
			
			this.dispose();
			
		} else if(e.getSource() == setQuantityButton) { //Set the quantity of the material to be used in the project
			material.setQuantity(Integer.parseInt(material.getQuantityField().getText()));
		} else if(e.getSource() == exitProgram) { //Exit the program
			System.exit(0);
		}
		
	}
	
}
