package service;

import org.hibernate.SessionFactory;

import dataaccess.LibraryDao;
import domain.Book;

public class LibraryServices {
	
	private LibraryDao library;
	
	public LibraryServices(LibraryDao library){
		this.library = library;
	}
	
	public void registerBooks(Book book, SessionFactory session){
		library.saveBook(book, session);
	}
	
	public void listRegisteredBooks(SessionFactory session){
		library.listBooks(session);
	}
	
	public void updateRegisteredBook(String isbn, String title, SessionFactory session){
		library.updateBook(isbn, title, session);
	}
	
	public void unregisterBook(String isbn, SessionFactory session){
		library.deleteBook(isbn, session);
	}
}
