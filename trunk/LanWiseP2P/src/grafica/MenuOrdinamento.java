package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

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

	private ProxyOrdinamento proxyOrdinamento;

	private FiltraPerNomeFile nomeFile = new FiltraPerNomeFile();
	private FiltraPerNomeUtente nomeUtente = new FiltraPerNomeUtente();

	public MenuOrdinamento(final ProxyOrdinamento proxyOrdinamento) {
		super("Ordina Per");
		this.proxyOrdinamento = proxyOrdinamento;

		add(nameFi);
		add(nameUt);

		nameFi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				proxyOrdinamento.setFiltro(nomeFile);

			}
		});

		nameUt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				proxyOrdinamento.setFiltro(nomeUtente);

			}
		});

	}
}
