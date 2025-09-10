package MixedConcepts;

@FunctionalInterface
interface MessagePrinter {
	void print(String msg);
}

class StaticPrinter {
	public static void printStatic(String msg) {
		System.out.println("Static: " + msg);
	}
}

class InstancePrinter {
	public void printInstance(String msg) {
		System.out.println("Instance: " + msg);
	}
}

public class MixedMessagePrinter {
	public static void main(String[] args) {
		// Lambda
		MessagePrinter lambdaPrinter = msg -> System.out.println("Lambda: " + msg);
		lambdaPrinter.print("Hello Lambda");

		// Static method reference
		MessagePrinter staticPrinter = StaticPrinter::printStatic;
		staticPrinter.print("Hello Static");

		// Instance method reference
		InstancePrinter instancePrinterObj = new InstancePrinter();
		MessagePrinter instancePrinter = instancePrinterObj::printInstance;
		instancePrinter.print("Hello Instance");
	}
}
