package multimedia.settings;

import java.awt.Color;
import java.awt.Graphics;

import multimedia.IMultimediaSettings;

/**
 * 
 * @author Giuseppe Restivo
 *
 */
public class MultimediaSettings implements IMultimediaSettings{

	private Color focusColor=Color.RED;
	private Color nonFocusColor=Color.BLACK;
	
	public MultimediaSettings() {
		super();
	}
	
	public MultimediaSettings(Color focusColor, Color nonFocusColor) {
		super();
		this.focusColor = focusColor;
		this.nonFocusColor = nonFocusColor;
	}

	@Override
	public void applySlotSettings(Graphics graphics, int slot) {
		if(slot==0){
			graphics.setColor(focusColor);
		}else{
			graphics.setColor(nonFocusColor);
		}
	}

	public Color getFocusColor() {
		return focusColor;
	}

	public void setFocusColor(Color focusColor) {
		this.focusColor = focusColor;
	}

	public Color getNonFocusColor() {
		return nonFocusColor;
	}

	public void setNonFocusColor(Color nonFocusColor) {
		this.nonFocusColor = nonFocusColor;
	}
	
}
