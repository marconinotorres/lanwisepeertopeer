package multimedia.placers;

import java.awt.Graphics;

import multimedia.IMultimediaContents;
import multimedia.IPlacer;

public class ProxyPlacer implements IPlacer {

	private IPlacer placer;

	public ProxyPlacer(IPlacer placer) {
		super();
		this.placer = placer;
	}
	public void setPlacer(IPlacer placer) {
		this.placer = placer;
	}
	
	/*
	 * (non-Javadoc)
	 * @see multimedia.IPlacer#place(java.awt.Graphics, int, int, multimedia.IMultimediaContents)
	 */
	@Override
	public void place(Graphics graphics, int slot, int index,
			IMultimediaContents contents) {
		placer.place(graphics, slot, index, contents);
	}

}
