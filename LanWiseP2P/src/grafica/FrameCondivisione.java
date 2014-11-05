package grafica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

import modello.CartelleUtente;
import multimedia.IMultimediaContents;
import multimedia.IMultimediaSettings;
import multimedia.MultimediaList;
import multimedia.MultimediaListController;
import multimedia.MultimediaPanel;
import multimedia.contents.MultimediaContents;
import multimedia.placers.ProxyPlacer;
import multimedia.settings.MultimediaSettings;
import ordinamento.FiltraPerNomeFile;
import ordinamento.ProxyOrdinamento;
import reti.BroadcastClient;
import reti.BroadcastServer;
import reti.ListSignal;

/**
 * Frame principale, viene visualizzata la lista di tutti i file disponibili
 * 
 * @author Giuseppe Restivo
 * 
 */
public class FrameCondivisione extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	private final Timer timer = new Timer(4000, null);

	private ProxyOrdinamento proxy = new ProxyOrdinamento(
			new FiltraPerNomeFile());
	
	private MultimediaList multimediaList;
	private MultimediaPanel panel2 = new MultimediaPanel();

	private IMultimediaContents contents;
	private IMultimediaSettings setting;
	private ProxyPlacer proxyPlacer;

	public FrameCondivisione() {

		proxy.addObserver(this);

		JMenuBar menubar = new JMenuBar();
		JPanel panel = new JPanel();

		MenuOrdinamento ordinamentoMenu = new MenuOrdinamento(proxy);
		MenuServizi caricamentoMenu = new MenuServizi();

		menubar.add(caricamentoMenu);
		menubar.add(ordinamentoMenu);

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

		contents = new MultimediaContents();

		contents.addContents("OtherFilesList.txt");
		proxyPlacer = new ProxyPlacer(MultimediaListController.getController()
				.getvPlacer());
		setting = new MultimediaSettings();

		MultimediaListController.getController().setContents(contents);

		multimediaList = new MultimediaList(contents, proxyPlacer, setting);
		MultimediaListController.getController().setMultimediaList(
				multimediaList);


		timer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ListSignal signal = ListSignal.getInstance();
				while(signal.hasDataToProcess()){
				}
				contents.getContentsList().clear();
				contents.addContents("OtherFilesList.txt");
				multimediaList.addLista(contents, proxyPlacer, setting);
				proxy.filtraListaFile(multimediaList.getList());
				panel2.repaint();

			}
		});
		timer.start();

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
