package LambdaExpression;

import java.util.function.Function;

public class MathOperations {
	public static void main(String[] args) {
		Function<Integer, Integer> square = n -> n * n;
		Function<Integer, Integer> cube = n -> n * n * n;
		Function<Integer, Integer> factorial = n -> {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result *= i;
			}
			return result;
		};

		int num = 5;
		System.out.println("Square: " + square.apply(num));
		System.out.println("Cube: " + cube.apply(num));
		System.out.println("Factorial: " + factorial.apply(num));
	}
}
