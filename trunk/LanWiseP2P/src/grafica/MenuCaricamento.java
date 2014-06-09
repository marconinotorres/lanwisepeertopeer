package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import reti.BroadcastClient;
import reti.BroadcastServer;
import reti.Utente;

public class MenuCaricamento extends JMenu {

	private static final long serialVersionUID = 1L;

	public MenuCaricamento() {
		
		super("Cambia Cartella");
		JMenuItem upFolder=new JMenuItem("Cartella da Condividere");
		JMenuItem downFolder=new JMenuItem("Cartella dei Salvataggi");

		add(upFolder);
		add(downFolder);
		
		upFolder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser chooser=new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showOpenDialog(chooser);

				Utente utente = Utente.getInstance();
				utente.setUpFolder(chooser.getSelectedFile().getAbsolutePath());
				System.out.println(utente.getUpFolder());
				try {
					BroadcastServer s = new BroadcastServer(new File(utente.getUpFolder()));
					s.start();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		
		downFolder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser chooser=new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showOpenDialog(chooser);
//				System.err.println(chooser.getSelectedFile().getName());
				Utente utente = Utente.getInstance();
				utente.setDownFolder(chooser.getSelectedFile().getAbsolutePath());
				BroadcastClient c = new BroadcastClient();
				c.start();

			}
		});
	}
	
	
}
