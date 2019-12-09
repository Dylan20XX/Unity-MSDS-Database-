import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Material {

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
	public Material() {
	}

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

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	public String getStorageArea() {
		return storageArea;
	}

	public void setStorageArea(String storageArea) {
		this.storageArea = storageArea;
	}

	public String getPrecautions() {
		return precautions;
	}

	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

	public String getToxic() {
		return toxic;
	}

	public void setToxic(String toxic) {
		this.toxic = toxic;
	}

	public String getStability() {
		return stability;
	}

	public void setStability(String stability) {
		this.stability = stability;
	}

	public String getFirstAid() {
		return firstAid;
	}

	public void setFirstAid(String firstAid) {
		this.firstAid = firstAid;
	}

	public String getDangers() {
		return dangers;
	}

	public void setDangers(String dangers) {
		this.dangers = dangers;
	}

	public String getMsdsLink() {
		return msdsLink;
	}

	public void setMsdsLink(String msdsLink) {
		this.msdsLink = msdsLink;
	}
	
	public int getQuantity() {
		return quantity;
	}

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

	public JButton getQuantityButton() {
		return quantityButton;
	}

	public void setQuantityButton(JButton quanityButton) {
		this.quantityButton = quanityButton;
	}

	public JTextField getQuantityField() {
		return quantityField;
	}

	public void setQuantityField(JTextField quantityField) {
		this.quantityField = quantityField;
	}

	public JButton getInfoButton() {
		return infoButton;
	}

	public void setInfoButton(JButton infoButton) {
		this.infoButton = infoButton;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}
	
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
	public String toString() {
		return "Material [name=" + name + ", brand=" + brand + ", hyperlink=" + hyperlink + ", storageArea="
				+ storageArea + ", precautions=" + precautions + ", toxic=" + toxic + ", stability=" + stability
				+ ", firstAid=" + firstAid + ", dangers=" + dangers + ", msdsLink=" + msdsLink + "]";
	}
	
}
