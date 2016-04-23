package service;

import dataaccess.LibraryDao;
import domain.Book;

public class LibraryServices {
	
	private LibraryDao library;
	
	public LibraryServices(LibraryDao library){
		this.library = library;
	}
	
	public void registerBooks(Book book){
		library.saveBook(book);
	}
	
	public void listRegisteredBooks(){
		library.listBooks();
	}
	
	public void updateRegisteredBook(String isbn, String title){
		library.updateBook(isbn, title);
	}
	
	public void unregisterBook(String isbn){
		library.deleteBook(isbn);
	}
}
