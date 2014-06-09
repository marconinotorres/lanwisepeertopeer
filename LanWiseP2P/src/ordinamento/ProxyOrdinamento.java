package ordinamento;

import java.util.ArrayList;
import java.util.Observable;

import modello.FileHandler;

/**
 * Proxy, cambia a run-time l'istanza delle varie tipologie di filtro
 * @author Giuseppe Restivo
 *
 */
public class ProxyOrdinamento extends Observable implements IFiltro{

	private IFiltro filtro;
	
	public void setFiltro(IFiltro filtro) {
		this.filtro = filtro;
		update();
	}
	
	public ProxyOrdinamento(IFiltro filtro) {
		super();
		this.filtro = filtro;
		update();
	}

	@Override
	public ArrayList<FileHandler> filtraListaFile(ArrayList<FileHandler> filePresenti) {
		return filtro.filtraListaFile(filePresenti);
	}
	
	
	
	public void update(){
		setChanged();
		notifyObservers();
	}
	
}
