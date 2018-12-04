package prac;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer {

	public static void main(String args[]) {

		// Create the object implementation

		try {
			Hello obj = new HelloImpl();
			// Bind this object instance to the name "HelloServer"
			Naming.rebind("rmi://localhost:1099/HelloServer", obj);
			System.out.println("HelloServer bound in registry");
			
		} catch (Exception e) {
			System.out.println("HelloServer err: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

