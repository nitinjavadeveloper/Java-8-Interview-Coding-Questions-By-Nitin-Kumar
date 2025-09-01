//Given a list of integers, find out all the numbers starting with 1 using Stream functions?

import java.util.*;


class NumberStartingWith1 {

	public static void main(String[] args) {
	
	List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32)
							.stream()
							.filter(number -> String.valueOf(number).startsWith("1")).toList();
							
							myList.forEach(System.out::println);
	
	}
}