
public class Pet extends Item{

	
	

	
	public Pet(String name, int age) {
		
		
		setName(name);
		setAge(age);
		
	}

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
	
	
	
	
}
