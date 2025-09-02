import java.util.stream.*;
import java.util.function.*;

import java.util.*;

class ArraySortingImpl {
	
	public static void main(String[] args) {
		int[] array = {3,1,2,5,4};
		displayArray(array);
		System.out.println("After Sorting");
		assendingSortingUsingLoop(array);
		
		System.out.println("After Descending ");
		soringUsingLambda(array);
	}
	
	private static void displayArray(int[] array) {
		for (int i =0;i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void assendingSortingUsingLoop(int[] array) {
		
	for (int i = 0;i< array.length;i++) {
		for (int j = i +1; j < array.length; j++) {
			if (array[i] > array[j]) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
	}
	displayArray(array);
	}
	
	public static void dessendingSortingUsingLoop(int[] array) {
		
	for (int i = 0;i< array.length;i++) {
		for (int j = i +1; j < array.length; j++) {
			if (array[i] < array[j]) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
	}
	displayArray(array);
	}
	
	public static void soringUsingLambda(int[] array) {
		   Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    
	}
}