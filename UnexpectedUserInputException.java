
public class UnexpectedUserInputException extends Exception {
	int num;
	
	public UnexpectedUserInputException(int num) {
		super("Invalid entry " + num);
		this.num = num;
	}
}
