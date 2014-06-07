package reti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class PeerAsServer extends Thread {
	
	public final static int SOCKET_PORT_REQUEST = 13697;
	
	public void run(){ //probabilmente c'?? un mdoo migliore di farlo;
		try {
			accettaConnessione();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void accettaConnessione() throws Exception{
		while(true){
			String nomeFile;			
			ServerSocket servsock = null;
			Socket sock = null;

			servsock = new ServerSocket(SOCKET_PORT_REQUEST);

			sock = servsock.accept();
			
			System.out.println("(PS) Accepting connection...");
			
			BufferedReader socketReader = null;
			socketReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			nomeFile = socketReader.readLine();
			System.out.println(nomeFile);
			sock.close();
			servsock.close();
			
			Server server = new Server();
			server.FILE_TO_SEND = nomeFile;
			server.start();
			server.join();
			
		}	
	}

}
