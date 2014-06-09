package ordinamento;

import java.util.ArrayList;
import java.util.Collections;

import modello.FileHandler;

/**
 * Organizza la lista di File in ordine alfabetico per NomeFile, usando il Comparator sviluppato nella classe 
 * 
 * @author Giuseppe Restivo
 *
 */
public class FiltraPerNomeFile implements IFiltro {

	@Override
	public ArrayList<FileHandler> filtraListaFile(ArrayList<FileHandler> filePresenti) {
		Collections.sort(filePresenti, new ComparatoreAlfabeticoNomeFile());
		return filePresenti;
	}
	
}
