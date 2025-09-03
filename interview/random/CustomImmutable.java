class CustomImmutable {
	
	private final int age;
	private final List<String> name;
	
	private CustomImmutable(int age, List<String> name) {
		this.age= age;
		this.name = new ArrayList<>(roles); // Defensive copy
	}
	
	
	// only getter No need for setter
	
	public static void main(String[] args) {
	
	}
}