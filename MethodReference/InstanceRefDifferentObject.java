package MethodReference;

import java.util.function.BiFunction;

class Calculator {
	public int multiply(int a, int b) {
		return a * b;
	}
}

public class InstanceRefDifferentObject {
	public static void main(String[] args) {
		Calculator calculation = new Calculator();
		BiFunction<Integer, Integer, Integer> multiplier = calculation::multiply;
		System.out.println("Product: " + multiplier.apply(4, 5));
	}
}
