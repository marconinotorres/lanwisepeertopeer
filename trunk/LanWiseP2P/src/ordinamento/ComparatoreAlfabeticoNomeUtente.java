package ordinamento;

import java.util.Comparator;

/**
 * Comparatore Alfabetico Per NomeUtente, ordina la lista in ordine alfabetico per nomeUtente
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreAlfabeticoNomeUtente implements Comparator<ModelListaFile>{

	
	@Override
	public int compare(ModelListaFile file1, ModelListaFile file2) {
		
		return file1.getNomeUtente().compareTo(file2.getNomeUtente());
	}
}
