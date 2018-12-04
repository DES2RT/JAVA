//package student;

public interface Grade extends java.rmi.Remote {
	public Student grade(Student s) throws java.rmi.RemoteException;
}
