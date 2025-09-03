class OverridingImpl {


public static void main(String[] args) {
	
	Parent p = new Parent();
	p.m1(10);
	
	Child child = new Child();
	child.m1(10);
	
	Parent parent = new Child();
	parent.m1(20);
}

}

class Parent {
	
	public void m1(int... a) {
		System.out.println("Parent method");
	}
}


class Child extends Parent {
	
	public void m1(int... a ) {
		System.out.println("Child method");
	}
}