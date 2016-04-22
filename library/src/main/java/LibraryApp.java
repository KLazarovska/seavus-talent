import dataaccess.LibraryDao;
import presentation.RunLibrary;
import service.LibraryServices;

public class LibraryApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunLibrary library = new RunLibrary(new LibraryServices(new LibraryDao()));
		library.run();
	}

}
