package src;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import src.Body;

public class HikersClub extends JPanel { // Class consisting of panel creation and a few helper methods.

	static ClimbingClub cc = new ClimbingClub();
	/**
	 * Create the panel.
	 */
	JLabel picLabel, title;
	JButton button;
	private Panel panel_1;
	private Panel panel_2;
	static JFrame frame;
	
	public HikersClub() throws IOException { 
		frame = new JFrame();
		JPanel panel = new JPanel(new BorderLayout());
		
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("/resources/HE.png"));
		JLabel label = new JLabel(imgIcon);
		label.setBounds(63, 71, 321, 176); // You can use your own values
		
		frame.getContentPane().add(label);
		
		picLabel = new JLabel(imgIcon);
		Box right = Box.createVerticalBox();
		panel_1 = new Panel();
		title = new JLabel("Koala National Preserve");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(0.0f);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Yu Mincho Light", Font.PLAIN, 50));
		title.setForeground(Color.BLACK);
		
		button = new JButton("Continue");
		panel_1.add(button);
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(picLabel, BorderLayout.CENTER);
		panel.add(right, BorderLayout.SOUTH);
		right.add(title);
		right.add(panel_1);
		add(panel);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Body f;
				try {
					f = new Body();
					f.createAndShowGUI();
					f.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
}
