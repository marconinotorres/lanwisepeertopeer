package rete;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Riceve i byte del file che si vuole scaricare
 * 
 * @author giusepperestivo
 * 
 */
public class Client extends Thread {

	private String IP_SERVER;
	private String FILE_TO_RECEIVED;

	public void setIP_SERVER(String iP_SERVER) {
		IP_SERVER = iP_SERVER;
	}

	public void setFILE_TO_RECEIVED(String fILE_TO_RECEIVED) {
		FILE_TO_RECEIVED = fILE_TO_RECEIVED;
	}

	private final static int FILE_SIZE = 6022386;

	public void run() {
		try {
			esegui();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void esegui() throws IOException {
		int bytesRead;
		int current = 0;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		Socket sock = null;

		sock = new Socket(IP_SERVER, INumberPort.SOCKET_PORT_CLIENT_SERVER);

		byte[] mybytearray = new byte[FILE_SIZE];
		InputStream is = sock.getInputStream();
		fos = new FileOutputStream(FILE_TO_RECEIVED);
		bos = new BufferedOutputStream(fos);
		bytesRead = is.read(mybytearray, 0, mybytearray.length);
		current = bytesRead;

		while (bytesRead > -1) {
			bytesRead = is.read(mybytearray, current,
					(mybytearray.length - current));
			if (bytesRead >= 0) {
				current += bytesRead;
			}
		}

		bos.write(mybytearray, 0, current);
		bos.flush();

		fos.close();
		bos.close();
		sock.close();

	}

}