package src;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import resources.Images;
import resources.SoundEffects;

import java.awt.GridLayout;

import src.HikersClub;

public class Body extends JPanel{ // GUI class initiating most GUI including panels and frames.
	
	static ClimbingClub cc = new ClimbingClub();
	private Panel panel_1;
	private Panel panel_2;
	static JFrame frame;
	
	SoundEffects sound2 = new SoundEffects();
	Images image = new Images();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	void createAndShowGUI() throws IOException { // GUI creator running sequence.
		
		JFrame frmMainMenu = new JFrame("Main Menu");
		frmMainMenu.setAlwaysOnTop(true);
		frmMainMenu.setBounds(300, 300, 136, 283);
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.getContentPane().setForeground(new Color(0, 0, 0));
		frmMainMenu.getContentPane().setLayout(new GridLayout(6, 6, 10, 10));
		
		JLabel lblNewLabel = new JLabel("           Main Menu");
		lblNewLabel.setFont(new Font("Yu Mincho Light", Font.BOLD, 13));
		frmMainMenu.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Hiker");
		frmMainMenu.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String h2 = JOP.in("Please enter hiker name: ");
	        	
	        	String n2 = JOP.in("Please enter hiking location: ");
	            
	           String t2 = JOP.in("Please enter hike duration(hours):"); 
	           JOP.msg("Good Luck! Be aware, theres a chance you can run into a Koala!");
	           if(cc.addClimbTwo(h2, n2, t2).getFound()) {
	        	   ClimbInfo.kn++;
	        	   JOP.msg("...");
	        	   try {
					SoundPlusImage("poke.wav", "koko.jpg", "You've found a Koala!", "A Koala has been found");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	           }
			}});
		
		JButton btnNewButton_2 = new JButton("Show List");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cc.displayClimbList();
	        	String s = JOP.in("Would you like to remove a hiker from the list?");
	        	
	        	if(s.equalsIgnoreCase("yes")) {
	        		cc.removeClimbList();
	        		cc.displayClimbList();
			}
		}});
		
		frmMainMenu.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Locations Discovered");
		frmMainMenu.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOP.msg("Number of Locations Discovered: " + cc.modifiedDistinctPeakNames());
			}});
		
		JPanel panel = new JPanel();
		frmMainMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Koalas Found");
		btnNewButton_3.setBounds(0, 0, 157, 23);
		panel.add(btnNewButton_3);
		
		JButton button = new JButton("New button");
		button.setBounds(31, 0, 89, 23);
		panel.add(button);
		
		JButton btnNewButton_1 = new JButton("Exit");
		frmMainMenu.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOP.msg("Number of Koalas Discovered: " + ClimbInfo.kn);
				if(ClimbInfo.kn >= 3  ) {
					try {
						SoundPlusImage("tada.wav", "images.jfif", "Congrats! All hikers who discovered a Koala get a 50% discount in the gift shop!", "Congrats Hikers!");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
			}
			}});
		
        frmMainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try 
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           e.printStackTrace();
        }

        frmMainMenu.pack();
        frmMainMenu.setVisible(true);
        frmMainMenu.setResizable(true);
        
        
        
        
	}
	
	public void SoundPlusImage(String s, String x, String y, String z) throws Exception { // Sound effects along with images helper method.
        SoundEffects.clip1.stop();
        sound2.Run2(s);
        image.display(x, y, z);
        SoundEffects.clip2.stop();
        SoundEffects.clip1.start();
    }
}
