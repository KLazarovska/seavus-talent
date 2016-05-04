package twitter.dataaccess;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javassist.bytecode.Descriptor.Iterator;
import twitter.domain.Tweets;
import twitter.service.TwitterServices;

@Component
public class TweetDao implements TwitterServices {

	SessionFactory sessionFactory;

	@Autowired
	public TweetDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Tweets tweet) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(tweet);
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

	public void delete(Tweets tweet) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM Tweets WHERE username = :username AND text = :text";
			Query query = session.createQuery(hql);
			query.setParameter("username", tweet.getUsername());
			query.setParameter("text", tweet.getText());
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public void deleteTweet(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM Tweets WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tweets> listTweetsFromUser(String username) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Tweets WHERE username = :username";
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			List<Tweets> results = query.list();

			for (Tweets tweet : results) {
				System.out.println("Username - " + tweet.getUsername() + "\n Tweet - " + tweet.getText() + "\n Date - "
						+ tweet.getDate());
			}
			tx.commit();
			return results;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tweets> listAllTweets() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Tweets";
			Query query = session.createQuery(hql);
			List<Tweets> results = query.list();
			
			for (Tweets tweet : results) {
				System.out.println("Username - " + tweet.getUsername() + " \n  Tweet - " + tweet.getText() + " \n  Date - "
						+ tweet.getDate());
			}
			tx.commit();
			return results;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return null;

	}
	

}
