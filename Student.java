import java.io.Serializable;

//package student;

public class Student implements Serializable, Cloneable {
	private String name;
	private int number;
	private int mark;
	private char grade;
	
	Student(String n, int num) {
		this.name = n;
		this.number = num;
		this.mark = 0;
		this.grade = ' ';
	}
	public void setName(String n) {
		this.name = n;
	}
	public String getName() {
		return this.name;
	}
	public void setNumber(int num) {
		this.number = num;
	}
	public int getNumber() {
		return this.number;
	}
	public void setMark(int m) {
		this.mark = m;
		System.out.println("Set mark = to " + this.mark);
	}
	public int getMark() {
		return this.mark;
	}
	public void setGrade(char g) {
		this.grade = g;
	}
	public char getGrade(int mark) {
		char g = ' ';
		if(mark<50) g = 'F';
		if(mark>50 && mark<60) g = 'D';	
		if(mark>60 && mark<70) g = 'C';	
		if(mark>70 && mark<80) g = 'B';	
		if(mark>80 && mark<=100) g = 'A';	
		System.out.println("Grade is: " + g);
		return g;
	}
	@Override
	public String toString() {
		String string;
		string = String.format("%s : Name: %s, Number: %d, Mark: %d, Grade: %c", 
				this.getClass(), this.getName(), this.getNumber(), this.getMark(), this.getGrade(this.getMark()));
		return string;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Student)) return false;
		Student s = (Student) obj;
		if(name != s.name) return false;
		if(number != s.number) return false;
		if(mark != s.mark) return false;
		if(grade != s.grade) return false;
		
		return true;
	}
	@Override
	public int hashCode() {
		int value = name.hashCode();
		value = 88 * value + name.hashCode();
		return value;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
