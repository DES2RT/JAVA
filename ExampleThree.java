package prac;
// lambda expression version
public class ExampleThree {

	  public static String result(Student s, Exam e) {
		    return e.getExamResult(s.name);
		  }
		  
		  public static void main(String[] args) {
		    System.out.println( 
		    	result(new Student("John"),  n -> { return n + ": Pass"; })); // lambda
		  }
}
