package Objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Utility.Assets;
/**
 * 
 * @author Dylan
 *
 */
public class Material {
/**
 * This class is used to make material objects and sign information to them accordingly
 * @param file input information
 */
	//MaterialName
	//Brand
	//Hyperlink
	//StorageArea
	//Precautions
	//Toxic
	//Stability and Reactivity
	//First aid measures
	//Dangers
	//Link to MSDS
	
	private String name;
	private String brand;
	private String hyperlink;
	private String storageArea;
	private String precautions;
	private String toxic;
	private String stability;
	private String firstAid;
	private String dangers;
	private String msdsLink;
	
	private int quantity = 0;
	private int environmentImpact;
	
	//Components to be used in material selection screen
	private JButton quantityButton = new JButton();
	private JTextField quantityField = new JTextField();
	private JButton infoButton = new JButton();
	private JLabel nameLabel = new JLabel();
	private JLabel environmentLabel = new JLabel();
	
	private ImageIcon image;
	
	//Constructors
	/**
	 * This is the constructor method
	 * @param null
	 */
	public Material() {
	}

	//Getters and setters
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return name;
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}
	/**
	 * 
	 * @return brand;
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getHyperlink() {
		return hyperlink;
	}
	/**
	 * 
	 * @return hyperlink;
	 */
	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	public String getStorageArea() {
		return storageArea;
	}
	/**
	 * 
	 * @return StorageArea;
	 */
	public void setStorageArea(String storageArea) {
		this.storageArea = storageArea;
	}

	public String getPrecautions() {
		return precautions;
	}
	/**
	 * 
	 * @return precautions;
	 */
	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

	public String getToxic() {
		return toxic;
	}
	/**
	 * 
	 * @return Toxic;
	 */
	public void setToxic(String toxic) {
		this.toxic = toxic;
	}

	public String getStability() {
		return stability;
	}
	/**
	 * 
	 * @return Stability;
	 */
	public void setStability(String stability) {
		this.stability = stability;
	}

	public String getFirstAid() {
		return firstAid;
	}
	/**
	 * 
	 * @return FirstAid;
	 */
	public void setFirstAid(String firstAid) {
		this.firstAid = firstAid;
	}

	public String getDangers() {
		return dangers;
	}
	/**
	 * 
	 * @return Dangers;
	 */
	public void setDangers(String dangers) {
		this.dangers = dangers;
	}

	public String getMsdsLink() {
		return msdsLink;
	}
	/**
	 * 
	 * @return MSDSLink;
	 */
	public void setMsdsLink(String msdsLink) {
		this.msdsLink = msdsLink;
	}
	
	public int getQuantity() {
		return quantity;
	}
	/**
	 * 
	 * @return Quantity;
	 */
	public void setQuantity(int quantity) {
		
		if(quantity <= 0)
			this.quantity = 0;
		
		if(quantity <= 0) {
			quantityField.setText("0");
			quantityField.setBackground(Color.GRAY);
		} else {
			quantityField.setBackground(Color.WHITE);
		}
		
		this.quantity = quantity;
		
	}
	
	public int getEnvironmentImpact() {
		return environmentImpact;
	}
	
	public void setEnvironmentImpact(int environmentImpact) {
		this.environmentImpact = environmentImpact;
	}
