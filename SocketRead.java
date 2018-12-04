package prac;
import java.util.*;
import java.io.IOException;
import java.net.*;

public class SocketRead {
	String host = "localhost";
	int port = 8888;
	try {
		ServerSocket s = new ServerSocket(port);
		Socket cs = s.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()))
	} catch (IOException e) {
		System.out.println(e);
	}
}
