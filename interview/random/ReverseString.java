//How to reverse a String in java? Can you write a program without using any java inbuilt methods?
import java.util.*;
import java.util.stream.Collectors;

class ReverseString {

	public static void main(String[] args) {
		//System.out.println(reverseLoop("Hello"));
		System.out.println(reverseStringUsingLambda("Hello"));
	}
	
	public static String reverseLoop(String str) {
		
		String reverse = "";
		
		for (int i = str.length()-1 ; i >= 0; i--) {
			reverse += str.charAt(i);
		} 
		
		return reverse;
	}
	
	public static String reversStringRecursion(String str) {
		
		if (str.isEmpty()) {
			return "";
		}
		
		return reversStringRecursion(str.substring(1))+ str.charAt(0);
	}
	
	  public static String reverseStringUsingLambda(String str) {
          return Arrays.stream(str.split("")).sorted(Comparator.reverseOrder())
		       .collect(Collectors.joining());
  }
}