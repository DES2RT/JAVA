
public class TestUncheckedExceptions  { 
	
    public static void test(int num) throws UnexpectedUserInputException {
        int x = 10;
        int[] ia1 = null, ia2 = new int[2];
        if(num != 0 && num != 1 && num != 2) {
        	throw new UnexpectedUserInputException(num);
        }
        else {
        	if (num == 0) {
            	  throw new ArithmeticException("Cannot divide by zero");
                    
              } else if (num == 1) {
                    x = ia1.length;
              } else if (num == 2) {
                    x = ia2[2];
              } else {
                    x = num;
              }
        }
  }
    
    public static void main(String[] args) {
        System.out.println("Please enter 0, 1, 2 or any other number: ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        try {
        	test(sc.nextInt());
        } catch (UnexpectedUserInputException e) {
        	System.out.println(e);
        } catch (ArithmeticException ae) {
        	System.out.println(ae);
        } finally {
        	System.out.println("try again");
        }
  }
}
