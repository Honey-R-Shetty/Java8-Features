package MethodReference;

import java.util.*;

public class SortByLength {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "kiwi", "banana", "pear");
		list.sort(Comparator.comparingInt(String::length));
		System.out.println(list);
	}
}
