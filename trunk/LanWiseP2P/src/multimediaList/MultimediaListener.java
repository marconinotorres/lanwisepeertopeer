package multimediaList;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MultimediaListener implements KeyListener {

	private MultimediaList list;
	private Placer placer;
	
	public void setList(MultimediaList list) {
		this.list = list;
	}
	
	
	public MultimediaListener(MultimediaList list) {
		super();
		this.list = list;
	}

	public void setPlacer(Placer placer) {
		this.placer = placer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_UP){
			list.up();
		}else if(e.getKeyCode()==e.VK_DOWN){
			list.down();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
