package prac;

public class SimpleThread extends Thread {
	 public SimpleThread(String str) {
	 super(str);
	 }
	 public void run() {
	 for (int i = 0; i < 3; i++) {
	 System.out.println(i + " " + getName());
	 try {
	 Thread.sleep((long)(Math.random() * 1000));
	 } catch (InterruptedException e) {}
	 }
	 System.out.println("DONE! " + getName());
	 }
	 public static void main (String[] args) {
	 new SimpleThread("First >>>>>>>>>").start();
	 new SimpleThread("Second <<<<<<<<<").start();
	 System.out.println("DONE ALL!");
	 }
	}