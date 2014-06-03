package filtro;

import java.util.ArrayList;
import java.util.Collections;

import listaFile.ComparatoreAlfabeticoPerNomeUtente;
import listaFile.ListaFile;

/**
 * Organizza la lista di File in ordine alfabetico per nomeUtente, usando il Comparator sviluppato nella classe 
 * @author giusepperestivo
 *
 */
public class FiltraPerNomeUtente implements IFiltroListaFile{

	@Override
	public ArrayList<ListaFile> filtraListaFile(ArrayList<ListaFile> filePresenti) {
		Collections.sort(filePresenti, new ComparatoreAlfabeticoPerNomeUtente());
		return filePresenti;
	}
}
