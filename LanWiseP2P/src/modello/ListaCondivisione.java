package modello;

import java.util.ArrayList;
import java.util.Observable;

public class ListaCondivisione extends Observable {

	ArrayList<FileHandler> multimedia = new ArrayList<FileHandler>();

	public ListaCondivisione() {

		multimedia.clear();
		multimedia.add(new FileHandler("/home/rant/Scrivania/testD/cell-rcv", "127.0.0.1"));
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
