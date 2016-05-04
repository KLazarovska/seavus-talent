package library.presentation;

import library.domain.Member;
import library.domain.Membership;
import library.service.MemberServices;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberController implements Controller {

	MemberServices service;

	public MemberController(MemberServices service) {
		this.service = service;
	}

	public void run() {
		Scanner in = new Scanner(System.in);
		boolean end = false;

		while (!end) {
			printMenu();
			
			try{
				int input = in.nextInt();

				if (input == 1) {
					System.out.println("Enter members name: ");
					String name = in.next();
					System.out.println("Enter members email: ");
					String email = in.next();

					Member member = new Member(name, email);
					service.save(member);

					Membership membership = new Membership(member, "standard",
							ZonedDateTime.now().format(
									DateTimeFormatter.ISO_LOCAL_DATE),
							ZonedDateTime.now().plusYears(1L)
									.format(DateTimeFormatter.ISO_LOCAL_DATE));
					service.saveMembership(membership);
				} else if (input == 2) {
					System.out.println("Enter members name: ");
					String name = in.next();
					System.out.println("Enter members email: ");
					String email = in.next();
					service.update(name, email);
				} else if (input == 3) {
					service.listMembers();
				} else if (input == 4) {
					service.listMemberships();
				} else if (input == 5) {
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
		System.out.println("1. Save member");
		System.out.println("2. Update member");
		System.out.println("3. List members");
		System.out.println("4. List memberships");
		System.out.println("5. Exit");
	}

}
