import java.util.ArrayList;

public class Database<T extends Pet> {

	private ArrayList<T> dbList = new ArrayList<T>();

	public void addItem(T item) {

		dbList.add(item);

	}

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

}
