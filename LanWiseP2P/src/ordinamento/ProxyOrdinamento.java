package ordinamento;

import java.util.ArrayList;
import java.util.Observable;

import modello.FileHandler;
import multimedia.IOrdinamento;

/**
 * Proxy, cambia a run-time l'istanza delle varie tipologie di filtro
 * 
 * @author Giuseppe Restivo
 * 
 */
public class ProxyOrdinamento implements IOrdinamento {

	private IOrdinamento filtro;

	public void setFiltro(IOrdinamento filtro) {
		this.filtro = filtro;
	}

	public ProxyOrdinamento(IOrdinamento filtro) {
		super();
		this.filtro = filtro;
	}

	@Override
	public ArrayList<FileHandler> filtraListaFile(
			ArrayList<FileHandler> filePresenti) {
		return filtro.filtraListaFile(filePresenti);
	}

}
