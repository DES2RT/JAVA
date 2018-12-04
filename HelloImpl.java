package prac;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

	public HelloImpl() throws RemoteException {
		super();
	}

	public String sayHello(int time) throws RemoteException {

		switch (time) {
		case 1:
			return "Good morning!";
		case 2:
			return "Good afternoon!";
		case 3:
			return "Good evening!";
		default:
			return "Good day!";
		}
	}

}

