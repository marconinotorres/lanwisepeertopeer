package modello;

import grafica.MenuCaricamento;
import grafica.MenuOrdinamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import multimediaList.IMultimediaSettings;
import multimediaList.MultimediaContents;
import multimediaList.MultimediaList;
import multimediaList.MultimediaListener;
import multimediaList.MultimediaPanel;
import multimediaList.MultimediaSetting;
import multimediaList.Placer;
import ordinamento.ProxyOrdinamento;

public class PannelloCondivisione extends JFrame implements Observer{

	private static final long serialVersionUID = 0;
	
	private ProxyOrdinamento proxy;
	private MultimediaList list = new MultimediaList();
		
	public PannelloCondivisione(final ProxyOrdinamento proxyOrdinamento) {
		
		super();
		this.proxy = proxyOrdinamento;
		proxy.addObserver(this);
		JMenuBar menubar = new JMenuBar();
		ProxyOrdinamento proxy = new ProxyOrdinamento(null);
		JPanel panel = new JPanel();
		
		MenuOrdinamento ordinamentoMenu = new MenuOrdinamento(proxy);
		MenuCaricamento caricamentoMenu = new MenuCaricamento();
		
		menubar.add(ordinamentoMenu);
		menubar.add(caricamentoMenu);
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
		
		
		MultimediaContents contents = new MultimediaContents();
		contents.add(new FileHandler("prova1", 100, "Giuseppe Restivo"));
		contents.add(new FileHandler("prova2", 200, "Marco Cortesi"));
		contents.add(new FileHandler("prova3", 50, "Nicola Blago"));
		contents.add(new FileHandler("prova4", 50, "Federico Bacci"));
		contents.add(new FileHandler("prova5", 100, "Stefano Azzolina"));
		list.setList(contents);
		
		
		MultimediaPanel panel2 = new MultimediaPanel();
		list.setPanel(panel2);
		panel2.setList(list);
		
		MultimediaListener listener = new MultimediaListener(list);
		panel.addKeyListener(listener);
		
		IMultimediaSettings setting = new MultimediaSetting();
		list.setSetting(setting);
		Placer placer = new Placer();
		list.setPlacer(placer);
		listener.setPlacer(placer);
		add(panel2);
		addKeyListener(listener);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		
		
	}
}
