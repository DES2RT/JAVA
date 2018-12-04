//package student;

public class GradeServer {

	public GradeServer() {
		try {
			Grade grade = new GradeImpl();
			java.rmi.Naming.rebind("GradingWithRMI", grade);
			System.out.println("\t*****\tGradingWithRMI object bound to registry\t*****");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new GradeServer();
		System.out.println("\t*****\tGrader Server Is Running \t*****\n");
	}
}
