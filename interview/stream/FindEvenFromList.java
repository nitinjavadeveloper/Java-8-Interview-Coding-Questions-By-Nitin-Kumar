// Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
import java.util.*;


class FindEvenFromList {

	public static void main(String[] args) {
		
	/* 	List<Integer> numberList = Arrays.asList(10,15,8,49,25,98,32).stream()
		.filter(even -> even %2 == 0).toList(); */
/* 		
		// if we need sorting in assending order 
		
			List<Integer> numberList = Arrays.asList(10,15,8,49,25,98,32).stream()
		.filter(even -> even %2 == 0).sorted().toList(); */
		
				
		// if we need sorting in descending order 
		
			List<Integer> numberList = Arrays.asList(10,15,8,49,25,98,32).stream()
		.filter(even -> even %2 == 0).sorted(Comparator.reverseOrder()).toList();
		numberList.forEach(System.out::println);
	}
}