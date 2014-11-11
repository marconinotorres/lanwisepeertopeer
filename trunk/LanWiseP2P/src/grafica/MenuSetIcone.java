package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import modello.readIcone.LetturaFileIcone;
import modello.readIcone.TestLetturaIcone;

/**
 * Il menu per cambiare a run-time il set di icone
 * @author Giuseppe Restivo
 *
 */
public class MenuSetIcone extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem[] item;

	
	public MenuSetIcone() {
		super("setIcone");
		
		String[] setIcone = LetturaFileIcone.getLetturaIcone().setIcone();
		
		item = new JMenuItem[setIcone.length];
		for (int i = 0; i < setIcone.length; i++) {
			item[i] = new JMenuItem(setIcone[i]);
			add(item[i]);
			
			final String name = setIcone[i];
			item[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					LetturaFileIcone.getLetturaIcone().setSetIcone(new TestLetturaIcone("icone/"+name+"/fslook.txt"));
					LetturaFileIcone.getLetturaIcone().setPath("icone/"+name+"/");
				}
			});
		}
	}
	
	
}
