package rete;

/**
 * E' un semaforo per la lettura del file 'OtherFileLists.txt'.
 * Quando questo file viene scritto da un utente, un altro non può nè accedervi in lettura nè modificarlo.
 * Risolve il problema del "lampeggiamento" nella visualizzazione grafica delle liste. 
 * 
 * @author Giuseppe Restivo
 *
 */
public class ListSignal {

	private static ListSignal instance;
	private boolean hasDataToProcess = false;

	private ListSignal() {
	}

	public static synchronized ListSignal getInstance() {
		if (instance == null) {
			instance = new ListSignal();
		}
		return instance;
	}

	/**
	 * @return true se un processo sta elaborando il file; in caso di false il processo può elaborare il file
	 */
	public synchronized boolean hasDataToProcess() {
		return this.hasDataToProcess;
	}

	public synchronized void setHasDataToProcess(boolean hasData) {
		this.hasDataToProcess = hasData;
	}
}
