package prac;

public class SpecialString {

	public boolean same(char ch1, char ch2) {
		return (ch1 == ch2) ? true : false;
	}

	public boolean special(String s) {
		int len = s.length();
		char token = 0;
		MyStack stack = new MyStack(len);
		for (int i = 0; i < len; i++) {
			token = s.charAt(i);
			if (token != ' ')
				stack.push(new Character(token));

		}
		for (int j = 0; j < len; j++) {
			token = s.charAt(j);
			if (token != ' ')
				if (!same((Character) (stack.pop()), s.charAt(j)))
					return false;
		}
		return (stack.isEmpty()) ? true : false;
	}

	public String reverse(String original) {
		String reverse = "";
		int length = original.length();

		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);
		return reverse;
	}

	public static void main(String[] a) {
		SpecialString s = new SpecialString();		
		System.out.println( s.special(a[0]) ? s.reverse(a[0]) : null );				
	}
}


