package ordinamento;

import java.util.ArrayList;

import modello.FileHandler;

/**
 * Un generico filtro
 * @author giusepperestivo
 *
 */
public interface IFiltro {

	
	/**
	 * @return un'arrayList di File ordinati secondo il criterio scelto
	 */
	public abstract ArrayList<FileHandler> filtraListaFile(ArrayList<FileHandler> filePresenti);
}