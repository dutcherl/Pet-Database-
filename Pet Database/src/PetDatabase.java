import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PetDatabase {

	private static Database<Item> petDb = null;
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
//
//		//Default Pets loaded at startup
//		petDb.addItem(new Pet("Boomer", 15));
//		petDb.addItem(new Pet("Chompy", 12));
//		petDb.addItem(new Pet("Milkshake", 4));
//		petDb.addItem(new Pet("Kitty", 8));
//		petDb.addItem(new Pet("Bruno", 3));
//		petDb.addItem(new Pet("Millie", 2));
//		petDb.addItem(new Pet("Fiesty", 16));
//		petDb.addItem(new Pet("Otis", 12));
		
		petDb = loadData();

		int userInput = menu();
		
		//main menu loop
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
		saveData();
		System.out.println("System is now exiting");
	}
	
	private static Database<Item> loadData(){
		
		ArrayList<String> fileNames = FileIO.listFiles();
		
		System.out.println("------------");
		for(String s : fileNames) {
			
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

	//repeatable add pet dialogue 
	private static String addPetDialogue() {
		System.out.println("add pet (name, age): ");
		return in.nextLine();

	}
	// Main menu for the program 
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
