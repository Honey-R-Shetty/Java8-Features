package MethodReference;

import java.util.function.Function;

public class ParseIntExample {
	public static void main(String[] args) {
		Function<String, Integer> parseInt = Integer::parseInt;
		System.out.println(parseInt.apply("123"));
		System.out.println(parseInt.apply("456"));
	}
}
