		import People.Person;

import People.Professor;
import People.Staff;
import People.Student;
import People.Talkable;

public class Meeting {

	public static void main(String[] args) {
		Student s1 = new Student("John", "Smith", "CPD", "me@you.ca");
		Student s2 = new Student("Mary", "Brown", "CPA", "you@me.ca");
		Staff staff1 = new Staff("Jim", "Jones", "Counsellor", "this@that.ca");
		Staff staff2 = new Staff("Jose", "Garcia", "Manager", "that@this.ca");
		Professor p1 = new Professor("Jane", "Gold", "T2222", "a@b.ca");
		Professor p2 = new Professor("Lisa", "Trinidad", "T2111", "b@a.ca");
		
		Person[] working = new Person[6];
		working[0] = s1; working[1] = s2;
		working[2] = staff1; working[3] = staff2;
		working[4] = p1; working[5] = p2;
		for(int i=0; i<6; i++) {
			System.out.println(working[i]);
			working[i].doing();
		}

		Talkable[] meeting = new Talkable[6];
		meeting[0] = s1; meeting[1] = s2;
		meeting[2] = staff1; meeting[3] = staff2;
		meeting[4] = p1; meeting[5] = p2;
		
		for(int j=0; j<6; j++) {
			meeting[j].say();
		}
	}

}
