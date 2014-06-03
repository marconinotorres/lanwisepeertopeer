package ordinamento;

import java.util.ArrayList;
import java.util.Collections;

import modello.ModelFile;

/**
 * Organizza la lista di File in ordine crescente della dimensione dei file, usando il Comparator sviluppato nella classe 
 * 
 * @author Giuseppe Restivo
 *
 */
public class FiltraPerDimensioneFile implements IFiltro {

	@Override
	public ArrayList<ModelFile> filtraListaFile(ArrayList<ModelFile> filePresenti) {
		Collections.sort(filePresenti, new ComparatoreDimensione());
		return filePresenti;
	}
	
}

