//package student;

public class GradeImpl extends java.rmi.server.UnicastRemoteObject implements Grade {
	protected GradeImpl() throws java.rmi.RemoteException {
		super();
	}
	
	public Student grade(Student s) {
		int m = (int)Math.floor(Math.random() * 101);
		s.setMark(m);
		s.getGrade(m);		
		Student student = null;
		try {
			student = (Student) s.clone();
			System.out.println("Student clone \t\t " + student);
		} catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}
		return student;

	}
}
