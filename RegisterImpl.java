//package car;

public class RegisterImpl extends java.rmi.server.UnicastRemoteObject implements Register {

	public RegisterImpl() throws java.rmi.RemoteException {
		super();
	}
	
	public Car register(Car c) {
		Integer val = c.hashCode();
		c.getRegistered(val);
		return c;
	}
}
