package ordinamento;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Organizza la lista di File in ordine alfabetico per NomeFile, usando il Comparator sviluppato nella classe 
 * 
 * @author Giuseppe Restivo
 *
 */
public class FiltraPerNomeFile implements IFiltro {

	@Override
	public ArrayList<ModelListaFile> filtraListaFile(ArrayList<ModelListaFile> filePresenti) {
		Collections.sort(filePresenti, new ComparatoreAlfabeticoNomeFile());
		return filePresenti;
	}
	
}
