package multimedia;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;

import modello.FileHandler;

/**
 * Un Modulo personalizzabile di Grafica dove disegna una lista di 
 * File
 *  
 * @author Giuseppe Restivo
 */
public class MultimediaList extends Observable implements Drawable {
	
	private int index=0;
	
	private IPlacer placer;
	private IMultimediaSettings settings;
	private IMultimediaContents contents;
	
	/**
	 *Inizializza i:
	 * @param contenuti I {@link IMultimediaContents} assegnati alla lista
	 * @param placer I {@link IPlacer} descrivendo in che modo si vogliono posizionare
	 * @param settings I {@link IMultimediaSettings} descrivendo come la lista dei contents si vuole disegnare.
	 */
	public MultimediaList(IMultimediaContents contenuti,IPlacer placer,IMultimediaSettings settings) {
		super();
		this.contents = contenuti;
		this.placer=placer;
		this.settings=settings;
	}

	/* (non-Javadoc)
	 * @see contenutiMultimediali.IDrawable#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics graphics) {
		
		for (int i = 0; i < contents.getContentsLength(); i++) {			
			int slot=i-index;
			settings.applySlotSettings(graphics, slot);
			placer.place(graphics, slot, contents.getContentsList().get(i).toString());
		}
	}

	/**
	 * Muove la lista nello slots, cambiando il focus all'elemento
	 */
	public void down() {
		if(index>0)
			index--;
		update();
	}

	public IPlacer getPlacer(){
		return placer;
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
		if(index<contents.getContentsLength()-1)
			index++;
		update();
	}

	/**
	 * @return la lista di contents
	 */
	public ArrayList<FileHandler> getList() {
		return contents.getContentsList();
	}


	
	public void update() {
		setChanged();
		notifyObservers();
	}
}
