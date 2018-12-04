package files;
/** @author ScotchMob
 * This LocateImpl.java file implements the Locate interface thus forcing the method locateFile(String file)
 * this file searches the server for the file and if found reads its contents and writes to the client.
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

public class LocateImpl extends java.rmi.server.UnicastRemoteObject implements Locate {

	protected LocateImpl() throws RemoteException {
		super();
	}

	public File locateFile(String file) throws RemoteException {
		/** @param: file from server, asked for by the client */
		File fromServer = null;
		/** @param: file being sent to the client */
		File toClient = null;
		
		try {
			
			Thread thread = new fileHandler(fromServer, toClient);
			
			fromServer = new File(file);
			FileReader read = new FileReader(fromServer);
			toClient = new File(file);
			FileWriter write = new FileWriter(toClient);
			
		} catch(IOException ioe) {
			System.out.println("LocateFile error: " + ioe.getMessage());
			ioe.printStackTrace();
		} catch(Exception e) {
			System.out.println("RemoteException error: " + e.getMessage());
			e.printStackTrace();
		}
		return toClient;
	}
	
	public static class fileHandler extends Thread {
		static File fromServer = null;
		static File toClient = null;
		
		protected fileHandler(File in, File out) {
			fileHandler.fromServer = in;
			fileHandler.toClient = out;
		}

		public void run() {
			
			try {
				FileReader read = new FileReader(fromServer);
				FileWriter write = new FileWriter(toClient);
				int k = 0;
				while((k = read.read()) != -1) {
					write.write(k)
				}
			} catch(Exception e) {
				System.out.println("Error: " + e.getMessage());
				e.printStackTrace(s);
		}
	
	}
}
