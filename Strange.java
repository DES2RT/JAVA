package prac;

public interface Strange {
	
	final String test = "JAC444";
	
	void takeTest();
	
	public static class GenericTest {
		String test;
		
		public GenericTest(String testName) {
			test = testName;	
		}
		
		public void takeTest() {
			System.out.println("Inside GenericTest: " + test);
		}
	}
} 
