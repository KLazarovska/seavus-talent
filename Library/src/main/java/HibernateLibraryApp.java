

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import presentation.RunLibrary;

import domain.Book;
import service.LibraryServices;
import dataaccess.LibraryDao;

public class HibernateLibraryApp {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Book.class).buildSessionFactory(serviceRegistry);
		
		RunLibrary library = new RunLibrary(new LibraryServices(new LibraryDao()),sessionFactory);
		library.run();
		
		
		sessionFactory.close();
	}

}
