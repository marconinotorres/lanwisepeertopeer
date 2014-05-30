package reti;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client extends Thread{

	public final static int SOCKET_PORT = 13201; //numero a piacere; lo stesso del Server
	public final static String SERVER = "127.0.0.1"; 
	public static String FILE_TO_RECEIVED;

	public final static int FILE_SIZE = 6022386; // sovrastimato

	public void run() { // probabilmente c'è un modo migliore di farlo;
		try {
			main(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main (String [] args ) throws IOException {
		int bytesRead;
		int current = 0;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		Socket sock = null;

		sock = new Socket(SERVER, SOCKET_PORT);
		System.out.println("(C) Connecting...");

		byte [] mybytearray  = new byte [FILE_SIZE];
		InputStream is = sock.getInputStream();
		fos = new FileOutputStream(FILE_TO_RECEIVED);
		bos = new BufferedOutputStream(fos);
		bytesRead = is.read(mybytearray,0,mybytearray.length);
		current = bytesRead;

		while(bytesRead > -1) {
			bytesRead = is.read(mybytearray, current, (mybytearray.length-current));
			if(bytesRead >= 0) {
				current += bytesRead;
			}
		} 

		bos.write(mybytearray, 0 , current);
		bos.flush();
		System.out.println("(C) File " + FILE_TO_RECEIVED + " downloaded (" + current + " bytes read)");

		fos.close();
		bos.close();
		sock.close();

	}

}