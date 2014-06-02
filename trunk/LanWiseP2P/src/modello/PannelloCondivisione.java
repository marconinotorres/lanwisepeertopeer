package modello;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PannelloCondivisione extends JFrame {

	private static final long serialVersionUID = 0;

	public PannelloCondivisione() {
		super();

		JPanel panel = new JPanel();

		JLabel lblWelcome = new JLabel(
				"Benvenuto in LanWiseP2P: condividi qui il tuo codice per l'esame di FDI2!");
		panel.add(lblWelcome);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds((int) screenSize.getWidth() >> 2,
		(int) screenSize.getHeight() >> 3,
		(int) screenSize.getWidth() >> 2,
		(int) screenSize.getHeight() >> 2);

		add(panel);
		setTitle("LWP2P");
		setVisible(true);
		// setLayout(new GridLayout(3,1));
		// JLabel lblWelcome=new
		// JLabel("Benvenuto in LanWiseP2P: condividi qui il tuo codice per l'esame di FDI2!");
		// setSize(dimen);
		// // Dimension screenSize =
		// Toolkit.getDefaultToolkit().getScreenSize();
		// // setBounds((int) screenSize.getWidth() >> 2,
		// // (int) screenSize.getHeight() >> 3,
		// // (int) screenSize.getWidth() >> 2,
		// // (int) screenSize.getHeight() >> 2 );
		// //
		// add(lblWelcome);
		// setVisible(true);
	}
}
