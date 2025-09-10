package LambdaExpression;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskExample {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {	
			@Override
			public void run() {
				System.out.println("Task Executed!");
			}
		}, 0, 2000);
	}
}
