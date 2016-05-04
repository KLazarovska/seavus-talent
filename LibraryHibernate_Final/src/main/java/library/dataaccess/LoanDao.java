package library.dataaccess;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import library.domain.Loan;
import library.service.LoanServices;

public class LoanDao implements LoanServices{

	SessionFactory sessionFactory;

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

	public void list() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Loan";
			Query query = session.createQuery(hql);
			List<Loan> loans = query.list();

			for (Iterator iterator = loans.iterator(); iterator.hasNext();) {
				Loan loan = (Loan) iterator.next();
				System.out.println("Member - " + loan.getMember().getName()
						+ " " + loan.getMember().getEmail()
						+ " | Publication - " + loan.getPublication().getTitle()
						+ " | Start date - " + loan.getStartDate()
						+ " | End date - " + loan.getEndDate());
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

}
