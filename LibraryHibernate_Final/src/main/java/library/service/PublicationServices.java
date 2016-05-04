package library.service;

import library.domain.Publication;

public interface PublicationServices {
	
	public void save(Publication publication);
	
	public void updateBook(String isbn, String title);

	public void updateMagazine(String issn, String title);
	
	public void deleteBook(String isbn);

	public void deleteMagazine(String issn);
	
	public void listPublications();
}
