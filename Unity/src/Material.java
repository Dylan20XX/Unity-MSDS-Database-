import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	//Material type - may not be necessary
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
	
	//Components to be used in material selection screen
	private JButton quantityButton = new JButton("Set Amount");
	private JTextField quantityField = new JTextField();
	private JButton infoButton = new JButton("Info");
	private JLabel nameLabel = new JLabel();
	
	//Constructors
	/**
	 * This is the constructor method
	 * @param null
	 */
	public Material() {
	}
	/**
	 * Assigns info
	 * @param name
	 * @param brand
	 * @param hyperlink
	 * @param storageArea
	 * @param precautions
	 * @param toxic
	 * @param stability
	 * @param firstAid
	 * @param dangers
	 * @param msdsLink
	 */
	public Material(String name, String brand, String hyperlink, String storageArea, String precautions, String toxic,
			String stability, String firstAid, String dangers, String msdsLink) {
		super();
		this.name = name;
		this.brand = brand;
		this.hyperlink = hyperlink;
		this.storageArea = storageArea;
		this.precautions = precautions;
		this.toxic = toxic;
		this.stability = stability;
		this.firstAid = firstAid;
		this.dangers = dangers;
		this.msdsLink = msdsLink;
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
	/**
	 * Creates JObjects for each material
	 */
	public void setupComponents() {
		
		//Test Buttons
		quantityButton.setSize(200, 50);
		quantityButton.setMaximumSize(quantityButton.getSize());
		quantityButton.setMinimumSize(quantityButton.getSize());
		quantityButton.setPreferredSize(quantityButton.getSize());
		quantityButton.setFont(new Font("Arial", Font.BOLD, 24));
		
		infoButton.setSize(100, 50);
		infoButton.setMaximumSize(infoButton.getSize());
		infoButton.setMinimumSize(infoButton.getSize());
		infoButton.setPreferredSize(infoButton.getSize());
		infoButton.setFont(new Font("Arial", Font.BOLD, 24));
		
		nameLabel.setText(name);
		nameLabel.setSize(650, 50);
		nameLabel.setMaximumSize(nameLabel.getSize());
		nameLabel.setMinimumSize(nameLabel.getSize());
		nameLabel.setPreferredSize(nameLabel.getSize());
		nameLabel.setFont(new Font("Arial", Font.BOLD, 36));
		
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
		
	}
	/**
	 * 
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
		
	}

	//toString method
	@Override
	/**
	 * Returns strings 
	 */
	public String toString() {
		return "Material [name=" + name + ", brand=" + brand + ", hyperlink=" + hyperlink + ", storageArea="
				+ storageArea + ", precautions=" + precautions + ", toxic=" + toxic + ", stability=" + stability
				+ ", firstAid=" + firstAid + ", dangers=" + dangers + ", msdsLink=" + msdsLink + "]";
	}
	
}
