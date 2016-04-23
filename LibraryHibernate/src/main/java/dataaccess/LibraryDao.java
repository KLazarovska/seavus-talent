package dataaccess;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import domain.Book;

public class LibraryDao {
	SessionFactory sessionFactory;
	
	public LibraryDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public void saveBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	public void listBooks() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Book";
			Query query = session.createQuery(hql);
			List results = query.list();

			for (Iterator iterator = results.iterator(); iterator.hasNext();) {
				Book book = (Book) iterator.next();
				System.out.println("Isbn - " + book.getIsbn() + " | Title - "
						+ book.getTitle());
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	public void updateBook(String isbn, String title) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "UPDATE Book set title = :title WHERE isbn = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("title", title);
			query.setParameter("isbn", isbn);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	public void deleteBook(String isbn) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM Book WHERE isbn = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("isbn", isbn);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
}
