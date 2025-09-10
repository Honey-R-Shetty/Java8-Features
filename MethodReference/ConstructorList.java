package MethodReference;

import java.util.*;

class Student {
	String name;

	Student(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}

public class ConstructorList {
	public static void main(String[] args) {
		String[] names = { "Alice", "Bob", "Charlie" };
		List<Student> students = new ArrayList<>();
		for (String name : names) {
			students.add(new Student(name));
		}
		System.out.println(students);
	}
}
