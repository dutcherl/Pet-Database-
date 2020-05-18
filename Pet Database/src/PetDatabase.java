import java.util.Scanner;

public class PetDatabase {

	private static Database<Pet> petDb = new Database<Pet>();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		petDb.addItem(new Pet("Boomer", 15));
		petDb.addItem(new Pet("Chompy", 12));
		petDb.addItem(new Pet("Milkshake", 4));
		petDb.addItem(new Pet("Kitty", 8));
		petDb.addItem(new Pet("Bruno", 3));
		petDb.addItem(new Pet("Millie", 2));
		petDb.addItem(new Pet("Fiesty", 16));
		petDb.addItem(new Pet("Otis", 12));
		

		int userInput = menu();

		while (userInput != 7) {
			System.out.println("Your choice: " + userInput + "\n");
			String input = "";
			String targetId = "";
			switch (userInput) {

			case 1:
				petDb.printDb();
				break;

			case 2:
			    input = addPetDialogue();
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
		
			case 3:
				
				System.out.println("Enter the pet ID you want to update: ");
				targetId = in.nextLine();
				System.out.println("Enter the new name and new age: ");
				String updatedCredentials = in.nextLine();
				petDb.update(targetId, updatedCredentials);
				break;
				
			case 4:
				
				System.out.println("Enter the pet ID you want to remove: ");
				targetId = in.nextLine();
				
				petDb.remove(targetId);
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
	}


	private static String addPetDialogue() {
		System.out.println("add pet (name, age): ");
		return in.nextLine();

	}

	public static int menu() {

		System.out.println("What would you like to do?");
		
		System.out.println(" 1) View all pets \n "
				+ "2) Add more pets \n "
				+ "3) Update an existing pet \n "
				+ "4) Remove an existing pet \n "
				+ "5) Search pets by name \n "
				+ "6) Search pets by age \n "
				+ "7) Exit program");
		

		return Integer.parseInt(in.nextLine());

	}
}
