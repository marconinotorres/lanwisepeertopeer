package modello;

import java.util.List;

/**
 * Un set di icone corrisponde alla possibilit� di avere pi� cartelle contenenti icone.
 * 
 * Il set di icone pu� essere cambiato a run-time e l'utente visualizzer� il set scelto.
 * 
 * @author Giuseppe Restivo
 *
 */
public interface ISetIcone {
	

	/**
	 * Effettua la lettura del file che contiene le icone presenti per un dato set.
	 * Ogni set deve contenere un file rinominato 'fslook.txt'.
	 * Tale file ha la descrizione completa di tutte le icone, nella seguente formattazione:
	 * 'estenione:NomeIconaAssociato'.
	 * 
	 * @return la lista di tutte le icone per il set di icone scelto
	 */
	public abstract List<Icona> leggiFile();
	
	
	/**
	 * Legge dentro la directory 'icone' tutti i set di icone disponibili
	 * 
	 * Tutti i set di icone,quindi, verranno aggiunte automaticamente alla lista dei set disponibili
	 * 
	 * @return i nomi delle directory che contengono tutti i set di icone disponibili.
	 */
	public String[] readDirectoryIcone();
}


