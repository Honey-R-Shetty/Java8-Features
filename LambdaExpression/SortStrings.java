package LambdaExpression;

import java.util.Arrays;
import java.util.List;

public class SortStrings {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Grapes","Apple","Banana");
		list.sort((s1,s2)-> s2.compareToIgnoreCase(s1));
		System.out.println(list);
	}
}
