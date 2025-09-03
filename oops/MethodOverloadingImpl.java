class MethodOverloadingImpl {
	
	public void m1(int a) {
		System.out.println("int argument");
	}
	
	public void m1(float f) {
		System.out.println("float argument");
	}
	
	
	public void m1(String a) {
		System.out.println("String argument");
	}
	
	public void m1(Object f) {
		System.out.println("Object argument");
	}
	public void m1(StringBuffer f) {
		System.out.println("String Buffer argument");
	}

	public static void main(String[] args) {
	
		MethodOverloadingImpl methods = new MethodOverloadingImpl();
		/* methods.m1(10);
		methods.m1(10.5f);
		methods.m1('a');
		methods.m1(10l); */
		
		methods.m1(new Object());
		methods.m1("test");
		methods.m1(null);
	}
}