package prac;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.io.*;

public class HelloClient {

	// "obj" is the identifier that we'll use to refer
	// to the remote object that implements the "Hello"
	// interface
	Hello obj = null;

	public String action(int i) {
		String m = null;
		try {
			obj = (Hello) Naming.lookup("rmi://localhost/HelloServer");
			m = obj.sayHello(i);
		} catch (Exception e) {
			System.out.println("HelloApplet exception: " + e);
		}
		return m;
	}

	public static void main(String[] args) throws IOException {
		int k = 0;
		HelloClient hc = new HelloClient();
		while ((k = System.in.read()) != -1)
			if (k != 13 && k != 10) {
				if ((k -= 48) == 0)
					break;
				System.out.println(" Server: " + hc.action(k));
			}
	}
}

