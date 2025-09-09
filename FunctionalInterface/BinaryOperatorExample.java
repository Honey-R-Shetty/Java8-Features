package FunctionalInterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
	public static void main(String[] args) {
		BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
		System.out.println("Maximum : " + max.apply(2, 7));
	}
}
