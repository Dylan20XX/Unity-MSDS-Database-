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
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	private JButton addButton = new JButton("Add");
	
	//MaterialName - put in title label
	//Brand
	private JLabel brandLabel = new JLabel("Material Brand");
	private JTextArea brandTextArea = new JTextArea();
	
	//Hyperlink
	private JButton hyperlinkButton = new JButton("Purchase Material");
	
	//StorageArea
	private JLabel storageAreaLabel = new JLabel("Storage Area");
	private JTextArea storageAreaTextArea = new JTextArea();
	
	//Precautions
	private JLabel precautionsLabel = new JLabel("Precautions");
	private JTextArea precautionsTextArea = new JTextArea();
	
	//Toxic
	private JLabel toxicLabel = new JLabel("Toxic?");
	private JTextArea toxicTextArea = new JTextArea();
	
	//Stability and Reactivity
	private JLabel stabilityLabel = new JLabel("Stability & Reactivity");
	private JTextArea stabilityTextArea = new JTextArea();
	
	//First aid measures
	private JLabel firstAidLabel = new JLabel("First Aid Measures");
	private JTextArea firstAidTextArea = new JTextArea();
	
	//Dangers
	private JLabel dangersLabel = new JLabel("Dangers");
	private JTextArea dangersTextArea = new JTextArea();
	
	//Link to MSDS
	private JButton msdsButton = new JButton("View MSDS");
	
	//Main method for testing GUI
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UnityMaterialInfoScreen();
	}
	
	/**
	 * This is the constructor method
	 * @param null
	 */
	public UnityMaterialInfoScreen() {
		panelSetup();
		infoSetupTest();
		frameSetup();
	}
	
	/**
	 * This is the constructor method
	 * @param null
	 */	public UnityMaterialInfoScreen(Material material, int previousScreen) {
		this.material = material;
		this.previousScreen = previousScreen;
		panelSetup();
		infoSetup();
		frameSetup();
	}
	
	 /**
		 *This method sets up the panel with a scroll pane
		 * @param null
		 */
	private void panelSetup() {

		//Setup the panel
		materialPanel.setBounds(0,0,1280,720);
		materialPanel.setLayout(null);
		//materialPanel.setBackground(new Color(191,231,247));
		//materialPanel.setBackground(new Color(82,66,209));
		materialPanel.setBackground(new Color(140,100,209));
		materialPanel.setVisible(true); //Initially hide the highscore panel 
		
		//Setup the title label
		titleLabel.setBounds(480, 30, 400, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
		titleLabel.setText(material.getName());
		materialPanel.add(titleLabel);
		
		//Setup the add material and back buttons
		addButton.setBounds(940, 620, 200, 50);
		addButton.setFont(new Font("Arial", Font.BOLD, 24));
		addButton.addActionListener(this);
		materialPanel.add(addButton);
		
		backButton.setBounds(140, 620, 200, 50);
		backButton.setFont(new Font("Arial", Font.BOLD, 24));
		backButton.addActionListener(this);
		materialPanel.add(backButton);
		
	}
	
	/**
	 * This method sets up the scroll pane used
	 * @param null
	 */
	private void infoSetup() {
		
		//titleLabel.setText(material.getName());
		
		//Brand
		brandLabel.setBounds(400, 100, 400, 50);
		materialPanel.add(brandLabel);
		brandTextArea.setBounds(400, 150, 400, 75);
		brandTextArea.setText(material.getBrand());
		brandTextArea.setEditable(false);
		brandTextArea.setLineWrap(true);
		brandTextArea.setWrapStyleWord(true);
		materialPanel.add(brandTextArea);
		
		//Hyperlink
		hyperlinkButton.setBounds(140, 300, 200, 100);
		hyperlinkButton.addActionListener(this);
		materialPanel.add(hyperlinkButton);
		
		//StorageArea
		storageAreaLabel.setBounds(400, 225, 400, 50);
		materialPanel.add(storageAreaLabel);
		storageAreaTextArea.setBounds(400, 275, 400, 75);
		storageAreaTextArea.setText(material.getStorageArea());
		storageAreaTextArea.setEditable(false);
		storageAreaTextArea.setLineWrap(true);
		storageAreaTextArea.setWrapStyleWord(true);
		materialPanel.add(storageAreaTextArea);
		
		//Precautions
		precautionsLabel.setBounds(400, 350, 400, 50);
		materialPanel.add(precautionsLabel);
		precautionsTextArea.setBounds(400, 400, 400, 75);
		precautionsTextArea.setText(material.getPrecautions());
		precautionsTextArea.setEditable(false);
		precautionsTextArea.setLineWrap(true);
		precautionsTextArea.setWrapStyleWord(true);
		materialPanel.add(precautionsTextArea);
		
		//Toxic
		toxicLabel.setBounds(400, 475, 400, 50);
		materialPanel.add(toxicLabel);
		toxicTextArea.setBounds(400, 525, 400, 75);
		toxicTextArea.setText(material.getToxic());
		toxicTextArea.setEditable(false);
		toxicTextArea.setLineWrap(true);
		toxicTextArea.setWrapStyleWord(true);
		materialPanel.add(toxicTextArea);
		
		//Stability and Reactivity
		stabilityLabel.setBounds(820, 100, 400, 50);
		materialPanel.add(stabilityLabel);
		stabilityTextArea.setBounds(820, 150, 400, 75);
		stabilityTextArea.setText(material.getStability());
		stabilityTextArea.setEditable(false);
		stabilityTextArea.setLineWrap(true);
		stabilityTextArea.setWrapStyleWord(true);
		materialPanel.add(stabilityTextArea);
		
		//First aid measures
		firstAidLabel.setBounds(820, 225, 400, 50);
		materialPanel.add(firstAidLabel);
		firstAidTextArea.setBounds(820, 275, 400, 75);
		firstAidTextArea.setText(material.getFirstAid());
		firstAidTextArea.setEditable(false);
		firstAidTextArea.setLineWrap(true);
		firstAidTextArea.setWrapStyleWord(true);
		materialPanel.add(firstAidTextArea);
		
		//Dangers
		dangersLabel.setBounds(820, 350, 400, 50);
		materialPanel.add(dangersLabel);
		dangersTextArea.setBounds(820, 400, 400, 75);
		dangersTextArea.setText(material.getDangers());
		dangersTextArea.setEditable(false);
		dangersTextArea.setLineWrap(true);
		dangersTextArea.setWrapStyleWord(true);
		materialPanel.add(dangersTextArea);
		
		//Link to MSDS
		msdsButton.setBounds(140, 450, 200, 100);
		msdsButton.addActionListener(this);
		materialPanel.add(msdsButton);
		
	}
	
	/**
	 * This method sets up the scroll pane used
	 * @param null
	 */ 
	private void infoSetupTest() {
		
		//titleLabel.setText(material.getName());
		
		//Brand
		brandLabel.setBounds(400, 150, 400, 50);
		materialPanel.add(brandLabel);
		brandTextArea.setBounds(400, 200, 400, 50);
		//brandTextArea.setText(material.getBrand());
		materialPanel.add(brandTextArea);
		
		//Hyperlink
		hyperlinkButton.setBounds(140, 300, 200, 100);
		hyperlinkButton.addActionListener(this);
		materialPanel.add(hyperlinkButton);
		
		//StorageArea
		storageAreaLabel.setBounds(400, 250, 400, 50);
		materialPanel.add(storageAreaLabel);
		storageAreaTextArea.setBounds(400, 300, 400, 50);
		//storageAreaTextArea.setText(material.getStorageArea());
		materialPanel.add(storageAreaTextArea);
		
		//Precautions
		precautionsLabel.setBounds(400, 350, 400, 50);
		materialPanel.add(precautionsLabel);
		precautionsTextArea.setBounds(400, 400, 400, 50);
		//precautionsTextArea.setText(material.getPrecautions());
		materialPanel.add(precautionsTextArea);
		
		//Toxic
		toxicLabel.setBounds(400, 450, 400, 50);
		materialPanel.add(toxicLabel);
		toxicTextArea.setBounds(400, 500, 400, 50);
		//toxicTextArea.setText(material.getToxic());
		materialPanel.add(toxicTextArea);
		
		//Stability and Reactivity
		stabilityLabel.setBounds(820, 150, 400, 50);
		materialPanel.add(stabilityLabel);
		stabilityTextArea.setBounds(820, 200, 400, 50);
		//stabilityTextArea.setText(material.getStability());
		materialPanel.add(stabilityTextArea);
		
		//First aid measures
		firstAidLabel.setBounds(820, 250, 400, 50);
		materialPanel.add(firstAidLabel);
		firstAidTextArea.setBounds(820, 300, 400, 50);
		//firstAidTextArea.setText(material.getFirstAid());
		materialPanel.add(firstAidTextArea);
		
		//Dangers
		dangersLabel.setBounds(820, 350, 400, 50);
		materialPanel.add(dangersLabel);
		dangersTextArea.setBounds(820, 400, 400, 50);
		//dangersTextArea.setText(material.getDangers());
		materialPanel.add(dangersTextArea);
		
		//Link to MSDS
		msdsButton.setBounds(140, 450, 200, 100);
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
		//getContentPane().setBackground(new Color(191,231,247));
		
		add(materialPanel);
		
		//Prevent the program from running when the frame is closed, prevent the 
		//frame from being resized, and make the frame visible
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	/**
	 * This method opens the hyperlink
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
		
		if(e.getSource() == hyperlinkButton) {
			openWebBrowser(material.getHyperlink());
		} else if(e.getSource() == msdsButton) {
			openWebBrowser(material.getMsdsLink());
		} else if(e.getSource() == backButton) {
			
			if(previousScreen == 0)
				new UnityMaterialSelectionScreen();
			else if(previousScreen == 1)
				new UnityReportScreen();
			
			this.dispose();
			
		} else if(e.getSource() == addButton) {
			
		}
		
	}
	
}
