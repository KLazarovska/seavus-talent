package library.presentation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.dataaccess.HibernateConnection;
import library.dataaccess.MemberDao;
import library.dataaccess.PublicationDao;
import library.domain.Loan;
import library.domain.Member;
import library.domain.Publication;
import library.service.LoanServices;

@Component
public class LoanController implements Controller {

	LoanServices service;
	SessionFactory session;

	@Autowired
	public LoanController(LoanServices service) {
		this.service = service;
		session = new HibernateConnection().getConnection();
	}

	public void run() {

		Scanner in = new Scanner(System.in);
		boolean end = false;

		while (!end) {
			printMenu();
			
			try{
				int input = in.nextInt();

				if (input == 1) {
					System.out.println("Loan publication: (enter title)");
					String title = in.next();
					System.out.println("Members name: ");
					String name = in.next();

					PublicationDao publicationDao = new PublicationDao(session);
					Publication publication = publicationDao
							.listSinglePublication(title);

					MemberDao memberDao = new MemberDao(session);
					Member member = memberDao.listSingleMember(name);

					Loan loan = new Loan(member, publication, ZonedDateTime.now()
							.format(DateTimeFormatter.ISO_LOCAL_DATE),
							ZonedDateTime.now().plusMonths(5L)
									.format(DateTimeFormatter.ISO_LOCAL_DATE));
					service.save(loan);
				} else if (input == 2) {
					service.list();
				} else if (input == 3) {
					end = true;
					System.out.println("END!");
				}
			}catch(InputMismatchException e){
				System.out.println("Incorrect input!");
				return;
			}
		}
	}

	public void printMenu() {
		System.out.println("Enter your choice");
		System.out.println("1. Save loan");
		System.out.println("2. List loans");
		System.out.println("3. Exit");
	}

}
