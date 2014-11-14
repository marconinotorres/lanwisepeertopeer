package modello;

/**
 * Imposta la cartella da Condividere e la cartella dove si andranno a salvare i
 * file scaricati
 * 
 * E' un singleton perch� le queste cartelle non si cambieranno pi� una volta scelte
 * 
 * @author Giuseppe Restivo
 * 
 */
public class CartelleUtente {

	// SINGLETON!
	private static CartelleUtente instance;

	private CartelleUtente() {

	}

	public static synchronized CartelleUtente getInstance() {
		if (instance == null) {
			instance = new CartelleUtente();
		}
		return instance;
	}

	public String downFolder;
	public String upFolder;

	public String getDownFolder() {
		return downFolder;
	}

	public void setDownFolder(String downFolder) {
		this.downFolder = downFolder;
	}

	public String getUpFolder() {
		return upFolder;
	}

	public void setUpFolder(String upFolder) {
		this.upFolder = upFolder;
	}

}
