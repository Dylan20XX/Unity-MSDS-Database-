import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class UnityTextInputScreen extends JFrame implements ActionListener{
/**
 * This class was a prototype and didn't end up being used 
 * @author Kavish
 */
	JPanel textinputpanel = new JPanel();
	JMenuBar menu = new JMenuBar();
	JMenu file = new JMenu("file");
	JMenuItem SAVE = new JMenuItem("SAVE");
	JMenuItem BACK = new JMenuItem("BACK");
	JLabel title = new JLabel("Text Input");
	JTextArea main = new JTextArea();
	JTextArea links = new JTextArea();
	JButton linktext = new JButton("Link Text");
	JButton deletelink = new JButton("Delete Link");
	JLabel maintextlabel = new JLabel("Art Information");
	JLabel hyperlinks = new JLabel("Current Link");
	
	public UnityTextInputScreen(){
		PanelSetup();
		frameSetup(); 
}
	
		
	private void frameSetup() {
		// TODO Auto-generated method stub
		setSize(1280,720);
		setLayout(null);
		add(textinputpanel);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Text Input");
		setJMenuBar(menu);
	}


	private void PanelSetup() {
		// TODO Auto-generated method stub
		textinputpanel.setBounds(0, 0, 1270, 710);
		textinputpanel.setLayout(null);
		textinputpanel.setBackground(Color.CYAN);
		file.add(SAVE);
		file.add(BACK);
		menu.add(file);
		
		title.setBounds(530, 0, 900, 100);
		title.setFont(new Font("Serif", Font.PLAIN, 64));
		textinputpanel.add(title);
		
		maintextlabel.setBounds(350, 80, 200, 50);
		maintextlabel.setFont(new Font("Serif", Font.PLAIN, 24));
		textinputpanel.add(maintextlabel);
		
		hyperlinks.setBounds(350, 335, 200, 50);
		hyperlinks.setFont(new Font("Serif", Font.PLAIN, 24));
		textinputpanel.add(hyperlinks);
		
		main.setBounds(350, 125, 600, 150);
		textinputpanel.add(main);
		
		links.setBounds(350, 375, 600, 30);
		textinputpanel.add(links);
		
		linktext.setBounds(235,475,200,100);
		linktext.addActionListener(this);
		textinputpanel.add(linktext); 

		deletelink.setBounds(857,475,200,100);
		deletelink.addActionListener(this);
		textinputpanel.add(deletelink);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
