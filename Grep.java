
public interface Grep
      extends java.rmi.Remote {
	
  public java.util.Vector find(String file, String s)
    throws java.rmi.RemoteException, java.io.FileNotFoundException;
}
