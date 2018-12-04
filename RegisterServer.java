//package car;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RegisterServer {
	
	public RegisterServer() {
		try {
			Register regi = new RegisterImpl();
			java.rmi.Naming.rebind("RegisterWithRMI", regi);
			System.out.println("Register With RMI bound to registry");
		} catch(RemoteException re) {
			re.printStackTrace();
		} catch(MalformedURLException murle) {
			murle.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RegisterServer();
		System.out.println("\t*** The Register Server Is Running ***\n");
	}
}
