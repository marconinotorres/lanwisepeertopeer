package multimediaList;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class MultimediaPanel extends JPanel implements IUpdate{

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
	public void update() {
		repaint();
	}
}
