package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import modello.LetturaIcone;
import modello.dataio.StringLinesReader;
import modello.readIcone.TestLetturaIcone;

/**
 * Il menu per cambiare a run-time il set di icone
 * 
 * @author Giuseppe Restivo
 * 
 */
public class MenuSetIcone extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem[] item;

	public MenuSetIcone() {
		super("setIcone");

		String[] nameDirectoryIcone = LetturaIcone.getLetturaIcone()
				.readDirectoryIcone();

		item = new JMenuItem[nameDirectoryIcone.length];

		for (int i = 0; i < nameDirectoryIcone.length; i++) {

			item[i] = new JMenuItem(nameDirectoryIcone[i]);
			add(item[i]);

			final String name = nameDirectoryIcone[i];

			item[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String path = "icone/" + name + "/";

					LetturaIcone.getLetturaIcone().setNomeDirectory(path);
					(new StringLinesReader(new TestLetturaIcone()))
							.readFile(path + "fslook.txt");

				}
			});
		}
	}

}
