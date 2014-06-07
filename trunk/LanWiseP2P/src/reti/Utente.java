package reti;

public class Utente {
	
	// SINGLETON!
	private static Utente instance;
	private Utente() {
		
	}
	
	public static synchronized Utente getInstance() {
		if (instance == null) {
			instance = new Utente();
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
