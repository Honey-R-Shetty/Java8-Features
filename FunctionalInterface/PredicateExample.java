package FunctionalInterface;

import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		Predicate<String> check = s -> s.length()>=5;
		System.out.println(check.test("Honey"));
	}
}
