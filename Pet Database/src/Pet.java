public class Pet extends Item{
// Pet class for encapsulating data to be stored in a Pet Database
	public Pet(String name, int age) {
		
		//Sets the class level fields to the values of the input arguments
		setName(name);
		setAge(age);
		
	}

	//getter and setter methods
	public String getName() {
		return super.name;
	}

	public void setName(String name) {
		super.name = name;
	}

	public int getAge() {
		return super.age;
	}

	public void setAge(int age) {
		super.age = age;
	}
	
	// toString override 
	@Override
	public String toString() {
		
		System.out.print(name + " " + age);
		
		return name + " " + age;
		
		
	}
}
