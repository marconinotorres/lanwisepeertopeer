package multimedia;

import java.awt.Graphics;

/**
 * Questo modulo si occupa di gestire i Setting da applicare alla lista dei
 * file. Dato un {@link Graphics} è possibile cambiarne la rappresentazione
 * 
 * @author Giuseppe Restivo
 */
public interface IMultimediaSettings {
	
	/**
	 * Applica i setting
	 * 
	 * @param graphics
	 *            , il graphics a cui si vuole modificare il setting
	 * @param slot
	 *            , lo slot che identifica il graphics da usare
	 */
	public void applySlotSettings(Graphics graphics, int slot);
}
