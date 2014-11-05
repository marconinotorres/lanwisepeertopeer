package grafica;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import rete.BroadcastServer;
import modello.CartelleUtente;

/**
 * Permette di selezionare la cartella da condividere
 * 
 * @author Giuseppe Restivo
 * 
 */
public class FrameCartellaCondivisione extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JButton button = new JButton("Carica Cartella da Condividere");

	public FrameCartellaCondivisione() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Step1:");
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
				utente.setUpFolder(chooser.getSelectedFile().getAbsolutePath());
				try {
					BroadcastServer s = new BroadcastServer(new File(utente
							.getUpFolder()));
					s.start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				new FrameCartellaSalvataggio();
				setVisible(false);

			}

		});
		setVisible(true);
	}
}
