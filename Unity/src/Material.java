
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
	
	//Set Quantity Button
	//Set Quantity
	//Info Button
	//Name Label
	//Quantity Label
	
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
		this.quantity = quantity;
	}

	//toString method
	@Override
	public String toString() {
		return "Material [name=" + name + ", brand=" + brand + ", hyperlink=" + hyperlink + ", storageArea="
				+ storageArea + ", precautions=" + precautions + ", toxic=" + toxic + ", stability=" + stability
				+ ", firstAid=" + firstAid + ", dangers=" + dangers + ", msdsLink=" + msdsLink + "]";
	}
	
}
