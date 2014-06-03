package listaFile;

import java.util.Comparator;

/**
 * Comparatore Alfabetico Per NomeUtente, ordina la lista in ordine alfabetico per nomeUtente
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreAlfabeticoPerNomeUtente implements Comparator<ListaFile>{

	
	@Override
	public int compare(ListaFile file1, ListaFile file2) {
		
		return file1.getNomeUtente().compareTo(file2.getNomeUtente());
	}
}
