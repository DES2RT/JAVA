package prac;

	public class Boy implements Person {
		public String male = "im a boy";
		public void me() {
			System.out.println("im a boy");
		}
		
		public static void main(String[] args) {
			Person p = new Boy();
			Boy b = new Boy();
			Person m = b;
			m.me();
			p.me();
			//System.out.println(m);
		}
	
}
