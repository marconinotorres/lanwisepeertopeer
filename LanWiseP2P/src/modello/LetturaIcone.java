package modello;


public class LetturaIcone {

	//as Singleton
	private static LetturaIcone letturaIcone = new LetturaIcone();
	private LetturaIcone() {
		// TODO Auto-generated constructor stub
	}
	
	public static LetturaIcone getLetturaIcone() {
		return letturaIcone;
	}
	
	//as Class
	private ISetIcone setIcone;
	private String path;
	
	public void setSetIcone(ISetIcone setIcone) {
		this.setIcone = setIcone;
	}
	
	public ISetIcone getSetIcone() {
		return setIcone;
	}
	
	/**
	 * @return la directory che contiene il set di Icone da visualizzare
	 */
	public String getPath(){
		return path;
	}
	
	/**
	 * Imposta la directory contenente il set di Icone che si vuole impostare
	 * @param path
	 */
	public void setPath(String path){
		this.path = path;
	}
		
	
}
