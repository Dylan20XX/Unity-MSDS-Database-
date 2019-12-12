import java.awt.Image;

import javax.swing.ImageIcon;

public class Assets {
	
	//Backgrounds
	public static ImageIcon loginBackground = backgroundImageSetup("Images/GUI/Login screen.png");
	
	//Buttons 
	//public static ImageIcon createButton = buttonImageSetup("Images/GUI/Create Project Button.png");
	//public static ImageIcon deleteButton = buttonImageSetup("Images/GUI/Delete Button.png");
	
	//Material Images
	//public static ImageIcon charcoalPencil = buttonImageSetup("Images/Materials/Charcoal pencil.jpg");
	//public static ImageIcon instantPaperMache= buttonImageSetup("Images/Materials/Instant Paper Mache.jpg");
	//public static ImageIcon oilPastel = buttonImageSetup("Images/Materials/Oil Pastel.jpg");
	//public static ImageIcon pencilColourSticks = materialImageSetup("Images/Materials/Pencils _ Colour Sticks.jpg");	
	
	//This method returns a scaled image (200x100)
	private static ImageIcon buttonImageSetup(String imagePath) {
		return new ImageIcon(new ImageIcon(imagePath).
				getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
	}
	
	//This method returns a scaled image (200x200)
	private static ImageIcon materialImageSetup(String imagePath) {
		return new ImageIcon(new ImageIcon(imagePath).
				getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
	}
	
	//This method returns a scaled image 1280x720)	
	private static ImageIcon backgroundImageSetup(String imagePath) {
		return new ImageIcon(new ImageIcon(imagePath).
				getImage().getScaledInstance(1280, 720, Image.SCALE_FAST));
	}
	
}
