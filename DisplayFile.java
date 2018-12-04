

public interface DisplayFile extends java.rmi.Remote {
	public java.util.Vector display(String fileName)
			throws java.rmi.RemoteException, java.io.FileNotFoundException;
}
