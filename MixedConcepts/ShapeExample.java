package MixedConcepts;

@FunctionalInterface
interface Shape {
	void draw();
}

public class ShapeExample {
	public static void main(String[] args) {
		Shape circle = () -> System.out.println("Drawing Circle");
		Shape rectangle = () -> System.out.println("Drawing Rectangle");
		circle.draw();
		rectangle.draw();
	}
}
