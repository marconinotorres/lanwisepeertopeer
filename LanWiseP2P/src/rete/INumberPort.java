package rete;

/**
 * Specifica il numero di porte usate dai socket e i nomi dei file da cui BroadcastClient e BroadcastServer andranno a leggere per
 * adempiere ai propri compiti
 * 
 * @author Giuseppe Restivo
 * 
 */
public class INumberPort {

	/**
	 * Numero di porta del Server e Client
	 */
	public static final int SOCKET_PORT_CLIENT_SERVER = 13499;

	/**
	 * Numero di porta del PeerAsServer e PeerAsClient
	 */
	public static final int SOCKET_PORT_PEER = 13497;

	/**
	 * Nome host usato in BroadcastServer e BroadcastClient
	 */
	public static final String NOMEPORTABROADCAST = "230.0.0.1";
	
	/**
	 * Nome del file che viene condiviso tra gli utenti e che contiene 
	 */
	public static final String FILECONDIVISO = "data/OtherFilesList.txt";
	
	/**
	 * Nome del file che contiene tutti i file di un singolo utente e che verrˆ condiviso con gli altri
	 */
	public static final String FILEUTENTE = "data/MyFilesList.txt";
	

}
