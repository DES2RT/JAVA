//package student;

public class GradeClient {

	public static void main(String[] args) {
		Student student = new Student("Chuck", 5678);
		Student s2 = new Student("Jane", 9951);
		System.out.println(student);
		System.out.println(s2);
		try {
			Grade grade = (Grade)java.rmi.Naming.lookup("rmi://localhost:1099/GradingWithRMI");
			Student stud2 = grade.grade(student);
			Student stud3 = grade.grade(s2);
			System.out.println(stud2);
			System.out.println(stud3);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
