package rete;

import grafica.FrameCartellaSalvataggio;

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
 * Riceve in broadcast la lista di tutti i file da tutti gli utenti connessi e
 * genera il file "OtherFilesList.txt" che contiene l'elenco dettagliato di
 * tutti i file di tutti gli utenti che devono essere condivisi e visualizzati
 * nel frame
 * 
 * Implementa il protocollo UDP.
 * 
 * Questa classe viene instanziata quando l'utente ha concluso la fase di
 * identificazione delle cartelle {@link FrameCartellaSalvataggio}.
 * 
 * @author Giuseppe Restivo
 * 
 */
public class BroadcastClient extends Thread {

	public void run() {

		ListSignal signal = ListSignal.getInstance();

		while (true) {

			signal.setHasDataToProcess(true);
			try {
				Files.deleteIfExists(Paths.get(INomiFile.FILECONDIVISO));

				MulticastSocket socket = new MulticastSocket(4446);
				InetAddress address = InetAddress
						.getByName(INomePort.NOMEPORTABROADCAST);
				socket.joinGroup(address);
				socket.setReceiveBufferSize(65536);

				DatagramPacket packet;

				PrintWriter out = new PrintWriter(new BufferedWriter(
						new FileWriter(INomiFile.FILECONDIVISO, true)));

				while (true) {

					byte[] buf = new byte[256];
					packet = new DatagramPacket(buf, buf.length);
					socket.receive(packet);

					String received = new String(packet.getData(), 0,
							packet.getLength());
					String ip_rec = new String(packet.getAddress()
							.getHostAddress());
					if (received.equalsIgnoreCase("")) {
						break;
					}

					Scanner scanner = new Scanner(new BufferedReader(
							new FileReader(INomiFile.FILECONDIVISO)));

					boolean found = false;
					while (scanner.hasNextLine()) {
						String nextLine = scanner.nextLine();
						if (received.equals(nextLine)) {
							found = true;
							break;
						}
					}
					if (!found) {
						out.println(received + "," + ip_rec);
					}
					scanner.close();
					out.flush();
				}

				out.flush();
				out.close();
				socket.leaveGroup(address);
				socket.close();

				signal.setHasDataToProcess(false);
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

}