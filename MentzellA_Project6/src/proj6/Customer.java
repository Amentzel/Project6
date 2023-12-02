package proj6;

public class Customer {
	private int age;
	private String name;
	
	public Customer(String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	public Customer(Customer copy) {
		age = copy.age;
		name  = copy.name;
	}
	
	public String toString() {
		return ("Customer Name: " + name + ". Age: " + age);
	}
	
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(int input) {
		age = input;
	}
	public void setName(String input) {
		name = input;
	}
	
}
