package src;

import javax.swing.JOptionPane;

public class JOP { // Jop class in charge of all user imput and pop up messages. 

	public static void msg(String msg) { // Message pop up only method.
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static String in(String msg) { // Message along with user input method.
		return JOptionPane.showInputDialog(msg);
	}
}
