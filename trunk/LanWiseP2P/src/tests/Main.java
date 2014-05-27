package tests;

import java.awt.Dimension;
import java.awt.Toolkit;
import grafica.Pannello;
import javax.swing.JFrame;



public class Main {
	public static void main(String[] args) {
		
		JFrame frame=new JFrame("LWP2P");
		Pannello p=new Pannello();
		frame.getContentPane().add(p);
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int) screenSize.getWidth() >>3,
				(int) screenSize.getHeight() >> 3,
				(int) screenSize.getWidth() >> 3,
				(int) screenSize.getHeight() >> 2 );
		frame.setVisible(true);
		
	}

}
