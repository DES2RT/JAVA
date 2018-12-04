package prac;

public class Extended extends Base {
	public String s = "Extended";
	public void show() {
		System.out.println("class field " + s + "\n");
	}
	
	public static void main(String[] args) {
		Extended e = new Extended();
		Base b = e;
		
		System.out.print("b.show() ----->");
		b.show();
		System.out.print("e.show(); ----->");
		e.show();
		System.out.println("b.s -----> " + b.s);
		System.out.println("e.s -----> " + e.s);
	}

}
