package modello;

import grafica.Menu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import ordinamento.ProxyOrdinamento;

public class PannelloCondivisione extends JFrame {

	private static final long serialVersionUID = 0;

	public PannelloCondivisione() {
		super();

		JMenuBar menubar = new JMenuBar();
		ProxyOrdinamento proxy = new ProxyOrdinamento(null);
		JPanel panel = new JPanel();
		
		Menu ordinamentoMenu = new Menu(proxy);
		menubar.add(ordinamentoMenu);
		JLabel lblWelcome = new JLabel("Benvenuto in LanWiseP2P: condividi qui il tuo codice per l'esame di FDI2!");
		panel.add(lblWelcome);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds((int) screenSize.getWidth() >> 2,
		(int) screenSize.getHeight() >> 3,
		(int) screenSize.getWidth() >> 1,
		(int) screenSize.getHeight() >> 1);

		add(panel);
		setJMenuBar(menubar);
		setTitle("LWP2P");
		setDefaultCloseOperation(PannelloCondivisione.EXIT_ON_CLOSE);
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
