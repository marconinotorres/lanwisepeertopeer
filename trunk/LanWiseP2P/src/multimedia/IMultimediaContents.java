package multimedia;

import java.util.ArrayList;

import modello.FileHandler;

/**
 * Una lista di contenuti di file
 * 
 * @author Giuseppe Restivo
 */
public interface IMultimediaContents {

	public void addContents(String nomeFile);

	/**
	 * @return la lista di file
	 */
	public abstract ArrayList<FileHandler> getContentsList();

	/**
	 * @return il numero di file presenti nella lista
	 */
	public int getContentsLength();

	/**
	 * Scarica su disco locale il contenuto i-esimo della lista
	 * 
	 * @param elemento
	 *            i-esimo della lista scelto
	 */
	public void execute(int index);

}