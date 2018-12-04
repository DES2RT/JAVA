package prac;

public class Outer {

	private int x;
	private int y;

	class Inner {
		protected int x;

		public Inner(int x) {
			this.x = x;
		}
	}

	public Outer(int x, int z, int y) {
		this.y = y;
		x = z;
	}

	private Outer(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {
		Outer outer = new Outer(1, 2);
		Outer.Inner inner = new Outer(10, 20).new Inner(30);
		System.out.println(outer.x);
		System.out.println(inner.x);
		System.out.println(outer.y);
		System.out.println(outer.x + inner.x + outer.y);
	}
}
