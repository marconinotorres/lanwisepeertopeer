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
import ordinamento.ProxyOrdinamento;

/**
 * Andrebbe risistemata un p� meglio
 * @author Giuseppe Restivo
 *
 */
public class FrameCondivisione extends JFrame implements Observer{

	
	private static final long serialVersionUID = 1L;

	final Timer timer = new Timer(4000, null);
	
	private ProxyOrdinamento proxy;	
	private MultimediaList multimediaList;
	private MultimediaPanel panel2 = new MultimediaPanel();
	
	private IMultimediaContents contents;
	private IMultimediaSettings setting;
	private ProxyPlacer proxyPlacer;
	public FrameCondivisione(final ProxyOrdinamento proxy) {
		
		this.proxy = proxy;
		proxy.addObserver(this);
		
		JMenuBar menubar = new JMenuBar();
		JPanel panel = new JPanel();
		
		MenuOrdinamento ordinamentoMenu = new MenuOrdinamento(proxy);
		MenuCaricamento caricamentoMenu = new MenuCaricamento();
		
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

		
		proxyPlacer = new ProxyPlacer(MultimediaListController.getController().getvPlacer());
		setting = new MultimediaSettings();
		
		
		timer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				contents.getContentsList().clear();
				contents.getContentsList();
				panel2.repaint();
			}
		});
		
		
		MultimediaListController.getController().setContents(contents);
		
		multimediaList = new MultimediaList(contents, proxyPlacer, setting);
		MultimediaListController.getController().setMultimediaList(multimediaList);
	
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
