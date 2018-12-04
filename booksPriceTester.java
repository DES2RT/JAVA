package course;
import java.util.*;

public class booksPriceTester {

	public static void main(String[] args) {

		// create the books for the books array the college student requires for one course
		Book[] books = new Book[3];
		books[0] = new Book("Java Programming", "0-13-376131-2", 139.99);
		books[1] = new Book("Data Communications", "0-23-754612-1", 119.99);
		books[2] = new Book("ASP.NET", "0-33-951246-8", 79.99);

        List<Course> courses = new ArrayList<Course>();
        
        //adding courses to collection
        courses.add( new Course
        		("JAC444", "Intro to Java", "Introduction to Java Programming", books) );
        courses.add( new Course
        		("INT422", "ASP.NET", "Programming ASP.NET Applications", books));
        courses.add( new Course
        		("DCN455","Data Communications and Networks", "How Computers and Networks communicate", books));
        courses.add( new Course
        		("DSA555", "Data Structures and Algorithms", "Programming Data Structures and Algorithms efficiently", books));
        courses.add( new Course
        		("SYS466", "Requirements gathering using OOP principles", "How to gather requirements and model objects", books));
        courses.add( new Course
        		("INT322","Web Programming Using PHP", "Introduction to web programming using PHP", books));

        //System.out.println("testing courses class");
        //System.out.println(courses.toString());
        
        Student.Address address = new Student.Address(100, "The Pond Rd.", "Toronto", "ON", "M3M3M3");
		
		// create a new college student
		CollegeStudent one = new CollegeStudent("jimmy", "smith", 123456789, courses, address);
		
        //creating task
        Runnable calc = one;
        // creating thread
        Thread th = new Thread(calc);
        th.start();

         System.out.println("testing total book price for college student one");
        double bookPrice = one.booksPriceTotal;
        if(bookPrice != 0)
        	System.out.format("books price = %.2f\n", bookPrice);
     
        
        System.out.println(one.toString());
	}

}
