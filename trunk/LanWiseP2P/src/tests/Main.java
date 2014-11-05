package tests;

import grafica.PannelloAccesso;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import modello.Utente;
import modello.letturaListaUtenti.TestReadUtenti;
import modello.letturaListaUtenti.UtenteReader;
import modello.writeUtenti.TestWriteConnessione;
import modello.writeUtenti.UtenteWriter;

public class Main {
	
	public static JFrame frame;
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static void main(String[] args) {
		
		
		Main.frame=new JFrame("LWP2P");
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		UtenteReader.setUtente(new TestReadUtenti());
		UtenteWriter.setUtente(new TestWriteConnessione());
		
		PannelloAccesso p=new PannelloAccesso();
		
		frame.getContentPane().add(p);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int) screenSize.getWidth() >>3,
				(int) screenSize.getHeight() >> 3,
				(int) screenSize.getWidth() >> 3,
				(int) screenSize.getHeight() >> 2 );
		
		frame.setVisible(true);
		
	}

}
