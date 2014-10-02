package reti;

import grafica.EccezioneDialog;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import modello.GestioneEccezioni;

public class Server extends Thread{

	public final static int SOCKET_PORT = 13499; //numero a piacere; lo stesso del Client
	public static String FILE_TO_SEND;

	public void run(){ //probabilmente c'?? un mdoo migliore di farlo;
		try {
			main(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main (String [] args ) throws IOException {
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		ServerSocket servsock = null;
		Socket sock = null;

		servsock = new ServerSocket(SOCKET_PORT);

		System.out.println("(S) Waiting...");

		sock = servsock.accept();
		
		System.out.println("(S) Accepted connection : " + sock);
		File myFile = new File (FILE_TO_SEND);
		byte [] mybytearray  = new byte [(int)myFile.length()];
		fis = new FileInputStream(myFile);
		bis = new BufferedInputStream(fis);
		bis.read(mybytearray,0,mybytearray.length);
		os = sock.getOutputStream();
		System.out.println("(S) Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
		os.write(mybytearray,0,mybytearray.length);
		os.flush();
		System.out.println("(S) Done.");

		EccezioneDialog dialog = new  EccezioneDialog(new GestioneEccezioni("Download Completato"));
		bis.close();
		os.close();
		sock.close();
		servsock.close();
		dialog.setVisible(true);
	}
}
