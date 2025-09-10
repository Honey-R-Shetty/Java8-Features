package LambdaExpression;

public class LambdaRunnable {
	public static void main(String[] args) {
		Runnable run = () -> System.out.println("Hello from Lambda Runnable!");
		Thread thread = new Thread(run);
		thread.start();
	}
}
