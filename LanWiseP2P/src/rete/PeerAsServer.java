package rete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import modello.Utente;

/**
 * Resta in ascolto di una richiesta di download (ovvero il PeerAsServer di un
 * altro utente) e attiva l'effettivo Server che trasferisce i byte.
 * 
 * @author giusepperestivo
 * 
 */
public class PeerAsServer extends Thread {

	public void run() {
		try {
			accettaConnessione();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void accettaConnessione() throws Exception {

		while (true) {

			String nomeFile;
			ServerSocket servsock = null;
			Socket sock = null;

			servsock = new ServerSocket(INumberPort.SOCKET_PORT_PEER);

			sock = servsock.accept();

			BufferedReader socketReader = null;

			socketReader = new BufferedReader(new InputStreamReader(
					sock.getInputStream()));
			nomeFile = socketReader.readLine();

			sock.close();
			servsock.close();

			Server server = new Server();
			server.setFILE_TO_SEND(nomeFile);
			server.start();
			server.join();

		}
	}

}
