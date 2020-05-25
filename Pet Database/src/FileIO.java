import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO {

	public static void parseFile(File f) {

	};

	// reference code https://www.tutorialspoint.com/java/java_serialization.htm\

	@SuppressWarnings("unchecked")
	public static Database<Item> loadFromFile(String filename) throws IOException {

		ObjectInputStream in = null;
		Database<?> d = null;
		try {

			in = new ObjectInputStream(new FileInputStream(filename));
			d = (Database<?>) in.readObject();

		} catch (IOException e) {

			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {

			System.out.println("Employee class not found!");
			c.printStackTrace();
			return null;
		}

		finally {
			in.close();
			System.out.println("Loaded Successfully!");
		}
		return (Database<Item>) d;

	}

	public static void saveToFile(Database<?> data, String filename) throws IOException {

		ObjectOutputStream out = null;

		try {
			
			out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(data);
			

		}

		finally {
			out.close();
			System.out.println("Successfully saved to file!");
		}

	}

	public static ArrayList<String> listFiles() {
		
		ArrayList<String> fileNames = new ArrayList<String>();
		File dir = new File("./files");
		File [] files = dir.listFiles(new FilenameFilter(){
			
			public boolean accept(File dir, String name) {
				return name.endsWith(".ser");
			}
		});
		
		for(File f : files) {
			
			fileNames.add(f.toString().replace(".\\files\\", ""));
		
		}
		return fileNames;
	}

}
