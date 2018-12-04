package prac;

public class Question1 {
	

	interface GenericOperator<T> {
		T operate(T... operands);
	}

	public static void main(String[] args) {

		// lambda expression
		GenericOperator<Integer> sum = numbers -> {

			Integer total = 0;
			for (Integer x : numbers)
				total = total + x;
			return total;

		};

		System.out.println("Addition result: " + sum.operate(1, 2, 3, 4, 5));
	}
}
