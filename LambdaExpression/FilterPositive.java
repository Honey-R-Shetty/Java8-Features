package LambdaExpression;

public class FilterPositive {
	public static void main(String[] args) {
		int arr[] = { -1, 2, -3, 7, 9, 2 };
		for (int i : arr) {
			Runnable run = () -> {
				if (i > 0)
					System.out.println(i);
			};
			run.run();
		}
	}
}
