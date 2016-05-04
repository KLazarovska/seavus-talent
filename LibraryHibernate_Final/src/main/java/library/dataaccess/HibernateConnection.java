package library.dataaccess;

import library.domain.Book;
import library.domain.Loan;
import library.domain.Magazine;
import library.domain.Member;
import library.domain.Membership;
import library.domain.Publication;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConnection {

	SessionFactory sessionFactory;
	
	public SessionFactory getConnection(){
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Magazine.class)
				.addAnnotatedClass(Loan.class).addAnnotatedClass(Member.class)
				.addAnnotatedClass(Membership.class)
				.addAnnotatedClass(Publication.class)
				.buildSessionFactory(serviceRegistry);

		return sessionFactory;
	}
	
	public void closeConnection(){
		sessionFactory.close();
	}
	
}
