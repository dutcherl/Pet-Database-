import java.util.Scanner;

public class PetDatabase {

	private static Database<Pet> petDb = new Database<Pet>();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		petDb.addItem(new Pet("Boomer", 15));
		petDb.addItem(new Pet("Milkshake", 4));
		petDb.addItem(new Pet("Millie", 2));
		petDb.addItem(new Pet("Otis", 12));

		int userInput = menu();

		while (userInput != 7) {
			System.out.println("Your choice: " + userInput + "\n");
			switch (userInput) {

			case 1:
				petDb.printDb();
				break;

			case 2:
				String input = addPetDialogue();
				input.trim();
				int count = 0;
				String done = "done";
				while (!input.contentEquals(done)) {

					String[] tokens = input.split(" ");

					petDb.addItem(new Pet(tokens[0], Integer.parseInt(tokens[1])));

					input = addPetDialogue();
					count += 1;

				}

				System.out.println(count + " pets added.");
				break;
				
				

			}
			userInput = menu();
		}
	}


	private static String addPetDialogue() {
		System.out.println("add pet (name, age): ");
		return in.nextLine();

	}

	public static int menu() {

		System.out.println("What would you like to do?");

		return Integer.parseInt(in.nextLine());

	}
	
	
}
