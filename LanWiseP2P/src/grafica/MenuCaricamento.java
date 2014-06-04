package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuCaricamento extends JMenu {

	private static final long serialVersionUID = 1L;

	public MenuCaricamento() {
		
		super("Caricamento File");
		JMenuItem carica=new JMenuItem("Carica");
		add(carica);
		
		carica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser chooser=new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.showOpenDialog(chooser);
				System.err.println(chooser.getSelectedFile().getName());

			}
		});
	}
	
	
}
