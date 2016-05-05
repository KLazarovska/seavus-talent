package library.dataaccess;

import library.domain.Book;
import library.domain.Loan;
import library.domain.Magazine;
import library.domain.Member;
import library.domain.Membership;
import library.domain.Publication;

import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConnection {

	SessionFactory sessionFactory;
	
	@Bean
	public SessionFactory getConnection(){
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
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
	
	@PreDestroy
	public void closeConnection(){
		sessionFactory.close();
	}
	
}
