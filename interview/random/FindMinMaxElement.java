class FindMinMaxElement {

	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,6,5};
		
		int max = array[0];
		int min = array[0];
		
	for (int i = 0;i <array.length; i++) {
		if (array[i] > max ) {
			max = array[i];
		} 
		
		if (array[i] < min) {
			min = array[i];
		}
	}
	
	System.out.println(max+" Max "+" and min: "+min);
	}
}