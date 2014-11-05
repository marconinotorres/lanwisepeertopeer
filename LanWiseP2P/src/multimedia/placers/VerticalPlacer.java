package multimedia.placers;

import java.awt.Graphics;

import multimedia.IPlacer;

/**
 * @author Giuseppe Restivo
 */

public class VerticalPlacer implements IPlacer {

	private static int X_FOCUS = 50;
	private static int Y_FOCUS = 200;

	private static int DISTANZA_CONTENUTI_VERTICALE = 40;

	public void place(Graphics graphics, int slot, String content) {
		graphics.drawString(content, X_FOCUS, Y_FOCUS + slot
				* DISTANZA_CONTENUTI_VERTICALE);
	}
}
