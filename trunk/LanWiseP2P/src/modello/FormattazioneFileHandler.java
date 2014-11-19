package modello;

/**
 * Si occupa di formattare il testo da visualizzazione
 * 
 * @author Giuseppe Restivo
 * 
 */
public class FormattazioneFileHandler {

	private static final int numeroMAXCARATTERI = 30;

	/**
	 * Imposta in numero massimo di caratteri da visualizzare
	 * 
	 * @param word
	 *            da modificare
	 * @return la stringa formattata
	 */
	public String setNCaratteri(String word) {
		if (word.length() > numeroMAXCARATTERI) {
			return word.substring(0, numeroMAXCARATTERI - 1) + "...";
		}
		return word;
	}

	/**
	 * Formatta la dimensione dei file
	 * 
	 * @param dimensione
	 * @return
	 */
	public String numeroDecimali(int dimensione) {

		String dim = String.valueOf(dimensione);
		String dim2 = String.valueOf(dimensione);

		if (dim.length() <= 3) {
			return dim + "byte";
		}
		if (dim.length() >= 4 && dim.length() <= 6) {
			return dim.substring(0, 1) + "," + dim2.substring(1, 3) + "KB";
		}
		return dim.substring(0, 1) + "," + dim2.substring(1, 3) + "MB";

	}

}
