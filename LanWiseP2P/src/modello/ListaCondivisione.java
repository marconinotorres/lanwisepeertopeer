package modello;

import java.util.ArrayList;
import java.util.Observable;

public class ListaCondivisione extends Observable {

	ArrayList<FileHandler> multimedia = new ArrayList<FileHandler>();

	public ListaCondivisione() {

		multimedia.clear();
		multimedia.add(new FileHandler("prova1", "Giuseppe Restivo"));
		multimedia.add(new FileHandler("prova2", "Marco Cortesi"));
		multimedia.add(new FileHandler("prova3", "Nicola Blago"));
		multimedia.add(new FileHandler("prova4", "Federico Bacci"));
		multimedia.add(new FileHandler("prova5", "Stefano Azzolina"));
		multimedia.add(new FileHandler("prova7", "Stefano Azzolina"));
		update();

	}

	public ArrayList<FileHandler> getMultimedia() {
		return multimedia;
	}

	public void update() {
		setChanged();
		notifyObservers();
	}




}
