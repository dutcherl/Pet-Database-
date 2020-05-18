// Pet class for encapsulating data to be stored in a Pet Database
public class Pet {

	
	// Class fields
	private String name;
	private int age;
	
	public Pet(String name, int age) {
		
		//Sets the class level fields to the values of the input arguments
		setName(name);
		setAge(age);
		
	}

	//Accessor and Mutator methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// toString override 
	@Override
	public String toString() {
		
		System.out.print(name + " " + age);
		
		return name + " " + age;
		
		
	}
}
