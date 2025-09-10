package MethodReference;

import java.util.*;

class Printer {
	public void printMessage(String msg) {
		System.out.println(msg);
	}
}

public class InstanceMethodReference {
	public static void main(String[] args) {
		Printer printer = new Printer();
		List<String> messages = Arrays.asList("Hello", "World", "Java");
		messages.forEach(printer::printMessage);
	}
}
