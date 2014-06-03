package tests;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import modello.PannelloAccesso;



public class Main {
	
	public static JFrame frame;
	
	public static JFrame getFrame() {
		return frame;
	}
	public static void main(String[] args) {
		
		Main.frame=new JFrame("LWP2P");
		PannelloAccesso p=new PannelloAccesso();
		frame.getContentPane().add(p);
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int) screenSize.getWidth() >>3,
				(int) screenSize.getHeight() >> 3,
				(int) screenSize.getWidth() >> 3,
				(int) screenSize.getHeight() >> 2 );
		frame.setVisible(true);
		
	}

}
