/** Course class hold the values of the course to be taken by a student
 * 
 * @author written by: Dale Stewart
 */
package course;

public class Course implements Cloneable {
	// variable sets the maximum number of books allowed in one course 
	public final int bMAX = 3;
	// name of the course
	String name;
	// course id
	String id;
	// description of course
	String description;
	// array of books for one course
	Book[] books = new Book[bMAX];
	// price of book
	double bookPrice;
	
	/** no argument constructor sets values to null */
	Course() {
		this.name = null;
		this.id = null;
		this.description = null;
		this.books = null;
	}
	
	/** 4 arguments constructor sets values to those passed in */
	Course(String id, String n, String desc, Book[] b) {
		this.id = id;
		name = n;
		description = desc;
		books = b;
	}
	
    /* public getters and setters */

    /** @return course name */
    public String getName() {
        return name;
    }
    
    /** set the course name 
     * @param name: Course name */
    public void setName(String name) {
        this.name = name;
    }
    
    /** @return course ID*/
    public String getId() {
        return id;
    }
    
    /** sets ID of the course 
     * @param name: Course ID */
    public void setId(String id) {
        this.id = id;
    }
    
    /** @return course description*/
    public String getDescription() {
        return description;
    }
    
    /** sets course description
     * @param name: Course description  */
    public void setDescription(String desc) {
        description = desc;
    }
    
    /** @return list of books for course*/
    public Book[] getBooks() {
        return books;
    }
    
    /** sets list of books for the course
     * @param name: Course books */
    public void setBooks(Book[] books) {
        this.books = books;
    }
    
    /** @return total cost of books for course*/
    public double getBookPrice() {
    	int length = books.length;

    	for(int i=0; i<length; i++) {
    		 bookPrice += books[i].getBookPrice();
    	}
    	return bookPrice;
    }
    
    /** calculate the total price of books for course and sets bookPrice
     * @return price of books 
     * */
    public void setBookPrice()
    {
        for (Book b : books)
        {
            bookPrice += b.getBookPrice();
        }
    }
    
    /** @return Course object as string */
	@Override
	public String toString() {
		System.out.println(id + ": " + name + "\n \t" + description + "\n Books required:");
				for(int i=0; i<bMAX; i++) {
					System.out.println(books[i].toString());
				}
				return "";
	}
	
	/** @return boolean true/false dependant on both object being equal */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	/** @return a duplicate 'clone' of the current object */
	@Override
	protected Object clone() throws CloneNotSupportedException {
	  return super.clone();
	}
}
