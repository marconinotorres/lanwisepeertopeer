package tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import rete.BroadcastClient;
import rete.BroadcastServer;

public class TestBroadcast {

	public static void main(String[] args) {
		
		
		try {
			Files.deleteIfExists(Paths.get("OtherFilesList.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BroadcastServer s = new BroadcastServer(new File("/home/rant/Scrivania/testD"));
			s.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BroadcastClient c = new BroadcastClient();
		c.start();
		
	}

}