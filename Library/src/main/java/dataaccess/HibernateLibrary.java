package dataaccess;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import domain.Book;
import domain.BookHibernate;

public class HibernateLibrary {

	public void registerNewBook(String isbn, String title) throws SQLException{
		SessionFactory sessionFactory = null;
		Session session = sessionFactory .openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			BookHibernate book= new BookHibernate();
			book.setIsbn(isbn);
			book.setTitle(title);
			session.save(book);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx!= null) { tx.rollback(); }
			throw e;
		} finally {
			session.close();
		}
	}

	public void listBooks() throws SQLException {

	}

	public void updateBook(String isbn, String title) throws SQLException {

	}

	public void unregisterBook(String isbn) {

	}
}
