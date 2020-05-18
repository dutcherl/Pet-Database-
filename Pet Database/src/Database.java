import java.util.ArrayList;
// Database class manages storing, retrieving, updating, and remove elements
public class Database<T extends Pet> {

	private ArrayList<T> dbList = new ArrayList<T>();
	// Adds an item to the database list
	public void addItem(T item) {

		dbList.add(item);

	}
	// Prints out the contents of the database
	public void printDb() {

		String lineSeparator = "+-----------------------------+";

		System.out.println(lineSeparator);
		System.out.printf("| %-3s | %-15s | %-3s %n", "ID", "NAME", "AGE");
		System.out.println(lineSeparator);

		for (T e : dbList) {
			System.out.printf("| %-3s | %-15s | %-3s | %n", dbList.indexOf(e), e.getName(), e.getAge());

		}
		System.out.println(lineSeparator);
	}
	 //Pritns out the content of the database list provided
	public void printDb(ArrayList<T> list) {

		String lineSeparator = "+-----------------------------+";

		System.out.println(lineSeparator);
		System.out.printf("| %-3s | %-15s | %-3s %n", "ID", "NAME", "AGE");
		System.out.println(lineSeparator);

		for (T e : list) {
			System.out.printf("| %-3s | %-15s | %-3s | %n", dbList.indexOf(e), e.getName(), e.getAge());

		}
		System.out.println(lineSeparator);
	}
	//Searches for elements in database by name
	public void searchForByName(String search) {

		ArrayList<T> found = new ArrayList<T>();
		String str = search.toString();

		str = str.toLowerCase();

		for (T e : dbList) {

			if (e.getName().toLowerCase().equals(str)) {

				found.add(e);
			}
		}
			
		printDb(found);
	}
	//Searches for elements in database by age
	public void searchForByAge(String search) {

		ArrayList<T> found = new ArrayList<T>();
		String str = search.toString();

		str = str.toLowerCase();

		for (T e : dbList) {

			if (String.valueOf(e.getAge()).equals(str)) {

				found.add(e);
			}
		}
		
		printDb(found);
	}
	
	@SuppressWarnings("unchecked")
	// Updates an element of the database with new credenitals provided by the user
	public void update(String targetId, String updateCredentials){
	
		String[] tokens = updateCredentials.split(" ");
		String name = tokens[0];
		int age = Integer.parseInt(tokens[1]);
		T elem = dbList.get(Integer.parseInt(targetId));
		
		
		dbList.set(Integer.parseInt(targetId), (T) new Pet(name, age));
		
		System.out.println(elem.getName() + " " + elem.getAge() + " changed to " + updateCredentials);
		
		
	}

	//removes the target element from the database
	public void remove(String targetId) {
		T elem = dbList.get(Integer.parseInt(targetId));		
		dbList.remove(Integer.parseInt(targetId));
		System.out.println(elem.getName() + " " + elem.getAge() + " was removed");
	}

}
