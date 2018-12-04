 	package course;
import java.*;
import java.util.List;

/** 
 *@author written by: Dale Stewart
 * 023567902
 * June 20 2016 
 * 
 * CollegeStudent is a subclass of the Student class */
public class CollegeStudent extends Student implements Cloneable, Runnable {
	
	public double booksPriceTotal = 0.00;
	 /**
	  * @param gName givenName of student
	  * @param sName surName of student
     * @param courses List of courses for student in one semester
     * @param address Address of student
     * @param id Student ID
     * */
	CollegeStudent(String gName, String sName, int id, List<Course> courses, Address address) {
		super(gName, sName, id, courses, address);
	}

    /**Implements run method of Runnable Interface*/
    @Override
    public void run()
    {
       booksPriceTotal += super.BooksPrice(courses);
    }

    /** @return  CollegeStudent object as a string */
	@Override
	public String toString()
	{	
		return "\nCollegeStudent: Total Price of Books = " + booksPriceTotal + super.toString();
	}

	/** @return boolean true/false if object is equals to 'this' object */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) {	return false; }
		
		return true;
	}		

	/** @return a duplicate 'clone' of the current object */
	@Override
	protected Object clone() throws CloneNotSupportedException {
	  return super.clone();
	}

/*	@Override
	public double BooksPrice(List<Course> semesterCourses) {
		courses.getBooksPrice();
		return 0;
	}*/

}
