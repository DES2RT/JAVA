package prac;
// functional interface version, interface is Exam class
public class ExampleTwo {

	  public static String result(Student s, Exam e) {
		    return e.getExamResult(s.name);
		  }

		  public static void main(String[] args) {
		    Student student = new Student("John");
		    Exam exam = s -> {return s + ": Pass";};	// creates interface instance, uses lambda to return
		    System.out.println(result(student, exam));
		  }
}
