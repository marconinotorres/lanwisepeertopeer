package reti;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.file.Files;
import java.nio.file.Paths;

import modello.FileHandler;
import modello.FrameCondivisione;
import modello.ListaCondivisione;

public class BroadcastClient extends Thread {

	public void run() { // probabilmente c'?? un modo migliore di farlo;
		try {
			main(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		while(true) {

			Files.deleteIfExists(Paths.get("OtherFilesList.txt"));

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
				String ip_rec = new String(packet.getAddress().getHostAddress());
				if (received.equalsIgnoreCase("")) {break;}
				out.println(received);
				out.println(ip_rec);
				//System.out.println("sto ricevendo "+received+" da "+ip_rec);
			}

			out.flush();
			out.close();
			socket.leaveGroup(address);
			socket.close();
						
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}