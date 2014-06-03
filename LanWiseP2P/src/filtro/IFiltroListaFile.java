package filtro;

import java.util.ArrayList;

import listaFile.ListaFile;


/**
 * Un generico filtro
 * @author giusepperestivo
 *
 */
public interface IFiltroListaFile {

	
	/**
	 * @return un'arrayList di File ordinati secondo il criterio scelto
	 */
	public abstract ArrayList<ListaFile> filtraListaFile(ArrayList<ListaFile> filePresenti);
}
