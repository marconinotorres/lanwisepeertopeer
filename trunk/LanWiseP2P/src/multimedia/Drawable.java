package multimedia;

import java.awt.Graphics;

/**
 * Disegna un disegnabile
 * 
 * @author Giuseppe Restivo
 *
 */
public interface Drawable {

	/**
	 * Disegna questo graphics
	 * @param graphics
	 */
	public abstract void draw(Graphics g);

}