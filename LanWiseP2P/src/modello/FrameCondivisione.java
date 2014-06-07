package modello;

import grafica.MenuCaricamento;
import grafica.MenuOrdinamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import ordinamento.ProxyOrdinamento;
import multimedia.MultimediaList;
import multimedia.MultimediaPanel;
import multimedia.contents.MultimediaContents;
import multimedia.placers.ProxyPlacer;
import multimedia.settings.MultimediaSettings;
import multimedia.MultimediaListController;

/**
 * Andrebbe risistemata un p� meglio
 * @author Giuseppe Restivo
 *
 */
public class FrameCondivisione extends JFrame implements Observer{

	
	private static final long serialVersionUID = 1L;

	private ProxyOrdinamento proxy;	
	private MultimediaList multimediaList;
	private MultimediaPanel panel2 = new MultimediaPanel();
	
	public FrameCondivisione(final ProxyOrdinamento proxy) {
		
		this.proxy = proxy;
		proxy.addObserver(this);
		
		JMenuBar menubar = new JMenuBar();
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
		setDefaultCloseOperation(FrameCondivisione.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		ArrayList<FileHandler> multimedia = new ArrayList<FileHandler>();
		
		multimedia.add(new FileHandler("prova1", "Giuseppe Restivo"));
		multimedia.add(new FileHandler("prova2", "Marco Cortesi"));
		multimedia.add(new FileHandler("prova3", "Nicola Blago"));
		multimedia.add(new FileHandler("prova4", "Federico Bacci"));
		multimedia.add(new FileHandler("prova5", "Stefano Azzolina"));
		multimedia.add(new FileHandler("prova7", "Stefano Azzolina"));
		
		ProxyPlacer proxyPlacer = new ProxyPlacer(MultimediaListController.getController().getvPlacer());
		MultimediaSettings setting = new MultimediaSettings();
		MultimediaContents contents = new MultimediaContents();
		contents.addContents(multimedia);
		MultimediaListController.getController().setContents(contents);
		
		multimediaList = new MultimediaList(contents, proxyPlacer, setting);
		MultimediaListController.getController().setMultimediaList(multimediaList);
	
		
		panel2.setList(multimediaList);
		addKeyListener(MultimediaListController.getController());
		multimediaList.addObserver(panel2);
		add(panel2);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		proxy.filtraListaFile(multimediaList.getList());
		panel2.update(multimediaList, proxy);
		
	}
}
