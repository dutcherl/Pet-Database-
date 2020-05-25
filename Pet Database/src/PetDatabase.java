import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PetDatabase {

	private static Database<Item> petDb = null;
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		petDb = loadData();

		int userInput = menu();

		// main menu loop
		while (userInput != 7) {
			System.out.println("Your choice: " + userInput + "\n");
			String input = "";
			String targetId = "";
			// menu items controlled via switch statement
			switch (userInput) {

			case 1:
				petDb.printDb();
				break;

			case 2:
				if (!(petDb.size() >= 5)) {
					input = addPetDialogue();
					input.trim();
					int count = 0;
					String done = "done";
					while (!input.contentEquals(done) && petDb.size() < 5) {

						String[] tokens = input.split(" ");
						try {
							validateUserInput(tokens);
						} catch (InvalidAgeException e1) {
							e1.printStackTrace();
						} catch (TooManyArgumentsException e1) {
							e1.printStackTrace();
						}

						try {
							petDb.addItem(new Pet(tokens[0], Integer.parseInt(tokens[1])));

						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DatabaseOverflowException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						if (petDb.size() < 5) {
							input = addPetDialogue();

						}
						count += 1;

					}

					System.out.println(count + " pets added.");
				} else {
					System.out.println("Cannot add pet to an already full DB!");
				}
				break;

			case 3:

				System.out.println("Enter the pet ID you want to update: ");
				targetId = in.nextLine();
				if (!(Integer.parseInt(targetId) <= petDb.size() - 1))
					throw new IndexOutOfBoundsException("Cannot have an ID greater than size of array!");
				System.out.println("Enter the new name and new age: ");
				String updatedCredentials = in.nextLine();

				try {
					petDb.update(targetId, updatedCredentials);
				} catch (InvalidPetIdException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 4:

				System.out.println("Enter the pet ID you want to remove: ");
				targetId = in.nextLine();

				try {
					petDb.remove(targetId);
				} catch (InvalidPetIdException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 5:
				System.out.println("Enter a name to search:");
				input = in.nextLine();
				input.trim();
				petDb.searchForByName(input);
				System.out.println();
				break;

			case 6:
				System.out.println("Enter age to search:");
				input = in.nextLine();
				input.trim();
				petDb.searchForByAge(input);
				break;

			}
			userInput = menu();
		}
		saveData();
		System.out.println("System is now exiting");
	}

	private static void validateUserInput(String[] tokens) throws InvalidAgeException, TooManyArgumentsException {

		String name = tokens[0];

		int age = Integer.parseInt(tokens[1]);

		if (tokens.length > 2) {
			throw new TooManyArgumentsException();
		}

		else if (!(age >= 0 && age <= 20)) {

			throw new InvalidAgeException("Age should be between 0 and 20 years!");
		}

	}

	private static Database<Item> loadData() {

		ArrayList<String> fileNames = FileIO.listFiles();

		System.out.println("------------");
		for (String s : fileNames) {

			System.out.println(s);
		}
		System.out.println("------------");

		System.out.println("Enter the file name to load: ");
		String fileName = in.nextLine();
		fileName = fileName.replaceAll(".ser", "");
		StringBuilder s = new StringBuilder(fileName);
		s.append(".ser");
		try {
			return FileIO.loadFromFile(".\\files\\" + s);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			return FileIO.loadFromFile("default");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private static void saveData() {

		System.out.println("Enter the file name to save: ");
		String input = in.nextLine();

		StringBuilder fileName = new StringBuilder(".\\files\\" + input + ".ser");

		try {
			FileIO.saveToFile(petDb, fileName.toString());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// repeatable add pet dialogue
	private static String addPetDialogue() {
		System.out.println("add pet (name, age): ");
		return in.nextLine();

	}

	// Main menu for the program
	public static int menu() {

		System.out.println("What would you like to do?");

		if (petDb.size() < 5) {
			System.out.println(" 1) View all pets \n " + "2) Add more pets \n " + "3) Update an existing pet \n "
					+ "4) Remove an existing pet \n " + "5) Search pets by name \n " + "6) Search pets by age \n "
					+ "7) Exit program");

		}

		else {
			System.out
					.println(" 1) View all pets \n " + "3) Update an existing pet \n " + "4) Remove an existing pet \n "
							+ "5) Search pets by name \n " + "6) Search pets by age \n " + "7) Exit program");

		}
		return Integer.parseInt(in.nextLine());

	}

}
