package grafica;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modello.CartelleUtente;
import grafica.FrameCondivisione;
import rete.BroadcastClient;

/**
 * Permette di selezionare all'avvio del programma la cartella dove si salvano i
 * file scaricati
 * 
 * @author Giuseppe Restivo
 * 
 */
public class FrameCartellaSalvataggio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JButton button = new JButton("Carica Cartella dove Salvare i file");

	public FrameCartellaSalvataggio() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Step2:");

		add(panel);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds((int) screenSize.getWidth() >> 2,
				(int) screenSize.getHeight() >> 3,
				(int) screenSize.getWidth() >> 2,
				(int) screenSize.getHeight() >> 3);

		panel.setLayout(new GridLayout(1, 1));
		panel.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showOpenDialog(chooser);

				CartelleUtente utente = CartelleUtente.getInstance();
				utente.setDownFolder(chooser.getSelectedFile()
						.getAbsolutePath());

				BroadcastClient c = new BroadcastClient();
				c.start();

				new FrameCondivisione();
				setVisible(false);

			}

		});

		setVisible(true);
	}
}
