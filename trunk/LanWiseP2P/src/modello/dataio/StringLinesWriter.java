package modello.dataio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class StringLinesWriter {

	private Iterator<String> lines;

	public StringLinesWriter(Iterator<String> lines) {
		super();
		this.lines = lines;
	}

	/**
	 * Scrive Le linee di un file
	 * 
	 * @param filename
	 */
	public void write(String filename) {
		try {
			FileWriter writer = new FileWriter(filename, false);
			while (lines.hasNext()) {
				writer.write(lines.next() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
