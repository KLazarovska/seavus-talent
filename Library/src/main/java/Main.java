import dataaccess.Library;
import presentation.RunLibrary;
import service.LibraryFunctions;

public class Main {

	public static void main(String[] args) {
		RunLibrary library = new RunLibrary(new LibraryFunctions(new Library()));
		library.run();
	}

}
