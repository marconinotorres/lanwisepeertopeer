package ordinamento;

import java.util.ArrayList;
import java.util.Collections;

import modello.FileHandler;
import multimedia.IOrdinamento;

/**
 * Organizza la lista di File in ordine alfabetico per nomeUtente, usando il
 * Comparator sviluppato nella classe
 * 
 * @author giusepperestivo
 * 
 */
public class FiltraPerNomeUtente implements IOrdinamento {

	@Override
	public ArrayList<FileHandler> filtraListaFile(
			ArrayList<FileHandler> filePresenti) {
		Collections.sort(filePresenti, new ComparatoreAlfabeticoNomeUtente());
		return filePresenti;
	}
}
