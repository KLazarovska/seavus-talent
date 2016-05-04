package twitter.dataaccess;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

import twitter.domain.Tweets;

@Configuration
public class HibernateSessionConnection {

	SessionFactory sessionFactory;
	
	@Bean
	public SessionFactory getConnection(){
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Tweets.class)
				.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
	}
	
	@PreDestroy
	public void closeConnection(){
		sessionFactory.close();
	}
}
