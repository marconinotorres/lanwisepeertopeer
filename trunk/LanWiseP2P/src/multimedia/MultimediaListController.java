package multimedia;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import multimedia.IMultimediaContents;
import multimedia.MultimediaList;
import multimedia.placers.ProxyPlacer;
import multimedia.placers.VerticalPlacer;

/**
 * Si occupa di gestire i controlli sul modello
 * @author Giuseppe Restivo
 *
 */
public class MultimediaListController extends KeyAdapter{

	//as a Singleton
	private static MultimediaListController controller=new MultimediaListController();
	
	private MultimediaListController() {
		super();
	}
	
	public static MultimediaListController getController() {
		return controller;
	}

	
	//as a Class

	private MultimediaList multimediaList;//=null
	private IMultimediaContents contents;//=null
	
	private VerticalPlacer vPlacer=new VerticalPlacer();
		
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		
		if(e.getKeyCode()==KeyEvent.VK_UP){
			multimediaList.down();
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			multimediaList.up();
		}
		if(e.getKeyCode()==KeyEvent.VK_A){
			((ProxyPlacer)multimediaList.getPlacer()).setPlacer(vPlacer);
		}
				
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			this.contents.execute(multimediaList.getIndex());
		}
	}

	
	public VerticalPlacer getvPlacer() {
		return vPlacer;
	}


	public void setMultimediaList(MultimediaList multimediaList) {
		this.multimediaList = multimediaList;
	}

	public void setContents(IMultimediaContents contents) {
		this.contents = contents;
	}

}
