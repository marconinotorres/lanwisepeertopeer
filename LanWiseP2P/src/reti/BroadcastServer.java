package reti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

import modello.FileHandler;
import modello.Utente;
import modello.readUtenti.UtenteReader;
import modello.writeUtenti.UtenteWriter;

/**
 * Invia in broadcast la lista dei propri file
 * 
 * @author giusepperestivo
 *
 */
public class BroadcastServer extends Thread {

	protected DatagramSocket socket = null;
	protected BufferedReader in = null;
	protected boolean moreLines = true;
	static File upFolder;

	public BroadcastServer(File upFolder) throws IOException {
		
		this.upFolder = upFolder;
		socket = new DatagramSocket(4445);
		socket.setSendBufferSize(65536);

	}


	public void run() {
		while(true) {
			
			moreLines = true;

			listFilesForFolder(upFolder);
			
			try {
				in = new BufferedReader(new FileReader("MyFilesList.txt"));
			} catch (FileNotFoundException e) {
				System.err.println("Could not open file.");
			}

			while (moreLines) {
				try {
					byte[] buf = new byte[256];

					String dString = getNextLine();
					buf = dString.getBytes();

					InetAddress group = InetAddress.getByName("230.0.0.1");
					DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
					socket.send(packet);
//					System.out.println("ho inviato un pacchetto"+dString);


				} catch (IOException e) {
					e.printStackTrace();
					moreLines = false;
				}
			}
			//socket.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	protected String getNextLine() {
		String returnValue = null;
		try {
			if ((returnValue = in.readLine()) == null) {
				in.close();
				moreLines = false;
				returnValue = "";
			}
		} catch (IOException e) {
			returnValue = "IOException occurred in server.";
		}
		return returnValue;
	}

	public void listFilesForFolder(final File folder) {
		

		try {
			Files.deleteIfExists(Paths.get("MyFilesList.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("MyFilesList.txt", true)));
		} catch (IOException e) {
			e.printStackTrace();
		}



		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				if (!fileEntry.getName().startsWith(".")) {
					
					String file = fileEntry.getName()+","+(int)fileEntry.length()+","+
							UtenteWriter.getUtente().getUtenteCollegato().getCognome()+","+
							UtenteWriter.getUtente().getUtenteCollegato().getNome();
					out.println(file);
					out.flush();
				}
			}
		}

		out.close();

	}
}