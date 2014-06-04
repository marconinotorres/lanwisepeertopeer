package multimedia;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


/**
 * Pannello nel quale verranno disegnati i vari graphics
 * @author giusepperestivo
 *
 */
public class MultimediaPanel extends JPanel implements Observer{

	private static final long serialVersionUID = 0;
	
	private Drawable list;
		
		
	public void setList(Drawable list) {
		this.list = list;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		list.draw(g);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
		
	}
	
}
