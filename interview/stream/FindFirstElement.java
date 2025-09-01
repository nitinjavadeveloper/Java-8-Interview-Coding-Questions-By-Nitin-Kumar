import java.util.*;


class FindFirstElement {
	
	public static void main(String[] args) {
	 /* Optional<Integer> findElement  = Arrays.asList(10,15,8,49,25,98,98,32,15).stream().findFirst();
		System.out.println(findElement.get()); */
		Arrays.asList(10,15,8,49,25,98,98,32,15).stream().findFirst().ifPresent(System.out::println);
	}
}