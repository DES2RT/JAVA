package prac;
public class Pair<F, S> {
	
	private F first;
	private S second;
	
	public Pair(F f, S s) {
		first = f;
		second = s;
	}

	public String toString() {
		return "("+ first + ", " + second + ")";
	}

      public static Pair<> flip(Pair<Integer, String>) /* ? flip method signature ?  */ {
    	  Pair<V, U> flipped = new Pair<V, U>(p.second, p.first);
    	  return flipped;
      }

	public static void main(String[] args) {
		Pair<Integer, String> p = new Pair<>(1, "Test");
		System.out.println(p);
		System.out.println(Pair.flip(p));
	}
} 
