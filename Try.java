package prac;

public class Try {

	public static void main(String[] args) {
		
		new Strange() {		
			public void takeTest() {
				new GenericTest(test + " is difficult" ).takeTest();				
			}		
		}.takeTest();
	}
}
