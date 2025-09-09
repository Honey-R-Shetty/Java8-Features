package FunctionalInterface;

import java.util.UUID;
import java.util.function.Supplier;

public class SupplierExample {
	public static void main(String[] args) {
		Supplier<String> uuidSupplier = () -> UUID.randomUUID().toString();
		System.out.println("Random UUID: " + uuidSupplier.get());
	}
}
