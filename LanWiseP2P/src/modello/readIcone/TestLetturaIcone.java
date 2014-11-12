package modello.readIcone;


import modello.Icona;
import modello.LetturaIcone;
import modello.dataio.IFileLineReader;

public class TestLetturaIcone implements IFileLineReader{

	/*
	 * (non-Javadoc)
	 * @see modello.dataio.IFileLineReader#readLine(java.lang.String)
	 */
	@Override
	public void readLine(String line) {
		String[] parts = line.split(":");
		Icona icona = new Icona();
		icona.addIcona(parts[0], parts[1]);
		LetturaIcone.getLetturaIcone().addIcona(icona);
		
	}
}
