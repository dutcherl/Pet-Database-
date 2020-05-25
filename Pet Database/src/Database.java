import java.util.ArrayList;

public class Database<T extends Item> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<T> dbList = new ArrayList<T>();

	public void addItem(T item) throws DatabaseOverflowException {

		if (dbList.size() < 5) {
			dbList.add(item);
		} else {
			throw (new DatabaseOverflowException("Cannot exceed more than 5 entries in the database!"));
		}
	}
	// Adds an item to the database list

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

	// prints out the content of the database list provided
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

	// Searches for elements in database by name
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

	// Searches for elements in database by age
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
	// Updates an element of the database with new credentials provided by the user
	public void update(String targetId, String updateCredentials) throws InvalidPetIdException {

		String[] tokens = updateCredentials.split(" ");
		String name = tokens[0];
		int age = Integer.parseInt(tokens[1]);
		try {
			T elem = dbList.get(Integer.parseInt(targetId));

			dbList.set(Integer.parseInt(targetId), (T) new Pet(name, age));

			System.out.println(elem.getName() + " " + elem.getAge() + " changed to " + updateCredentials);
		} catch (Exception e) {

			throw new InvalidPetIdException("Invalid Pet id provided");
		}
	}

	// removes the target element from the database
	public void remove(String targetId) throws InvalidPetIdException {
		try {
		T elem = dbList.get(Integer.parseInt(targetId));
		
			dbList.remove(Integer.parseInt(targetId));
		
		System.out.println(elem.getName() + " " + elem.getAge() + " was removed");
		}
		 catch (Exception e) {
				throw new InvalidPetIdException("Invalid Pet Id provided");
			}
	}

	public int size() {

		return dbList.size();

	}
	
	
}
