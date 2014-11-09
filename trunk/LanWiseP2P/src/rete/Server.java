package rete;

import grafica.EccezioneDialog;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import modello.MessaggioEccezione;

/**
 * Trasferisce il file scelto nella cartella Salvataggio, fa il download del
 * file
 * 
 * @author giusepperestivo
 * 
 */
public class Server extends Thread {

	private String FILE_TO_SEND;

	public void setFILE_TO_SEND(String fILE_TO_SEND) {
		FILE_TO_SEND = fILE_TO_SEND;
	}

	public void run() {
		try {
			esegui();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void esegui() throws IOException {

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		ServerSocket servsock = null;
		Socket sock = null;

		servsock = new ServerSocket(INumberPort.SOCKET_PORT_CLIENT_SERVER);

		sock = servsock.accept();

		File myFile = new File(FILE_TO_SEND);
		byte[] mybytearray = new byte[(int) myFile.length()];
		fis = new FileInputStream(myFile);
		bis = new BufferedInputStream(fis);
		bis.read(mybytearray, 0, mybytearray.length);
		os = sock.getOutputStream();

		os.write(mybytearray, 0, mybytearray.length);
		os.flush();

		EccezioneDialog dialog = new EccezioneDialog(new MessaggioEccezione(
				"Download Completato"));

		bis.close();
		os.close();
		sock.close();
		servsock.close();
		dialog.setVisible(true);
	}
}
