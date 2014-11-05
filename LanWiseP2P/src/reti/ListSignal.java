package reti;

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

	public synchronized boolean hasDataToProcess() {
		return this.hasDataToProcess;
	}

	public synchronized void setHasDataToProcess(boolean hasData) {
		this.hasDataToProcess = hasData;
	}
}
