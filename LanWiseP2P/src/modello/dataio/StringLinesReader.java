package modello.dataio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringLinesReader {

	private IFileLineReader fileReader;

	public StringLinesReader(IFileLineReader fileReader) {
		super();
		this.fileReader = fileReader;
	}
	
	/**
	 * Legge le linee di un file
	 * @param filename
	 */
	public void readFile(String filename){
		
		try {
			BufferedReader reader=new BufferedReader(new FileReader(filename));
			String line=reader.readLine();
			while(line!=null){
				fileReader.readLine(line);
				line=reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
