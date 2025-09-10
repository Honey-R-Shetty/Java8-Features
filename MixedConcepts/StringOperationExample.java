package MixedConcepts;

@FunctionalInterface
interface StringOperation {
	String apply(String s);
}

public class StringOperationExample {
	public static void main(String[] args) {
		// Lambda: reverse
		StringOperation reverse = s -> new StringBuilder(s).reverse().toString();
		System.out.println("Reverse: " + reverse.apply("Hello"));

		// Method reference: toUpperCase
		StringOperation toUpper = String::toUpperCase;
		System.out.println("Uppercase: " + toUpper.apply("hello"));
	}
}
