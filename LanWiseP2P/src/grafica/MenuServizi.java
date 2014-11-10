package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import modello.Servizio;
import modello.service.AggiungiFileDaCondividere;
import modello.service.ProxyServizio;
import modello.service.RimuoviFileCondiviso;

/**
 * Menu grafico dove � possibile scegliere un servizio, ad esempio
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
	private Servizio rem = new RimuoviFileCondiviso();

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
