
/**
 * Skyline Driver - Creates a Frame with the Title "Skyline" and sets the Content to the Skyline Panel.
 * 
 * @author (Mohamed) 
 * @version (Jan. 2017)
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SkylineDriver implements ActionListener
{
	Timer timer;
	static JFrame frame;
	
	public void setUP() {
		timer = new Timer(1000/30, this);
		frame = new JFrame("Skyline");
		timer.start();
	}
	
    public static void main(String[] args) {
    	SkylineDriver sd = new SkylineDriver();
    	sd.setUP();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SkylinePanel());
        // frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("DRAWING"); For debugging
		frame.repaint();
	}
}
