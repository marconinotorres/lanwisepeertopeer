package multimedia.placers;

import java.awt.Graphics;

import multimedia.IPlacer;

public class ProxyPlacer implements IPlacer {

	private IPlacer placer;

	public ProxyPlacer(IPlacer placer) {
		super();
		this.placer = placer;
	}

	@Override
	public void place(Graphics graphics, int slot, String content) {
		placer.place(graphics, slot, content);
	}

	public void setPlacer(IPlacer placer) {
		this.placer = placer;
	}
}
