package modello;

public class FormattazioneFileHandler {

	private int numeroMAXCARATTERI = 30;
	
	public FormattazioneFileHandler(int numeroMAXCARATTERI) {
		super();
		this.numeroMAXCARATTERI = numeroMAXCARATTERI;
	}

	public String setNCaratteri(String word){
		if (word.length() > numeroMAXCARATTERI) {
			return word.substring(0, numeroMAXCARATTERI-1)+"...";
		}
		return word;
	}
	
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
