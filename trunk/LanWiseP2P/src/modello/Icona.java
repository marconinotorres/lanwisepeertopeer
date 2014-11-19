package modello;

import java.util.HashMap;
import java.util.List;

/**
 * Modello di una icona: estensione e nome file
 * 
 * @author giusepperestivo
 * 
 */
public class Icona {

	private HashMap<String, String> icona = new HashMap<String, String>();

	/**
	 * Aggiunge un'icona
	 * 
	 * @param estensione
	 *            file
	 * @param nome
	 *            file
	 */
	public void addIcona(String estensione, String nomeFile) {
		icona.put(estensione, nomeFile);
	}

	public String getNomeIcona(String est) {
		return icona.get(est);
	}

	/**
	 * Controlla se la Mappa contiene l'estensione del file specificato
	 * 
	 * @param estensione
	 * @return true se la mappatura contiene la chiave specificata, altrimenti
	 *         false
	 */
	public boolean isContains(String estensione) {
		if (icona.containsKey(estensione)) {
			return true;
		}
		return false;
	}

	public void pulisci() {
		icona.clear();
	}

}
