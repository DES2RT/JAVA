
import java.util.Vector;
import java.io.*;

public class DisplayFileImpl extends java.rmi.server.UnicastRemoteObject
		implements DisplayFile {

	public DisplayFileImpl() throws java.rmi.RemoteException {
		super();
	}

	public Vector display(String s) throws java.rmi.RemoteException,
			FileNotFoundException {

		Vector<String> v = new Vector<String>();
		String line = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(s));

			while ((line = in.readLine()) != null)
				v.add(line);
		} catch (IOException e) {
			System.out.println("IO Exception file:" + s);
			return null;
		}
		return v;
	}
}
