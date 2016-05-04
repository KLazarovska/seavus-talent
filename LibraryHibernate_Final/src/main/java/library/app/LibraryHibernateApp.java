package library.app;

import library.dataaccess.HibernateConnection;
import library.dataaccess.LoanDao;
import library.dataaccess.MemberDao;
import library.dataaccess.PublicationDao;
import library.presentation.LibraryController;
import library.presentation.LoanController;
import library.presentation.MemberController;
import library.presentation.PublicationController;
import library.service.LoanServices;
import library.service.MemberServices;
import library.service.PublicationServices;
import org.hibernate.SessionFactory;

public class LibraryHibernateApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new HibernateConnection()
				.getConnection();
		
		LibraryController controller = new LibraryController(
				new PublicationController(new PublicationDao(sessionFactory)),
				new MemberController(new MemberDao(sessionFactory)),
				new LoanController(new LoanDao(sessionFactory)));
		
		controller.run();
		sessionFactory.close();
	}

}
