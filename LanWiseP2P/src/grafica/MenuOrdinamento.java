package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import multimedia.IOrdinamento;
import multimedia.MultimediaList;
import ordinamento.FiltraPerDimensioneFile;
import ordinamento.FiltraPerNomeFile;
import ordinamento.FiltraPerNomeUtente;
import ordinamento.ProxyOrdinamento;

/**
 * Menu che consente di scegliere una tipologia di ordinamento
 * 
 * @author Giuseppe Restivo
 * 
 */
public class MenuOrdinamento extends JMenu {

	private static final long serialVersionUID = 0;

	private JMenuItem nameFi = new JMenuItem("NomeFile");
	private JMenuItem nameUt = new JMenuItem("NomeUtente");
	private JMenuItem dimensione = new JMenuItem("Dimensione");

	private MultimediaList multimedia;

	private IOrdinamento nomeFile = new FiltraPerNomeFile();
	private IOrdinamento nomeUtente = new FiltraPerNomeUtente();
	private IOrdinamento dim = new FiltraPerDimensioneFile();

	public MenuOrdinamento() {
		super("Ordina Per");

		add(nameFi);
		add(dimensione);
		add(nameUt);

		nameFi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				((ProxyOrdinamento) multimedia.getOrdinamento())
						.setFiltro(nomeFile);
			}
		});

		nameUt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				((ProxyOrdinamento) multimedia.getOrdinamento())
						.setFiltro(nomeUtente);
			}
		});

		dimensione.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((ProxyOrdinamento) multimedia.getOrdinamento()).setFiltro(dim);

			}
		});
	}

	public void setMultimedia(MultimediaList multimedia) {
		this.multimedia = multimedia;
	}

	public IOrdinamento getNomeFile() {
		return nomeFile;
	}

	public IOrdinamento getNomeUtente() {
		return nomeUtente;
	}
}
