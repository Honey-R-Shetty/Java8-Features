package FunctionalInterface;

public class CalculatorMain {
	public static void main(String[] args) {
		
		Calculator substract = (a, b) -> a - b;
		Calculator add = (a, b) -> a + b;
		Calculator multiple = (a, b) -> a * b;
		Calculator divide = (a, b) -> a / b;

		System.out.println(add.calculate(1, 2));
		System.out.println(substract.calculate(3, 1));
		System.out.println(multiple.calculate(1, 3));
		System.out.println(divide.calculate(10, 2));
	}
}
