package prac;
import java.util.*;

public class InputMismatchExceptionDemo {

		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			boolean continueInput = true;
			
			do {
				try {
					System.out.print("Enter an integer: ");
					int num = input.nextInt();
					System.out.println("The number input is: " + num);
					continueInput = false;
				} catch (InputMismatchException e) {
					 System.out.println("Incorrect input value, try again ");
					 input.nextLine();
				}
			} while (continueInput);
		}
}
