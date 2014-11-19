package application;

import grafica.PannelloAccesso;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import modello.LetturaIcone;
import modello.dataio.StringLinesReader;
import modello.letturaListaUtenti.TestWriteChangeConnessione;
import modello.letturaListaUtenti.TestReadUtenti;
import modello.readIcone.TestLetturaIcone;

public class Main {

	public static JFrame frame;

	public static JFrame getFrame() {
		return frame;
	}

	public static void main(String[] args) {

		Main.frame = new JFrame("LWP2P");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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

		(new StringLinesReader(new TestReadUtenti()))
				.readFile("data/listaUtenti.txt");

		LetturaIcone.getLetturaIcone().setNomeDirectory("icone/iconspurple/");
		(new StringLinesReader(new TestLetturaIcone()))
				.readFile("icone/iconspurple/fslook.txt");

		PannelloAccesso p = new PannelloAccesso();

		frame.getContentPane().add(p);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int) screenSize.getWidth() >> 3,
				(int) screenSize.getHeight() >> 3,
				(int) screenSize.getWidth() >> 3,
				(int) screenSize.getHeight() >> 2);

		frame.setVisible(true);

	}

}
