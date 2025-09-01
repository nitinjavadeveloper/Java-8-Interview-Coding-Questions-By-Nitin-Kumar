import java.util.*;


// Given a String, find the first non-repeated character in it using Stream functions?

class NonRepeatCharacter {

public static void main(String[] args) {
String input = "Java articles are Awesome";
String non_repeated = "";

Character character  = input.chars().mapToObj(ch -> (char)ch)
	.filter (c -> input.indexOf(c) == input.lastIndexOf(c))
	.findFirst().orElse(null);
	
	System.out.println(character);
}

}