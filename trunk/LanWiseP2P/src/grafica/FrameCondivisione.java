package grafica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

import multimedia.IMultimediaContents;
import multimedia.IMultimediaSettings;
import multimedia.MultimediaList;
import multimedia.MultimediaListController;
import multimedia.MultimediaPanel;
import multimedia.contents.MultimediaContents;
import multimedia.placers.ProxyPlacer;
import multimedia.settings.MultimediaSettings;
import ordinamento.FiltraPerNomeFile;
import ordinamento.FiltraPerNomeUtente;
import ordinamento.ProxyOrdinamento;
import rete.ListSignal;

/**
 * Frame principale, viene visualizzata la lista di tutti i file disponibili
 * 
 * @author Giuseppe Restivo
 * 
 */
public class FrameCondivisione extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Timer timer = new Timer(1000,null);

	private MultimediaList multimediaList;
	private MultimediaPanel panel2 = new MultimediaPanel();

	private IMultimediaContents contents = new MultimediaContents();
	private IMultimediaSettings setting;
	private ProxyPlacer proxyPlacer;
	private ProxyOrdinamento proxyOrdinamento;

	public FrameCondivisione() {
		
		JMenuBar menubar = new JMenuBar();
		JPanel panel = new JPanel();

		
		MenuOrdinamento ordinamentoMenu = new MenuOrdinamento();
		MenuServizi serviziMenu = new MenuServizi();
		
		menubar.add(serviziMenu);
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
		
		
		proxyPlacer = new ProxyPlacer(MultimediaListController.getController()
				.getvPlacer());
		
		setting = new MultimediaSettings();
		proxyOrdinamento = new ProxyOrdinamento(ordinamentoMenu.getNomeUtente());
		
		
		MultimediaListController.getController().setContents(contents);

		multimediaList = new MultimediaList(contents, proxyPlacer, setting, proxyOrdinamento);
		ordinamentoMenu.setMultimedia(multimediaList);
		
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
				
				panel2.repaint();
			}
		});
		timer.start();

		panel2.setList(multimediaList);
		addKeyListener(MultimediaListController.getController());
		multimediaList.addObserver(panel2);
		add(panel2);
		
	}	

}
