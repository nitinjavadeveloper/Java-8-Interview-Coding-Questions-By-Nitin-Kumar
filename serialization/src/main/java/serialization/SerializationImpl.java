package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;


public class SerializationImpl {

  public static void main(String[] args) {
    Employee employee = new Employee.EmployeeBuilder()
        .name("John Doe")
        .age(30)
        .number("1234567890")
        .build();

    try {
      serializationProcess(employee,"serialization-file");

      deserializationProcess(employee,"serialization-file");
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }

  // serialization

  private static void serializationProcess(Employee employee, String fileName)
      throws IOException {
    FileOutputStream fos = new FileOutputStream(fileName);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(employee);
  }

  private static void deserializationProcess(Employee employee, String fileName)
      throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream(fileName);
    ObjectInputStream ois = new ObjectInputStream(fis);
   Employee emp = (Employee) ois.readObject();
   printEmployee(emp);
  }

  private static void printEmployee(Employee emp) {
    System.out.println(emp);
  }
}

// Corrected Employee class with static Builder and implements Serializable
class Employee implements Serializable {
  private String name;
  private int age;
  private String number;

  private Employee(EmployeeBuilder builder) {
    this.name = builder.name;
    this.age = builder.age;
    this.number = builder.number;
  }

  // Static inner Builder class
  public static class EmployeeBuilder {
    private String name;
    private int age;
    private String number;

    public EmployeeBuilder name(String name) {
      this.name = name;
      return this;
    }

    public EmployeeBuilder age(int age) {
      this.age = age;
      return this;
    }

    public EmployeeBuilder number(String number) {
      this.number = number;
      return this;
    }

    public Employee build() {
      return new Employee(this);
    }
  }

  @Override
  public String toString() {
    return "Employee{name='" + name + "', age=" + age + ", number='" + number + "'}";
  }
}
