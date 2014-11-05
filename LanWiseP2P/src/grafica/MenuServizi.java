package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import modello.AggiungiFileDaCondividere;
import modello.CartelleUtente;
import modello.ProxyServizio;
import modello.RimuoviFileDaCondividere;
import modello.Servizio;
import reti.BroadcastClient;
import reti.BroadcastServer;

/**
 * Menu grafico dove è possibile scegliere un servizio, come ad esempio
 * aggiungere un nuovo file alla cartella condivisa o rimuoverla
 * 
 * @author giusepperestivo
 * 
 */
public class MenuServizi extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem addFile = new JMenuItem("Aggiungi file");
	private JMenuItem removeFile = new JMenuItem("Rimuovi file");

	private ProxyServizio servizio = new ProxyServizio(null);
	private Servizio add = new AggiungiFileDaCondividere();
	private Servizio rem = new RimuoviFileDaCondividere();

	public MenuServizi() {
		super("Menu");

		add(addFile);
		add(removeFile);

		addFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				servizio.setService(add);
				servizio.service();
			}
		});

		removeFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				servizio.setService(rem);
				servizio.service();

			}
		});
	}

}
