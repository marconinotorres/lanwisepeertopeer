package ordinamento;

import java.util.ArrayList;
import java.util.Observable;

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
	}

	@Override
	public ArrayList<ModelListaFile> filtraListaFile(ArrayList<ModelListaFile> filePresenti) {
		return filtro.filtraListaFile(filePresenti);
	}
	
	
	
	public void update(){
		setChanged();
		notifyObservers();
	}
}
