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

public class UnityMaterialInfoScreen extends JFrame implements ActionListener {
	
	private Material material; //Material that is having its info viewed
	
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
	public static void main(String[] args) {
		new UnityMaterialInfoScreen();
	}
	
	//Constructor method
	public UnityMaterialInfoScreen() {
		panelSetup();
		infoSetup();
		frameSetup();
	}
	
	//Constructor method
	public UnityMaterialInfoScreen(Material material) {
		this.material = material;
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
		toxicLabel.setBounds(820, 150, 400, 50);
		materialPanel.add(toxicLabel);
		toxicTextArea.setBounds(820, 200, 400, 50);
		//toxicTextArea.setText(material.getToxic());
		materialPanel.add(toxicTextArea);
		
		//Stability and Reactivity
		stabilityLabel.setBounds(820, 250, 400, 50);
		materialPanel.add(stabilityLabel);
		stabilityTextArea.setBounds(820, 300, 400, 50);
		//stabilityTextArea.setText(material.getStability());
		materialPanel.add(stabilityTextArea);
		
		//First aid measures
		firstAidLabel.setBounds(820, 350, 400, 50);
		materialPanel.add(firstAidLabel);
		firstAidTextArea.setBounds(820, 400, 400, 50);
		//firstAidTextArea.setText(material.getFirstAid());
		materialPanel.add(firstAidTextArea);
		
		//Dangers
		dangersLabel.setBounds(820, 450, 400, 50);
		materialPanel.add(dangersLabel);
		dangersTextArea.setBounds(820, 500, 400, 50);
		//dangersTextArea.setText(material.getDangers());
		materialPanel.add(dangersTextArea);
		
		//Link to MSDS
		msdsButton.setBounds(140, 450, 200, 100);
		msdsButton.addActionListener(this);
		materialPanel.add(msdsButton);
		
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
	
	//This method opens the links a web browser
	private void openWebBrowser(String hyperLink) {

		if(Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(hyperLink));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == hyperlinkButton) {
			openWebBrowser(material.getHyperlink());
		}
		
		if(e.getSource() == msdsButton) {
			openWebBrowser(material.getMsdsLink());
		}
		
	}
	
}
