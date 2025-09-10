package LambdaExpression;

import java.util.Arrays;
import java.util.List;

public class EmployeeMain {
	public static void main(String[] args) {
		List<Employee> employee = Arrays.asList(
				new Employee(3,"Honey"),
				new Employee(2,"Jayath"),
				new Employee(1,"Mani")
				);
		employee.sort((e1 ,e2)-> Integer.compare(e1.getId(),e2.getId()));
		System.out.println(employee);
	}
}
