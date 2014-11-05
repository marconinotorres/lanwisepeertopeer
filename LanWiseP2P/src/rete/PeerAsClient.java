package rete;

import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Viene attivato quando si vuole in download un certo file e
 * 
 * avvia il Client effettivo che riceve i byte e li salva.
 * 
 * @author giusepperestivo
 * 
 */
public class PeerAsClient extends Thread {

	
	private String IP_SERVER;
	private String FILE_TO_REQUEST;
	private String FILE_TO_RECEIVED;

	public void run() { 
		try {
			apriConnessione();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apriConnessione() throws Exception {

		OutputStreamWriter osw;
		Socket sock = null;

		System.err.println(IP_SERVER);
		sock = new Socket(IP_SERVER, INumberPort.SOCKET_PORT_PEER);
		System.out.println("(PC) Connecting...");

		
		osw = new OutputStreamWriter(sock.getOutputStream(), "UTF-8");
		osw.write(FILE_TO_REQUEST, 0, FILE_TO_REQUEST.length());

		osw.flush();
		osw.close();

		sleep(0);

		sock.close();

		Client client = new Client();
		
		client.setFILE_TO_RECEIVED(FILE_TO_RECEIVED);
		client.setIP_SERVER(IP_SERVER);
		client.start();
		client.join();

	}

	public void setIP_SERVER(String iP_SERVER) {
		IP_SERVER = iP_SERVER;
	}

	public void setFILE_TO_REQUEST(String fILE_TO_REQUEST) {
		FILE_TO_REQUEST = fILE_TO_REQUEST;
	}

	public void setFILE_TO_RECEIVED(String fILE_TO_RECEIVED) {
		FILE_TO_RECEIVED = fILE_TO_RECEIVED;
	}

}
