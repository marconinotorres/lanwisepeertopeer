package tests;

import rete.PeerAsClient;
import rete.PeerAsServer;

public class TestSendFiles {

	public static void main(String[] args) {

		PeerAsServer sapo = new PeerAsServer();
		sapo.start();

		PeerAsClient stePac = new PeerAsClient();
		stePac.setIP_SERVER("127.0.0.1");
		stePac.setFILE_TO_REQUEST("/home/rant/Scrivania/testS/cell");
		stePac.setFILE_TO_RECEIVED("/home/rant/Scrivania/testS/cell2");
		stePac.start();
		try {
			stePac.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// PeerAsClient stePac2 = new PeerAsClient();
		// stePac2.IP_SERVER = "127.0.0.1";
		// stePac2.FILE_TO_REQUEST = "/Users/BaxaMac/Desktop/c.txt";
		// stePac2.FILE_TO_RECEIVED = "/Users/BaxaMac/Desktop/c3.txt";
		// stePac2.start();
		// try {
		// stePac2.join();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}