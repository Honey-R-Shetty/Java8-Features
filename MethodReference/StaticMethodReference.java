package MethodReference;

import java.util.function.Predicate;

public class StaticMethodReference{
    public static void main(String[] args) {
        Predicate<Integer> isEven = NumberUtils::isEven;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(7));
    }
}