import java.io.Serializable;

public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String name;
	protected int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
