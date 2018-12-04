package People;

public class Professor extends Person implements Talkable {
	private String office;
	
	public Professor(String f, String l, String o, String e) {
		super(f, l, e);
		this.office = o;
	}
	
	public void setOffice(String o) {
		this.office = o;
	}
	public String getOffice() {
		return office;
	}
	
	@Override
	public void doing() {
		System.out.println("I am teaching as professor, in office " + office);
	}

	@Override
	public void say() {
		System.out.print("Hello, my name is " + this.getfName() + " " + this.getlName() + ", and ");
		this.doing();
		
	}
	@Override
	public String toString() {
		return "Professor [ office = " + this.getOffice() + " , toString() = " + super.toString() + " ]";
	}
}
