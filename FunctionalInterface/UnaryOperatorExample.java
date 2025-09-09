package FunctionalInterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
	public static void main(String[] args) {
		UnaryOperator<String> toUpper = name -> name.toUpperCase();
		System.out.println(toUpper.apply("honey"));
	}
}
