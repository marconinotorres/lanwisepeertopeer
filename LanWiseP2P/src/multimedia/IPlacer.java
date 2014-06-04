package multimedia;

import java.awt.Graphics;


/**
 * Un IPlacer pu˜ disegnare un content {@link String} in un {@link Graphics}
 * Ci sono differenti slots dove una stringa si pu˜ posizionare
 * 
 * @author Giuseppe Restivo
 */
public interface IPlacer {

	/**
	 * Posiziona una stringa, disegnandola su un Graphics
	 * 
	 * @param graphics, il graphics dove la stringa si vuole posizionare
	 * @param slot
	 * @param content, il content da posizionare
	 */
	public void place(Graphics graphics, int slot, String content);
}