class LambdaWithThisKeyword {

	int a  = 999;
	
	public void mainClassMethod() {
		
		ThisKeyword it = () -> {
			int a = 888;
			
			System.out.println(this.a);
		};
		it.display();
	}

public static void main(String[] args) {

new LambdaWithThisKeyword().mainClassMethod();
}
}


interface ThisKeyword {
	
	public void display();
}