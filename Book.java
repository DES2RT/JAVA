
public class Book implements Cloneable {
	private String name;
	private int ISBN;
	private  double price;
	
	Book() {
		this.name = "Book1";
		this.ISBN = 0123;
		this.price = 9.99;
	}
	
	Book(String n, int bn, double p) {
		this.name = n;
		this.ISBN = bn;
		this.price = p;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	public String getName() {
		return this.name;
	}
	public void setISBN(int bn) {
		this.ISBN = bn;
	}
	public int getISBN() {
		return this.ISBN;
	}
	public void setPrice(double p) {
		this.price = p;
	}
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return this.getClass() + "[ name = " + this.getName() + ", ISBN = " + this.getISBN() + ", price = " + this.getPrice() +
						" ]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if( !(o instanceof Book) ) return false;
		Book b = (Book)o;
		if(!name.equals(b.name)) return false;
		if(ISBN != b.ISBN) return false;
		if(price != b.price) return false;
		
		return true;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Book)super.clone();
	}
	
	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 99 * result + ISBN;
		result = 99 * result + (int)price;
		return result;
	}
}
