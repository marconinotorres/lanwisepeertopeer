package filtro;

import java.util.ArrayList;
import java.util.Collections;

import listaFile.ComparatoreAlfabeticoNomeFile;
import listaFile.ListaFile;

/**
 * Organizza la lista di File in ordine alfabetico per NomeFile, usando il Comparator sviluppato nella classe 
 * 
 * @author Giuseppe Restivo
 *
 */
public class FiltraPerNomeFile implements IFiltroListaFile {

	@Override
	public ArrayList<ListaFile> filtraListaFile(ArrayList<ListaFile> filePresenti) {
		Collections.sort(filePresenti, new ComparatoreAlfabeticoNomeFile());
		return filePresenti;
	}
	
}
