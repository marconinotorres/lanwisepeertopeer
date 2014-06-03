package grafica;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Menu extends JMenuBar{
private static final long serialVersionUID = 0;

	public Menu() {
		super();
		
		
		JMenu mainmenu=new JMenu("Lista_File");
        JMenu submenu = new JMenu("Ordina");
        mainmenu.add(submenu);
        submenu.addSeparator();
        JMenuItem dimension = new JMenuItem("Per Dimensione");
        JMenuItem name = new JMenuItem("Per Nome");
        JMenuItem type = new JMenuItem("Per Tipo");
        add(mainmenu);
        submenu.add(dimension);
        submenu.add(name);
        submenu.add(type);
	
	}
}
