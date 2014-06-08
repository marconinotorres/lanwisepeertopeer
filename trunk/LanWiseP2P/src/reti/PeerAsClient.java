package reti;

import java.io.OutputStreamWriter;
import java.net.Socket;

public class PeerAsClient extends Thread {
	
	public static int SOCKET_PORT_REQUEST = 13597;
	public String IP_SERVER;
	public String FILE_TO_REQUEST;
	public String FILE_TO_RECEIVED;
	
	public void run(){ //probabilmente c'?? un mdoo migliore di farlo;
		try {
			apriConnessione();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void apriConnessione() throws Exception{
		OutputStreamWriter osw;
		Socket sock = null;

		sock = new Socket(IP_SERVER, SOCKET_PORT_REQUEST);
		System.out.println("(PC) Connecting...");

//		os = sock.getOutputStream();
//		PrintWriter out = new PrintWriter(os);
//		out.print(FILE_TO_REQUEST);
		osw = new OutputStreamWriter(sock.getOutputStream(), "UTF-8");
        osw.write(FILE_TO_REQUEST, 0, FILE_TO_REQUEST.length());
		
		osw.flush();
		osw.close();
		
		sleep(0);
//		assert Boolean.TRUE;

		sock.close();

		Client client = new Client();
		client.FILE_TO_RECEIVED = FILE_TO_RECEIVED;
		client.IP_SERVER = IP_SERVER;
		client.start();
		client.join();
		
		
	}

}
