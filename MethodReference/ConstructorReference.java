package MethodReference;

import java.util.function.BiFunction;

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + ", " + age;
	}
}

public class ConstructorReference {
	public static void main(String[] args) {
		BiFunction<String, Integer, Person> personFactory = Person::new;
		Person p = personFactory.apply("John", 30);
		System.out.println(p);
	}
}
