package LambdaExpression;

public class EventHandling {
	interface ButtonClick {
		void onClick();
	}

	public static void main(String[] args) {
		ButtonClick click = () -> System.out.println("Button clicked!");
		click.onClick();
	}
}
