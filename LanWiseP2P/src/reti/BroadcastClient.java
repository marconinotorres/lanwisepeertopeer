package reti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 * Riceve la lista di tutti i file di tutti gli utenti
 * 
 * @author giusepperestivo
 *
 */
public class BroadcastClient extends Thread {

	public void run() { // probabilmente c'?? un modo migliore di farlo;
		try {
			main(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
		
		Files.deleteIfExists(Paths.get("OtherFilesList.txt"));
		
		while(true) {
			
			MulticastSocket socket = new MulticastSocket(4446);
			InetAddress address = InetAddress.getByName("230.0.0.1");
			socket.joinGroup(address);
			socket.setReceiveBufferSize(65536);

			DatagramPacket packet;

			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("OtherFilesList.txt", true)));

			while(true) {
				byte[] buf = new byte[256];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);

				String received = new String(packet.getData(), 0, packet.getLength());
				
				if (received.equalsIgnoreCase("")) {break;}

				Scanner scanner=new Scanner(new BufferedReader(new FileReader("OtherFilesList.txt")));
				boolean found=false;
				while(scanner.hasNextLine()){
					String nextLine=scanner.nextLine();
					if(received.equals(nextLine)){
						found=true;
						break;
					}
				}
				if(!found){
						out.println(received);
						
				}
				scanner.close();
				
			}

			out.flush();
			out.close();
			socket.leaveGroup(address);
			socket.close();
			
						
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}