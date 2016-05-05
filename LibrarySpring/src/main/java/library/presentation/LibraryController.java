package library.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryController implements Controller {

	PublicationController publicationController;
	MemberController memberController;
	LoanController loanController;

	@Autowired
	public LibraryController(PublicationController publicationController,
			MemberController memberController, LoanController loanController) {
		this.publicationController = publicationController;
		this.memberController = memberController;
		this.loanController = loanController;
	}

	public void run() {
		Scanner in = new Scanner(System.in);
		boolean end = false;

		while (!end) {
			printMenu();
			try {
				int input = in.nextInt();

				if (input == 1) {
					publicationController.run();
				} else if (input == 2) {
					memberController.run();
				} else if (input == 3) {
					loanController.run();
				} else if (input == 4) {
					end = true;
					System.out.println("END!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Incorrect input!");
				return;
			}
		}
	}

	public void printMenu() {
		System.out.println("Enter your choice");
		System.out.println("1. Manage publications");
		System.out.println("2. Manage members");
		System.out.println("3. Manage loans");
		System.out.println("4. Exit");
	}
}
