package course;

public class Book implements Cloneable {
	String name;
	String isbn;
	double price;
	
	/** no argument constructor sets values to null or zero */
	Book() {
		this.name = null;
		this.isbn = null;
		this.price = 00.00;
	}
	
	/** 3 argument constructor set values to parameters passed in */
	Book(String n, String bn, double p) {
		name = n;
		isbn = bn;
		price = p;
	}
	
    /*public getters and setters*/

	/** @return Book name*/
	public String getName() {
		return name;
	}

	/** set book name 
	 * @param name: Book name */
	public void setName(String name) {
		this.name = name;
	}

	/** @return Book's ISBN number*/
	public String getISBN() {
		return isbn;
	}

	/** set Book's ISBN number 
	 * @param name: ISBN */
	public void setISBN(String ISBN) {
		isbn = ISBN;
	}

	/** @return price of book*/
	public double getBookPrice() {
		return price;
	}

	/** set price of book 
	 * @param name: Book Price*/
	public void setBookPrice(double price) {
		this.price = price;
	}
	
	/** @return Book object as string */
	@Override
	public String toString() {
		return name + " " + isbn + " $" + price;
	}
	
	/** @return boolean true/false depending on objects are the same */
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
	
	/** @return duplicate ;clone' of current object */
	@Override
	protected Object clone() throws CloneNotSupportedException {
	  return super.clone();
	}
}
