
public class StrangeBank {
	
	private String currency;
	
	public StrangeBank() {
		currency = null;
	}
	
	public synchronized void deposit(String s) throws InterruptedException {
		show("In deposit: BEGINNING");
		
		while(currency != null) {
			show("In deposit before wait()");
			wait();
			show("In deposit after wait()");
		}
		
		currency = s;
		show("In deposit before notifyAll()");
		notifyAll();
		show("In deposit after notifyAll()");
		
		show("In deposit END");
	}
	
	public synchronized String withdraw() throws InterruptedException {
		
		show("In withdraw BEGINNING");
		
		while(currency == null) {
			show("In withdraw before wait()");
			wait();
			show("In withdraw after wait()");
		}
		
		String s2 = currency;
		currency = null;
		
		show("In withdraw before notifyAll()");
		notifyAll();
		show("In withdraw after notifyAll()");
		
		show("In withdraw END");
		return s2;
	}
	
	private static void show(String description) {
		String t = Thread.currentThread().getName();
		System.out.println(t + " : " + description);
	}
}
