//  How to find duplicate elements in a given integers list in java using Stream functions?

import java.util.*;

class FindDuplicateElement {

	public static void main(String[] args) {
	
		Set<Integer> duplicateElement = new HashSet<Integer>();
		
		 Arrays.asList(10,15,8,49,25,98,98,32,15,10)
			.stream().filter(element -> !duplicateElement.add(element)).forEach(System.out::println);
			
			
	}
}