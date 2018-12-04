import java.util.Arrays;

public class Course implements Cloneable {
	private String name;
	private int id;
	private String description;
	private Book[] books;
	
	Course() {
		this.name = "John Smith";
		this.id = 123;
		this.description = "if i were to describe it ...";
		//this.books = new Book[] {new Book(), new Book(), new Book() };
	}
	
	Course(String n, int ident, String d, Book[] b) {
		this.name = n;
		this.id = ident;
		this.description =d;
		this.books = b;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	public String getName() {
		return this.name;
	}
	public void setId(int i) {
		this.id = i;
	}
	public int getId() {
		return this.id;
	}
	public void setDescription(String d) {
		this.description = d;
	}
	public String getDescription() {
		return this.description;
	}
	public void setBooks(Book[] b) {
		this.books = b;
	}
/*	public void getBooks() {
		books.toString();
	}*/
	
	@Override
	public String toString() {
		System.out.println(this.getClass() + "[ Name = " + this.getName() + ", ID = " + this.getId() + ", Description = " +
				this.getDescription());
		System.out.print("Books = ");
				for(int i=0; i<books.length; i++) {
					System.out.print(books[i] + " ");
				}
		return "";
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if( !(o instanceof Course) ) return false;
		Course c = (Course) o;
		if(!name.equals(c.name)) return false;
		if(id != c.id) return false;
		if(!description.equals(c.description)) return false;
		if(!Arrays.equals(books, c.books)) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 99 * result + id;
		result = 99 * result + description.hashCode();
		return result;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Course c = (Course)super.clone();
		c.books = (Book[]) books.clone();
		return c;
	}
	
	public static void main(String[] args) {
		System.out.println("starting ...");
		Book[] b = 
				new Book[]{new Book("intro", 654321, 143.99), new Book("inter", 123456, 222.99), 	new Book("advanced", 999999, 1000.99)};
		Course c1 = new Course("C++", 344, "alot more fun", b);
		Course c2 = new Course("ASP", 422, "not so fun", b);
		Course c3 = new Course("Java", 444, "alotta fun", b);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
