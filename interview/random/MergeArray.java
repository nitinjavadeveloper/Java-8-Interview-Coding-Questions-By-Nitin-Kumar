import java.util.*;

class MergeArray {
	
	public static void main(String[] args) {
	int[] a = {1,2};
	int[] b = {3,4,5};
	int[] mergeArray = new int[a.length+b.length];
	
	    System.arraycopy(a,0,mergeArray,0,a.length);
    System.arraycopy(b,0,mergeArray,a.length,b.length);
	
	System.out.println(Arrays.toString(mergeArray));
	}
}