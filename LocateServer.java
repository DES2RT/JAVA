package files;
import java.rmi.Naming;

public class LocateServer {

	public static void main(String[] args) {
		
		try {
			Locate obj = new LocateImpl();
			Naming.rebind("rmi://localhost:1099/Locate", obj);
			System.out.println("Locate instance object bound to registry");
		} catch(Exception e) {
			System.out.println("LocateServer error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
