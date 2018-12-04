package prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Predicate<T> {
  boolean test(T t);
}
class MoreStudent {
	String name;
	int age;
	MoreStudent(String n, int a) {
		this.name = n;
		this.age = a;
	}
	@Override
	public String toString() {
		return "my name is " + name + " i am " + age + " years old";
	}
}
public class ExerciseOne {

  public static <T> List<T> filter(List<T> ls, Predicate<T> p) {
    List<T> result = new ArrayList<>(0);
    for (T t : ls)
      if (p.test(t))
        result.add(t);
    return result;
  }

  public static void main(String[] args) {
    List<String> listofStrings = Arrays.asList("first", "second", "third");
    List<String> sol = filter(listofStrings, s -> (s.length() % 2 == 0 && s.contains("s")));
    System.out.println(sol);
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> myints = filter(integers, i -> (i % 2 == 0));
    System.out.println(myints);
    MoreStudent s1 = new MoreStudent("John", 20);
    MoreStudent s2 = new MoreStudent("Jane", 18);
    List<MoreStudent> studs = Arrays.asList(s1, s2);
    List<MoreStudent> mystuds = filter(studs, s -> (s.name.charAt(0) == 'J' && s.age < 20));
    System.out.println(mystuds);
    
  }
}