/**
 * @return quantityButton
 */
	public JButton getQuantityButton() {
		return quantityButton;
	}

	public void setQuantityButton(JButton quanityButton) {
		this.quantityButton = quanityButton;
	}
	/**
	 * @return quantityField
	 */
	public JTextField getQuantityField() {
		return quantityField;
	}

	public void setQuantityField(JTextField quantityField) {
		this.quantityField = quantityField;
	}
	/**
	 * @return infoButton
	 */
	public JButton getInfoButton() {
		return infoButton;
	}

	public void setInfoButton(JButton infoButton) {
		this.infoButton = infoButton;
	}
	/**
	 * @return nameLabel
	 */
	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}
	
	public ImageIcon getImage() {
		return image;
	}
	
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	public JLabel getEnvironmentLabel() {
		return environmentLabel;
	}
	public void setEnvironmentLabel(JLabel environmentLabel) {
		this.environmentLabel = environmentLabel;
	}
	/**
	 * Sets up JObjects for each material
	 */
	public void setupComponents() {
		
		//Quantity Button
		quantityButton.setSize(100, 50);
		quantityButton.setIcon(Assets.setAmountButton);
		quantityButton.setBackground(Color.ORANGE);
		quantityButton.setMaximumSize(quantityButton.getSize());
		quantityButton.setMinimumSize(quantityButton.getSize());
		quantityButton.setPreferredSize(quantityButton.getSize());
		
		//Info Button
		infoButton.setSize(100, 50);
		infoButton.setIcon(Assets.infoButton);
		infoButton.setBackground(Color.YELLOW);
		infoButton.setMaximumSize(infoButton.getSize());
		infoButton.setMinimumSize(infoButton.getSize());
		infoButton.setPreferredSize(infoButton.getSize());
		
		//Name Label
		nameLabel.setText(name);
		nameLabel.setSize(650, 50);
		nameLabel.setMaximumSize(nameLabel.getSize());
		nameLabel.setMinimumSize(nameLabel.getSize());
		nameLabel.setPreferredSize(nameLabel.getSize());
		nameLabel.setFont(new Font("Arial", Font.BOLD, 36));
		
		//Quantity Text Field
		quantityField.setText(Integer.toString(quantity));
		
		if(quantity == 0)
			quantityField.setBackground(Color.GRAY);
		else
			quantityField.setBackground(Color.WHITE);
		
		quantityField.setHorizontalAlignment(SwingConstants.CENTER);
		quantityField.setSize(50, 50);
		quantityField.setMaximumSize(quantityField.getSize());
		quantityField.setMinimumSize(quantityField.getSize());
		quantityField.setPreferredSize(quantityField.getSize());
		quantityField.setFont(new Font("Arial", Font.BOLD, 24));
		
		//Environment Label
		environmentLabel.setText(Integer.toString(environmentImpact));
		environmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		environmentLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		environmentLabel.setSize(100, 50);
		environmentLabel.setMaximumSize(environmentLabel.getSize());
		environmentLabel.setMinimumSize(environmentLabel.getSize());
		environmentLabel.setPreferredSize(environmentLabel.getSize());
		environmentLabel.setFont(new Font("Arial", Font.BOLD, 36));
		
		if(environmentImpact <= 30) {
			environmentLabel.setBackground(Color.GREEN);
		} else if(environmentImpact <= 70) {
			environmentLabel.setBackground(Color.YELLOW);
		} else {
			environmentLabel.setBackground(Color.RED);
		}
		
		environmentLabel.setOpaque(true);
		
	}
	
	//Sets up components for the report screen
	public void setupComponentsReport() {
		
		//Quantity Button
		quantityButton.setSize(100, 50);
		quantityButton.setIcon(Assets.setAmountButton);
		quantityButton.setBackground(Color.ORANGE);
		quantityButton.setMaximumSize(quantityButton.getSize());
		quantityButton.setMinimumSize(quantityButton.getSize());
		quantityButton.setPreferredSize(quantityButton.getSize());
		
		//Info Button
		infoButton.setSize(100, 50);
		infoButton.setIcon(Assets.infoButton);
		infoButton.setBackground(Color.YELLOW);
		infoButton.setMaximumSize(infoButton.getSize());
		infoButton.setMinimumSize(infoButton.getSize());
		infoButton.setPreferredSize(infoButton.getSize());
		
		//Name Label
		nameLabel.setText(name);
		nameLabel.setSize(450, 50);
		nameLabel.setMaximumSize(nameLabel.getSize());
		nameLabel.setMinimumSize(nameLabel.getSize());
		nameLabel.setPreferredSize(nameLabel.getSize());
		nameLabel.setFont(new Font("Arial", Font.BOLD, 36));
		
		//Quantity Text Field
		quantityField.setText(Integer.toString(quantity));
		
		if(quantity == 0)
			quantityField.setBackground(Color.GRAY);
		else
			quantityField.setBackground(Color.WHITE);
		
		quantityField.setHorizontalAlignment(SwingConstants.CENTER);
		quantityField.setSize(50, 50);
		quantityField.setMaximumSize(quantityField.getSize());
		quantityField.setMinimumSize(quantityField.getSize());
		quantityField.setPreferredSize(quantityField.getSize());
		quantityField.setFont(new Font("Arial", Font.BOLD, 24));
		
		//Environment Label
		environmentLabel.setText(Integer.toString(environmentImpact));
		environmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		environmentLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		environmentLabel.setSize(100, 50);
		environmentLabel.setMaximumSize(environmentLabel.getSize());
		environmentLabel.setMinimumSize(environmentLabel.getSize());
		environmentLabel.setPreferredSize(environmentLabel.getSize());
		environmentLabel.setFont(new Font("Arial", Font.BOLD, 36));
		
		if(environmentImpact <= 30) {
			environmentLabel.setBackground(Color.GREEN);
		} else if(environmentImpact <= 70) {
			environmentLabel.setBackground(Color.YELLOW);
		} else {
			environmentLabel.setBackground(Color.RED);
		}
		
		environmentLabel.setOpaque(true);
		
	}
	
	/**
	 * This method allows materials to be copied
	 * @param materialToCopy
	 */
	public void copyMaterial(Material materialToCopy) {
		
		setName(materialToCopy.getName());
		setBrand(materialToCopy.getBrand());
		setHyperlink(materialToCopy.getHyperlink());
		setStorageArea(materialToCopy.getStorageArea());
		setPrecautions(materialToCopy.getPrecautions());
		setToxic(materialToCopy.getToxic());
		setStability(materialToCopy.getStability());
		setFirstAid(materialToCopy.getFirstAid());
		setDangers(materialToCopy.getDangers());
		setMsdsLink(materialToCopy.getMsdsLink());
		
		setQuantity(materialToCopy.getQuantity());
		setEnvironmentImpact(materialToCopy.getEnvironmentImpact());
		
	}
	
	//This method sets up the ImageIcon variable of a material
	public void setupImage() {
		image = new ImageIcon(new ImageIcon(String.format("Images/Materials/%s.jpg", name)).
			getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
	}

	//toString method
	@Override
	/**
	 * Returns strings 
	 */
	public String toString() {
		return "Material [name=" + name + ", brand=" + brand + ", hyperlink=" + hyperlink + ", storageArea="
				+ storageArea + ", precautions=" + precautions + ", toxic=" + toxic + ", stability=" + stability
				+ ", firstAid=" + firstAid + ", dangers=" + dangers + ", msdsLink=" + msdsLink + ", quantity="
				+ quantity + ", environmentImpact=" + environmentImpact + "]";
	}
	
}
