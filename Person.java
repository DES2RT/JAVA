package People;

public abstract class Person {
	private String fName;
	private String lName;
	private String email;
	
	Person(String f, String l, String e) {
		this.fName = f;
		this.lName = l;
		this.email = e;
	}
	
	public void setfName(String f) {
		this.fName = f;
	}
	public String getfName() {
		return this.fName;
	}
	public void setlName(String l) {
		this.lName = l;
	}
	public String getlName() {
		return this.lName;
	}
	public void setEmail(String e) {
		this.email = e;
	}
	public String getEmail() {
		return this.email;
	}
	public String toString() {
		return "Person [ firstName = " + this.getfName() + ", lastName = " + this.getlName() + 
				", email = " + this.getEmail() + " ] ";
	}
	public abstract void doing();
}
