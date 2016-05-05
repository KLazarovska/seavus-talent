package library.dataaccess;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.domain.Loan;
import library.domain.Member;
import library.domain.Publication;
import library.service.LoanServices;

@Component
public class LoanDao implements LoanServices{

	SessionFactory sessionFactory;

	@Autowired
	public LoanDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Loan loan) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(loan);
			
			if (!tx.wasCommitted()){
			    tx.commit();
			}
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Loan> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Loan";
			Query query = session.createQuery(hql);
			List<Loan> loans = query.list();
			tx.commit();
			return loans;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Member findMember(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Member WHERE id = :id";
			Query query = session.createQuery(hql);
			List<Member> member = query.list();
			tx.commit();
			return member.get(0);
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Publication findPublication(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Publication WHERE id = :id";
			Query query = session.createQuery(hql);
			List<Publication> publication = query.list();
			tx.commit();
			return publication.get(0);
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
