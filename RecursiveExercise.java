package prac;

public class RecursiveExercise {

	public static String printReverse(int n) {
		StringBuffer result = new StringBuffer();

		if (n <= 0) {
			result.append("0" );
			return result.toString();
		}
		else {
			result.append(n + ", ");
			result.append(printReverse(n-1));
		}
		return result.toString();
	}

	/**	
		Calculate n at the p power, 
		using recursive function to perform exponentiation,
		assuming p >= 0, where n and p are integer 
		
	*/

	public static int exponentialValue(int n, int p) {
		if (p == 0)
			return 1;
		if (p == 1)
			return n;
		if(p < 0)
			p *= -1;
		return n  * exponentialValue(n, p - 1);
	}



	public static String binaryValue(int n) {
		
		StringBuffer s = new StringBuffer();
		
		if (n > 0) {
			s.append(binaryValue(n / 2));			
			s.append(n % 2);			
		}
		return s.toString();	
	}

	public static void main(String[] args) {
		System.out.println(printReverse(10));
		System.out.println(exponentialValue(5, -4));
		System.out.println(binaryValue(8));
	}

}
