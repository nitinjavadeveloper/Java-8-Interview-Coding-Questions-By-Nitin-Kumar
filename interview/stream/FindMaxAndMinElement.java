// Given a list of integers, find the maximum value element present in it using Stream functions?

import java.util.*;


class FindMaxAndMinElement {

	public static void main(String[] args) {
		
		 Integer maxElement = Arrays.asList(10,15,8,49,25,98,32)
        .stream()
            .max(Integer::compare).get();

		Integer minElement = Arrays.asList(10,15,8,49,25,98,32)
        .stream()
        .min(Integer::compare).get();



    System.out.println(maxElement);

    System.out.println(minElement);
	}
}