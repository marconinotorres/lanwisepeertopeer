package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ordinamento.FiltraPerDimensioneFile;
import ordinamento.FiltraPerNomeFile;
import ordinamento.FiltraPerNomeUtente;
import ordinamento.ProxyOrdinamento;


/**
 * Menu che consente di scegliere una tipologia di ordinamento
 * @author Giuseppe Restivo
 *
 */
public class MenuOrdinamento extends JMenu{
	
	private static final long serialVersionUID = 0;

	private JMenuItem nameFi = new JMenuItem("NomeFile");
	private JMenuItem dimension = new JMenuItem("Dimensione");
    private JMenuItem nameUt = new JMenuItem("NomeUtente");
    
	
    private ProxyOrdinamento proxyOrdinamento;
    
    private FiltraPerNomeFile nomeFile = new FiltraPerNomeFile();
    private FiltraPerDimensioneFile dim = new FiltraPerDimensioneFile();
    private FiltraPerNomeUtente nomeUtente = new FiltraPerNomeUtente();
    
    
    
	public MenuOrdinamento(final ProxyOrdinamento proxyOrdinamento) {
		super("Ordina Per");
		this.proxyOrdinamento = proxyOrdinamento;
  
  		add(nameFi);
        add(dimension);
        add(nameUt);
        
        nameFi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				proxyOrdinamento.setFiltro(nomeFile);
				
			}
		});
        
        dimension.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				proxyOrdinamento.setFiltro(dim);
				
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
