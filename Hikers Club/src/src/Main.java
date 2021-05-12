package src;

import java.awt.EventQueue;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import resources.SoundEffects;



public class Main {
	
	//public static SoundEffects sound = new SoundEffects();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 //Main sound = new Main("resources/Nature.wav");
		 //sound.Run("Nature.wav");
		 //SoundEffects.clip1.loop(Clip.LOOP_CONTINUOUSLY);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HikersClub Main = new HikersClub();
//					main.createAndShowGUI();
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
					
//					OrderMenu window = new OrderMenu();
//					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		});
	}
	
	    /*public Main(String filePath) throws InterruptedException {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Test Sound");
		f.setSize(300, 200);
		f.setVisible(false);

		try {
			// Open an audio input stream.
//          File soundFile = new File(pen); 
			URL resource = getClass().getClassLoader().getResource(filePath);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(resource);
			Clip clip = AudioSystem.getClip();

			clip.open(audioIn);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
}
