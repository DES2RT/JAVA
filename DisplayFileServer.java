
public class DisplayFileServer {

	public DisplayFileServer() {
		try {
			DisplayFile df = new DisplayFileImpl();
			java.rmi.Naming.rebind("FileRMIServer", df);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[]) {
		new DisplayFileServer();
	}
}
