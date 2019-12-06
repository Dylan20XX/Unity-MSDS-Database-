
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
//import javax.swing.event.*;


@SuppressWarnings("serial")
public class Report extends JPanel {
    private JTextArea textbox1;
    private JTextArea textbox2;
    private JMenuBar menubar;
    private JLabel material1;
    private JLabel rating1;
    private JLabel image1;
    private JLabel material2;
    private JLabel rating2;
    private JLabel image2;
    private JLabel material3;
    private JLabel rating3;
    private JLabel image3;
    private JLabel material4;
    private JLabel rating4;
    private JLabel image4;
    private JLabel material5;
    private JLabel rating5;
    private JLabel image5;
    private JLabel title;
    private JLabel cbox1;
    private JLabel cbox2;
    private JLabel cbox3;
    private JLabel cbox4;
    private JLabel cbox5;

    public Report() {
        //construct preComponents
        JMenu fileMenu = new JMenu ("File");
        JMenuItem file_option_1Item = new JMenuItem ("File Option 1");
        fileMenu.add (file_option_1Item);
        JMenuItem file_option_2Item = new JMenuItem ("File Option 2");
        fileMenu.add (file_option_2Item);
        JMenu editMenu = new JMenu ("Edit");
        JMenuItem project_1Item = new JMenuItem ("Project 1");
        editMenu.add (project_1Item);
        JMenuItem project_2Item = new JMenuItem ("Project 2");
        editMenu.add (project_2Item);
        JMenu exitMenu = new JMenu ("Exit");
        JMenuItem exit_programItem = new JMenuItem ("Exit Program");
        exitMenu.add (exit_programItem);
        
        JMenuItem exit___saveItem = new JMenuItem ("Exit & Save");
        exitMenu.add (exit___saveItem);

        //construct components
        textbox1 = new JTextArea (5, 5);
        textbox2 = new JTextArea (5, 5);
        menubar = new JMenuBar();
        menubar.add (fileMenu);
        menubar.add (editMenu);
        menubar.add (exitMenu);
        material1 = new JLabel ("Material");
        
        rating1 = new JLabel ("Rating");
        image1 = new JLabel ("Image");
        material2 = new JLabel ("Material");
        rating2 = new JLabel ("Rating");
        image2 = new JLabel ("Image");
        material3 = new JLabel ("Material");
        rating3 = new JLabel ("Rating");
        image3 = new JLabel ("Image");
        material4 = new JLabel ("Material");
        rating4 = new JLabel ("Rating");
        image4 = new JLabel ("Image");
        material5 = new JLabel ("Material");
        rating5 = new JLabel ("Rating");
        image5 = new JLabel ("Image");
        title = new JLabel ("UNITY PROJECT");
        title.setFont((new Font( "Serif", Font.PLAIN, 60)));
		title.setForeground(Color.BLACK);

        cbox1 = new JLabel ();
        cbox2 = new JLabel ();
        cbox3 = new JLabel ();
        cbox4 = new JLabel ();
        cbox5 = new JLabel ();

        //adjust size and set layout
        setPreferredSize (new Dimension (1277, 647));
        setLayout (null);
        setBackground(Color.CYAN);
        
        /*this.getRootPane().setLayout(new FlowLayout());
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        material1.setBorder(border);*/
        
        //add components
        add (textbox1);
        add (textbox2);
        add (menubar);
        add (material1);
        add (rating1);
        add (image1);
        add (material2);
        add (rating2);
        add (image2);
        add (material3);
        add (rating3);
        add (image3);
        add (material4);
        add (rating4);
        add (image4);
        add (material5);
        add (rating5);
        add (image5);
        add (title);
        add (cbox1);
        add (cbox2);
        add (cbox3);
        add (cbox4);
        add (cbox5);

        //set component bounds (only needed by Absolute Positioning)
        textbox1.setBounds (35, 135, 400, 350);
        textbox2.setBounds (35, 510, 400, 105);
        menubar.setBounds (0, 0, 1280, 25);
        material1.setBounds (515, 170, 125, 50);
        rating1.setBounds (730, 170, 125, 50);
        image1.setBounds (945, 170, 125, 50);
        material2.setBounds (515, 245, 125, 50);
        rating2.setBounds (730, 245, 125, 50);
        image2.setBounds (945, 245, 125, 50);
        material3.setBounds (515, 340, 125, 50);
        rating3.setBounds (730, 340, 125, 50);
        image3.setBounds (945, 340, 125, 50);
        material4.setBounds (515, 420, 125, 50);
        rating4.setBounds (730, 420, 125, 50);
        image4.setBounds (945, 420, 125, 50);
        material5.setBounds (515, 490, 125, 50);
        rating5.setBounds (730, 490, 125, 50);
        image5.setBounds (945, 490, 125, 50);
        title.setBounds (400, 25, 480, 95);
        cbox1.setBounds (1145, 170, 50, 50);
        cbox1.setBackground(Color.GREEN);
        cbox1.setOpaque(true);
        cbox2.setBounds (1145, 245, 50, 50);
        cbox2.setBackground(Color.YELLOW);
        cbox2.setOpaque(true);
        cbox3.setBounds (1145, 340, 50, 50);
        cbox3.setBackground(Color.GREEN);
        cbox3.setOpaque(true);
        cbox4.setBounds (1145, 420, 50, 50);
        cbox4.setBackground(Color.RED);
        cbox4.setOpaque(true);
        cbox5.setBounds (1145, 490, 50, 50);
        cbox5.setBackground(Color.GREEN);
        cbox5.setOpaque(true);
        
        
        
        
        
        
       
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("REPORT SCREEN");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Report());
        frame.pack();
        frame.setBackground(Color.CYAN);
        frame.setVisible (true);
       
        
        
        
 
    }
}
