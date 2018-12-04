//package car;

public class RegisterClient  {

	public static void main(String[] args) {
		int count = 8;
		Car car = new Car("Porsche", "mine", 5.5);
		System.out.println(car);
		try {
			Register regi = (Register)java.rmi.Naming.lookup("RegisterWithRMI");
			Car car2 = regi.register(car);
			System.out.println(car2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
