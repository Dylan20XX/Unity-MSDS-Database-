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
	JScrollPane projects = new JScrollPane();
	JLabel title = new JLabel("Create or Edit Projects");
	ArrayList<JButton> list = new ArrayList();
	ArrayList<JLabel> namelist = new ArrayList();

	int numproj = 0;
	JPanel scrollpanel = new JPanel();
	JPanel labelscrollpanel = new JPanel();

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
		projectlist.setBackground(Color.CYAN);
		file.add(SAVE);
		file.add(BACK);
		menu.add(file);
		
		title.setBounds(425, 0, 750, 100);
		title.setFont(new Font("Serif", Font.PLAIN, 48));
		//projectlist.add(title);
		
		create.setBounds(235,475,200,100);
		create.addActionListener(this);
		projectlist.add(create); 
		
		delete.setBounds(857,475,200,100);
		delete.addActionListener(this);
		projectlist.add(delete);
		
		scrollpanel.setBounds(0, 0, 750, 250);
//		labelscrollpanel.setBounds(350, 0, 350, 250);
//		scrollpanel.add(labelscrollpanel);

		projects = new JScrollPane(scrollpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpanel.setLayout(new BoxLayout(scrollpanel, BoxLayout.Y_AXIS));
		projects.setBounds(280,100,750,250);
		scrollpanel.setBackground(Color.black);
		projectlist.add(projects);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == create){
			list.add(new JButton());
			list.get(numproj).setSize(200, 100);
			list.get(numproj).setMaximumSize(list.get(numproj).getSize());
			list.get(numproj).setMinimumSize(list.get(numproj).getSize());
			list.get(numproj).setPreferredSize(list.get(numproj).getSize());
			list.get(numproj).setText("edit");
			scrollpanel.add(list.get(numproj));	
			
//			namelist.add(new JLabel());
//			namelist.get(numproj).setSize(200, 100);
//			namelist.get(numproj).setMaximumSize(namelist.get(numproj).getSize());
//			namelist.get(numproj).setMinimumSize(namelist.get(numproj).getSize());
//			namelist.get(numproj).setPreferredSize(namelist.get(numproj).getSize());
//			namelist.get(numproj).setText("edit");
//			labelscrollpanel.add(namelist.get(numproj));
			
			scrollpanel.revalidate();
			scrollpanel.repaint();
			
			numproj++;
		}
	}
}
