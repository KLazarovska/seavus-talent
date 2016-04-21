import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dataaccess.Library;
import domain.BookHibernate;
import presentation.RunLibrary;
import service.LibraryFunctions;

public class Main {

	public static void main(String[] args) {
		
//		Configuration configuration= new Configuration();
//		ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		SessionFactory sessionFactory = configuration.addAnnotatedClass(BookHibernate.class).buildSessionFactory(serviceRegistry);

		RunLibrary library = new RunLibrary(new LibraryFunctions(new Library()));
		library.run();
		
//		sessionFactory.close();
	}

}
