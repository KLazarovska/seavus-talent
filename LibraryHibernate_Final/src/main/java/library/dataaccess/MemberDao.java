package library.dataaccess;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import library.domain.Member;
import library.domain.Membership;
import library.service.MemberServices;


public class MemberDao implements MemberServices {

	SessionFactory sessionFactory;

	public MemberDao(){}
	
	public MemberDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Member member) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(member);
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

	public void update(String name, String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "UPDATE Member SET email = :email WHERE name = :name";
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			query.setParameter("email", email);
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

	
	public Member listSingleMember(String name){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Member WHERE name = :name";
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			List<Member> results = query.list();
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
	
	public void listMembers(){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Member";
			Query query = session.createQuery(hql);
			List results = query.list();

			for (Iterator iterator = results.iterator(); iterator.hasNext();) {
				Member member = (Member) iterator.next();
				System.out.println("Name - " + member.getName() + " | Email - " + member.getEmail());
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
	
	public void saveMembership(Membership membership){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(membership);
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
	
	public void listMemberships(){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Membership";
			Query query = session.createQuery(hql);
			List results = query.list();

			for (Iterator iterator = results.iterator(); iterator.hasNext();) {
				Membership membership = (Membership) iterator.next();
				System.out.println("Member - "
						+ membership.getMember().getName() + " | start date - "
						+ membership.getStartDate() + " | end date - "
						+ membership.getEndDate() + " | membership type - "
						+ membership.getMembershipType());
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
