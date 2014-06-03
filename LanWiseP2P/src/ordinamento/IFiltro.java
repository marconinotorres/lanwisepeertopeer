package ordinamento;

import java.util.ArrayList;


/**
 * Un generico filtro
 * @author giusepperestivo
 *
 */
public interface IFiltro {

	
	/**
	 * @return un'arrayList di File ordinati secondo il criterio scelto
	 */
	public abstract ArrayList<ModelListaFile> filtraListaFile(ArrayList<ModelListaFile> filePresenti);
}