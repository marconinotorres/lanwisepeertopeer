package rete;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import modello.ListaUtenti;
import modello.dataio.StringLinesWriter;
import modello.letturaListaUtenti.TestWriteChangeConnessione;

/**
 * Questa classe viene istanziata quando un utente si connette per 
 * 
 * chiedere la lista di tutti gli utenti che non sono ancora connessi
 * 
 * @author Giuseppe Restivo
 *
 */
public class ListaUtentiRete extends Thread {

	
	@Override
	public void run() {
		MulticastSocket socket;
		try {
			socket = new MulticastSocket(4450);
			InetAddress address = InetAddress
					.getByName(INomePort.NOMEPORTABROADCAST2);
			socket.joinGroup(address);
			socket.setReceiveBufferSize(65536);
			
			DatagramPacket packet;
			
			for (int i = 0; i < ListaUtenti.getUtenti().getListaUtenti().size(); i++) {
				byte[] buf = new byte[256];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);				
				String ip_rec = new String(packet.getAddress()
						.getHostAddress());

		
				ListaUtenti.getUtenti().impostaConnessioni(ip_rec);
			}
			(new StringLinesWriter(new TestWriteChangeConnessione())).write("data/listaUtenti.txt");
			socket.leaveGroup(address);
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
