package multimediaList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MultimediaSetting implements IMultimediaSettings {

	private Font font;
	
	/* (non-Javadoc)
	 * @see multimediaList.IMultimediaSettings#setting(java.awt.Graphics, int, int)
	 */
	@Override
	public void setting(Graphics g,int i,int index){
		if(i == index){
			g.setColor(Color.red);
			g.setFont(new Font("Helvetica", Font.BOLD, 16));
		}else{
			g.setColor(Color.black);
			g.setFont(new Font("Times New Roman",Font.ITALIC,14));
		}
	}
}
