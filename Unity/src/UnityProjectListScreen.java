import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class UnityProjectListScreen extends JFrame implements ActionListener{
		
	JPanel projectlist = new JPanel();
	JMenuBar menu = new JMenuBar();
	JMenu file = new JMenu("file");
	JMenuItem SAVE = new JMenuItem("SAVE");
	JMenuItem BACK = new JMenuItem("BACK");
	JButton create = new JButton("CREATE NEW PROJECT");
	JButton delete = new JButton("Delete");
	ArrayList<JButton> edit = new ArrayList();
	public UnityProjectListScreen(){
			PanelSetup();
			frameSetup(); 
	}

	private void frameSetup() {
		setSize(1280,720);
		setLayout(null);
		add(projectlist);
		setVisible(true);
		getContentPane().setBackground(Color.blue);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PROJECT LIST");
		setJMenuBar(menu);
	}

	private void PanelSetup() {
		projectlist.setBounds(0, 0, 1270, 710);
		projectlist.setLayout(null);
		file.add(SAVE);
		file.add(BACK);
		menu.add(file);
		
		create.setBounds(235,475,200,100);
		create.addActionListener(this);
		projectlist.add(create); 
		
		delete.setBounds(857,475,200,100);
		delete.addActionListener(this);
		projectlist.add(delete);
		
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			
			}
		});
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
