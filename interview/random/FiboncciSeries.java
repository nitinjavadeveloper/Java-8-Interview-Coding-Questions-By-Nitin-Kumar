class FiboncciSeries {
	
	public static void main(String[] args) {
		int a=0, b=1;
		int c;
		
		for (int i =0; i <= 7; i++) {
			System.out.print(a+" ");
			c = a+b;
			a = b;
			b = c;
		}
	}
}