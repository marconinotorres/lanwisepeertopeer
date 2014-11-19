package multimedia;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;

import modello.FileHandler;

/**
 * Un Modulo personalizzabile di Grafica dove disegna una lista di File
 * 
 * @author Giuseppe Restivo
 */
public class MultimediaList extends Observable implements Drawable {

	private int index = 0;

	private IPlacer placer;
	private IMultimediaSettings settings;
	private IMultimediaContents contents;
	private IOrdinamento ordinamento;

	/**
	 * Inizializza i:
	 * 
	 * @param contenuti
	 *            I {@link IMultimediaContents} assegnati alla lista
	 * @param placer
	 *            I {@link IPlacer} descrivendo in che modo si vogliono
	 *            posizionare
	 * @param settings
	 *            I {@link IMultimediaSettings} descrivendo come la lista dei
	 *            contents si vuole disegnare.
	 * 
	 * @param ordinamento
	 *            I {@link IOrdinamento} descrive l'ordine della lista
	 */
	public MultimediaList(IMultimediaContents contenuti, IPlacer placer,
			IMultimediaSettings settings, IOrdinamento ordinamento) {
		super();
		this.contents = contenuti;
		this.placer = placer;
		this.settings = settings;
		this.ordinamento = ordinamento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see multimedia.Drawable#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics graphics) {

		ArrayList<FileHandler> contenuto = ordinamento.filtraListaFile(contents
				.getContentsList());
		for (int i = 0; i < contenuto.size(); i++) {
			int slot = i - index;
			settings.applySlotSettings(graphics, slot);
			placer.place(graphics, slot, i, contents);
		}
	}

	/**
	 * Muove la lista nello slots, cambiando il focus all'elemento
	 */
	public void down() {
		if (index > 0)
			index--;
		update();
	}

	public IPlacer getPlacer() {
		return placer;
	}

	public IOrdinamento getOrdinamento() {
		return ordinamento;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * muove la lista nello slots, cambiando il focus all'elemento
	 */
	public void up() {
		if (index < contents.getContentsLength() - 1)
			index++;
		update();
	}

	public void update() {
		setChanged();
		notifyObservers();
	}
}
