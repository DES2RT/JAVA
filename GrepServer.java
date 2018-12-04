
public class GrepServer {

	public GrepServer() {
		try {
			Grep g = new GrepImpl();
			java.rmi.Naming.rebind("Wonderful", g);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[]) {
		new GrepServer();
	}
}
