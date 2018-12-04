package files;
/** @author AnnStAcc2
 *  this Locate.java file contains the interface Locate to be implemented in the LocateImpl.java 
 *  file. The method receives a request from the Client, LocateClient.java asking for the contents
 *  of a file. The Client passes a parameter of type String, the name of the file, used to search 
 *  the server.
 */
import java.io.*;

public interface Locate extends java.rmi.Remote {
		/** receives String parameter and searches server for file */
//		File locateFile(File file) throws java.rmi.RemoteException;
		public java.util.Vector<E> display(String fileName) 
				throws java.rmi.RemoteException, java.io.FileNotFoundException;
}
