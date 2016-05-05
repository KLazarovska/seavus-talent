package library.service;

import java.util.List;

import library.domain.Book;
import library.domain.Magazine;
import library.domain.Publication;

public interface PublicationServices {
	
	public void save(Publication publication);
	
	public void updateBook(String isbn, String title);

	public void updateMagazine(String issn, String title);
	
	public void deleteBook(String isbn);

	public void deleteMagazine(String issn);
	
	public List<Publication> listPublications();
	
	public List<Book> listBooks();
	
	public List<Magazine> listMagazine();
	
	public void deletePublication(Long id);
}
