package modello;

/**
 * Imposta tutti i setting grafici: come Impostare la lunghezza massima di caratteri da visualizzare
 * 
 * @author Giuseppe Restivo
 *
 */
public class FormattazioneFileHandler extends FileHandler {

	private static final int numeroMAXCARATTERI = 50;

	
	public FormattazioneFileHandler(String nomeFile, int dimension,
			Utente utente, String path, String icona) {
		super(nomeFile, dimension, utente, path, icona);

	}

	/**
	 * Imposta in numero massimo di caratteri da visualizzare
	 * @param word da modificare
	 * @return
	 */
	public String setNCaratteri(String word){
		if (word.length() > numeroMAXCARATTERI) {
			return word.substring(0, numeroMAXCARATTERI-1)+"...";
		}
		return word;
	}
	
	/**
	 * TODO da modificare
	 * 
	 * @param dimensione
	 * @return
	 */
	public String numeroDecimali(int dimensione){
		
		String dim = String.valueOf(dimensione);
		String dim2 = String.valueOf(dimensione);
		System.err.println(dimensione+"   "+dim.length());
		if (dim.length()<=3) {
			return dim+"byte";
		}
		if (dim.length()>=4 && dim.length()<=6) {
			return dim.substring(0,1)+","+dim2.substring(1,3)+"KB";
		}
		return dim.substring(0,1)+","+dim2.substring(1,3)+"MB";
		
	}
	
}
