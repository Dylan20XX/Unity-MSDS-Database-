package Utility;

import java.awt.Image;

import javax.swing.ImageIcon;

import Screens.UnityProjectListScreen;
/**
 * 
 * @author Dylan
 *
 */
public class Assets {
	/**
	 * This class is used for creating scaled images instead of having to import everytime.
	 * @param imageicon
	 * @see UnityProjectListScreen
	 */
	//Backgrounds
	public static ImageIcon loginBackground = backgroundImageSetup("Images/GUI/Login Screen.png");
	public static ImageIcon projectListBackground = backgroundImageSetup("Images/GUI/Project List Screen.png");
	public static ImageIcon reportBackground = backgroundImageSetup("Images/GUI/Report Screen.png");
	public static ImageIcon helpBackground = backgroundImageSetup("Images/GUI/Unity Help Screen.png");
	
	//Buttons 
	public static ImageIcon createButton = buttonImageSetup("Images/GUI/Create Project Button.png");
	public static ImageIcon deleteButton = buttonImageSetup("Images/GUI/Delete Button.png");
	
	public static ImageIcon setAmountButton = smallButtonImageSetup("Images/GUI/Set Amount Button.png");
	public static ImageIcon infoButton  = smallButtonImageSetup("Images/GUI/Info Button.png");
	public static ImageIcon saveButton = buttonImageSetup("Images/GUI/Save Button.png");
	
	//Material Images
	//public static ImageIcon charcoalPencil = buttonImageSetup("Images/Materials/Charcoal pencil.jpg");
	//public static ImageIcon instantPaperMache= buttonImageSetup("Images/Materials/Instant Paper Mache.jpg");
	//public static ImageIcon oilPastel = buttonImageSetup("Images/Materials/Oil Pastel.jpg");
	//public static ImageIcon pencilColourSticks = materialImageSetup("Images/Materials/Pencils _ Colour Sticks.jpg");	
	//public static ImageIcon powderedMaterials = materialImageSetup("Images/Materials/Powdered Materials.jpg");	
	
	//This method returns a scaled image (200x100)
	/**
	 * @param imagePath
	 * @return ScaledImage
	 */
	private static ImageIcon buttonImageSetup(String imagePath) {
		return new ImageIcon(new ImageIcon(imagePath).
				getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
	}
	/**
	 * @param imagePath
	 * @return ScaledImage
	 */
	//This method returns a scaled image (200x200)
	private static ImageIcon smallButtonImageSetup(String imagePath) {
		return new ImageIcon(new ImageIcon(imagePath).
				getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH));
	}
	/**
	 * @param imagePath
	 * @return ScaledImage
	 */
	//This method returns a scaled image 1280x720)	
	private static ImageIcon backgroundImageSetup(String imagePath) {
		return new ImageIcon(new ImageIcon(imagePath).
				getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH));
	}
	
}
