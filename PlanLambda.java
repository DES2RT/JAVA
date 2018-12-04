package prac;

public class PlanLambda<T> {

	public T[] plan;

	public void forEach(Action<T> action) {
		for (T t : plan)
			action.change(t);
	}
	
	
	public String toString() {
		String result = "";
		for (T t : plan)
			result += " Point = " + t.toString();
		return result;
	}
	
	public static void main(String[] args) {
		PlanLambda<Point> play = new PlanLambda<>();

		play.plan = new Point[] { new Point(0, 0), new Point(1, 1) };
		
		// lambda expression; this will be taught in the next lecture
	    play.forEach(p -> p.move(10, 10));
		
		System.out.println(play);
	}
}
