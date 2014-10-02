package modello;

import java.util.ArrayList;

/**
 * Interfaccia che si dedica a disaccoppiare gli utenti, così è possibile
 * inserire nuovi utenti, cancellarli....
 * Possibile gestione con Basi di Dati o tramite una lettura da file
 * @author giusepperestivo
 *
 */
public interface IListaUtenti {

	public ArrayList<String> getListaUtenti();
	
	public String toString(int index);
	
}
