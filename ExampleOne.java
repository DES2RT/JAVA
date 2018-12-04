package prac;
// anonymous class version
public class ExampleOne {
	  public static String result(Student s, Exam e) {
	    return e.getExamResult(s.name);
	  }

	  public static void main(String[] args) {
	    System.out.println(result(new Student("John"), new Exam() { 	// anonymous class
	      public String getExamResult(String name) {
	        return name + ": Pass";
	      }		// end of anonymous class
	    }));
	  }
}
