//package car;

public interface Register extends java.rmi.Remote {
	public Car register(Car c) throws java.rmi.RemoteException;
}
