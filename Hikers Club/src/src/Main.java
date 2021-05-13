package src;

import java.awt.EventQueue;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import resources.SoundEffects;



public class Main { // Main booter method to initiate program.
	
	public static SoundEffects sound = new SoundEffects();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception { // Static method that runs the program.
		// TODO Auto-generated method stub
		 Main sound = new Main("resources/Nature.wav");
		 sound.Run("Nature.wav");
		 SoundEffects.clip1.loop(Clip.LOOP_CONTINUOUSLY);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HikersClub Main = new HikersClub();
					final JFrame frame = new JFrame();
					frame.setTitle("Welcome to Koala National Preserve!");
					frame.getContentPane().add(Main);					
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					frame.addWindowListener(new java.awt.event.WindowAdapter() {
					    @Override
					    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					        if (JOptionPane.showConfirmDialog(frame, 
					            "Are you sure you want to close this window?", "Close Window?", 
					            JOptionPane.YES_NO_OPTION,
					            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					            System.exit(0);
					        }
					    }
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		});
	}
}
