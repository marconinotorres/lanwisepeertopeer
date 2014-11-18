package grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import application.Main;
import modello.ListaUtenti;
import modello.dataio.StringLinesWriter;
import modello.letturaListaUtenti.TestWriteChangeConnessione;
import multimedia.IMultimediaContents;
import multimedia.IMultimediaSettings;
import multimedia.MultimediaList;
import multimedia.MultimediaListController;
import multimedia.MultimediaPanel;
import multimedia.contents.MultimediaContents;
import multimedia.placers.ProxyPlacer;
import multimedia.settings.MultimediaSettings;
import ordinamento.ProxyOrdinamento;
import rete.INomePort;
import rete.ListSignal;

/**
 * Frame principale, viene visualizzata la lista di tutti i file disponibili
 * 
 * @author Giuseppe Restivo
 * 
 */
public class FrameCondivisione extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Timer timer = new Timer(2000, null);

	private MultimediaList multimediaList;
	private MultimediaPanel panel2 = new MultimediaPanel();

	private IMultimediaContents contents = new MultimediaContents();
	private IMultimediaSettings setting;
	private ProxyPlacer proxyPlacer;
	private ProxyOrdinamento proxyOrdinamento;

	private JMenuBar menubar = new JMenuBar();
	private MenuOrdinamento ordinamentoMenu = new MenuOrdinamento();
	private MenuServizi serviziMenu = new MenuServizi();
	private MenuSetIcone setIcone = new MenuSetIcone();

	private JMenu menuExit = new JMenu("Esci");
	private JMenuItem exit = new JMenuItem("Esci");
	
	
	public FrameCondivisione() {

		parteGrafica();

		proxyPlacer = new ProxyPlacer(MultimediaListController.getController()
				.getvPlacer());

		setting = new MultimediaSettings();
		proxyOrdinamento = new ProxyOrdinamento(ordinamentoMenu.getNomeUtente());

		MultimediaListController.getController().setContents(contents);

		multimediaList = new MultimediaList(contents, proxyPlacer, setting,
				proxyOrdinamento);
		ordinamentoMenu.setMultimedia(multimediaList);

		MultimediaListController.getController().setMultimediaList(
				multimediaList);

		timer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ListSignal signal = ListSignal.getInstance();
				while (signal.hasDataToProcess()) {
				}
				contents.readContentsFile();
				panel2.repaint();
			}
		});
		timer.start();

		panel2.setList(multimediaList);
		addKeyListener(MultimediaListController.getController());
		multimediaList.addObserver(panel2);

		setVisible(true);
	}

	private void parteGrafica() {

		menubar.add(serviziMenu);
		menubar.add(ordinamentoMenu);
		menubar.add(setIcone);
		menubar.add(menuExit);
		menuExit.add(exit);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ListaUtenti.getUtenti().getUtenteSelected().setConnesso(false);
				(new StringLinesWriter(new TestWriteChangeConnessione())).write("data/listaUtenti.txt");
				System.exit(0);
			}
		});
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds((int) screenSize.getWidth() >> 2,
				(int) screenSize.getHeight() >> 3,
				(int) screenSize.getWidth() << 2,
				(int) screenSize.getHeight() << 1);


		setJMenuBar(menubar);
		setBackground(Color.gray);
		setTitle("LWP2P");
		add(panel2);

	}

}
