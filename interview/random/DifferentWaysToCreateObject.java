import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.io.*;
import java.lang.reflect.Constructor;


class DifferentWaysToCreateObject {

	public static void main(String[] args) throws Exception{
		
		Employee emp1 = new Employee("John", 101);
        emp1.displayEmployee();
		
/* 
		
		try {
      Employee emp2 = (Employee) Class.forName("Employee").getDeclaredConstructor().newInstance();
	  System.out.println(emp2);
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
	 */	
	 
	 Employee original = new Employee("Alice", 102);
Employee emp3 = (Employee) original.clone();
emp3.displayEmployee();

// Serialize
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("emp.ser"));
out.writeObject(new Employee("Bob", 103));
out.close();

// Deserialize
ObjectInputStream in = new ObjectInputStream(new FileInputStream("emp.ser"));
Employee emp4 = (Employee) in.readObject();
emp4.displayEmployee();


Constructor<Employee> constructor = Employee.class.getConstructor(String.class, int.class);
Employee emp5 = constructor.newInstance("Charlie", 104);
emp5.displayEmployee();


	}
}


class Employee implements Cloneable, Serializable {
	
	private String name;
    private int id;
	
	public Employee(String name, int id) {
		this.name  = name;
		this.id = id;
		
	}
	
	public void displayEmployee() {
		System.out.println("Name: "+name+"\n"+" Id: "+id);
	}
	
	@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }
}