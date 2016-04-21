package service;

import java.sql.SQLException;

import dataaccess.LibraryDao;
import domain.Book;

public class LibraryServices {
	private LibraryDao library;
	
	public LibraryServices(LibraryDao library){
		this.library = library;
	}
	
	public void registerBooks(Book book) throws SQLException{
		library.registerBook(book);
	}
	
	public void listRegisteredBooks() throws SQLException{
		library.listBooks();
	}
	
	public void updateRegisteredBook(String isbn, String title) throws SQLException{
		library.updateBook(isbn, title);
	}
	
	public void unregisterBook(String isbn) throws SQLException{
		library.unregisterBook(isbn);
	}
}
