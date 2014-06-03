package filtro;

import java.util.ArrayList;
import java.util.Collections;

import listaFile.ComparatoreDimensione;
import listaFile.ListaFile;

/**
 * Organizza la lista di File in ordine crescente della dimensione dei file, usando il Comparator sviluppato nella classe 
 * 
 * @author Giuseppe Restivo
 *
 */
public class FiltraPerDimensioneFile implements IFiltroListaFile {

	@Override
	public ArrayList<ListaFile> filtraListaFile(ArrayList<ListaFile> filePresenti) {
		Collections.sort(filePresenti, new ComparatoreDimensione());
		return filePresenti;
	}
	
}
