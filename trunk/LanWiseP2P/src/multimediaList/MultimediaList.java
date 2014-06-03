package multimediaList;

import java.awt.Graphics;
import java.util.ArrayList;

import modello.FileHandler;

public class MultimediaList implements Drawable {

	private IUpdate panel;
	private IMultimediaContents list;
	private IMultimediaSettings setting;
	
	Placer placer = new Placer();

	private int index;
	
	public void setPanel(IUpdate panel) {
		this.panel = panel;
	}
	
	public void update(){
		panel.update();
	}
	
	public void setPlacer(Placer placer) {
		this.placer = placer;
	}
	public void setList(IMultimediaContents list) {
		this.list = list;
	}
		
	public void setSetting(IMultimediaSettings setting) {
		this.setting = setting;
	}
	
	/* (non-Javadoc)
	 * @see multimediaList.Drawable#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g){
		for (int i = 0; i < list.sizeList(); i++) {
			setting.setting(g, i, index);
			int[] xy = new int[2];
			placer.place(xy,index,i);
			g.drawString(list.toString(i),xy[0], xy[1]);
		}
	}

	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int up(){
		index--;
		if(index < 0){
			index = 0;
		}
		panel.update();
		return index;
	}
	
	public int down(){
		
		index++;
		if(index >= list.sizeList()){
			index = list.sizeList()-1;
		}
		panel.update();
		return index;
	}
	
}
