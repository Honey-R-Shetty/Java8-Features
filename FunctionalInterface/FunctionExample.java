package FunctionalInterface;

import java.util.function.Function;

public class FunctionExample {
	public static void main(String[] args) {
		Function<Integer, String> evenOdd = n -> n % 2==0? "even":"odd";
		System.out.println(evenOdd.apply(6));
	}
}
