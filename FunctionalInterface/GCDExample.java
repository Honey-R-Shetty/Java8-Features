package FunctionalInterface;

import java.util.function.BiFunction;

public class GCDExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> gcd = (a, b) -> {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        };

        System.out.println("GCD of 12 and 18: " + gcd.apply(12, 18));
    }
}
