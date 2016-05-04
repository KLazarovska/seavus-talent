package library.dataaccess;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import library.domain.Publication;
import library.service.PublicationServices;

public class PublicationDao implements PublicationServices{

	SessionFactory sessionFactory;

	public PublicationDao() {
	}

	public PublicationDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void save(Publication publication) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(publication);
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
			String hql = "UPDATE Publication SET title = :title WHERE isbn = :isbn";
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

	public void updateMagazine(String issn, String title) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "UPDATE Publication SET title = :title WHERE issn = :issn";
			Query query = session.createQuery(hql);
			query = session.createQuery(hql);
			query.setParameter("title", title);
			query.setParameter("issn", issn);
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

	public void deleteMagazine(String issn) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM Magazine WHERE issn = :issn";
			Query query = session.createQuery(hql);
			query.setParameter("issn", issn);
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
	
	public void listPublications() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Publication";
			Query query = session.createQuery(hql);
			List publications = query.list();

			for (Iterator iterator = publications.iterator(); iterator
					.hasNext();) {
				Publication publication = (Publication) iterator.next();
				System.out.println("Title - " + publication.getTitle());
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

	public Publication listSinglePublication(String title) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Publication WHERE title = :title";
			Query query = session.createQuery(hql);
			query.setParameter("title", title);
			List<Publication> results = query.list();
			tx.commit();
			return results.get(0);
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
