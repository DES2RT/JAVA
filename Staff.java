package People;

public class Staff extends Person implements Talkable {
	private String title;
	
	public Staff(String f, String l, String t, String e) {
		super(f, l, e);
		this.title = t;
	}
	
	public void setTitle(String t) {
		this.title = t;
	}
	public String getTitle() {
		return title;
	}

	@Override
	public void doing() {
		System.out.println("I am working on staff as a " + title);
	}

	@Override
	public void say() {
		System.out.print("Hello, my name is " + this.getfName() + " " + this.getlName() + ", and ");
		this.doing();		
	}
	
	@Override
	public String toString() {
		return "Staff [ title = " + this.getTitle() + ", toString() = " + super.toString() + " ]";
	}
}
