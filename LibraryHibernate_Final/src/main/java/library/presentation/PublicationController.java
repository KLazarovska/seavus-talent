package library.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import library.domain.Book;
import library.domain.Magazine;
import library.domain.Publication;
import library.service.PublicationServices;

public class PublicationController implements Controller {

	PublicationServices service;

	public PublicationController(PublicationServices service){
		this.service = service;
	}
	
	public void run() {
		Scanner in = new Scanner(System.in);
		boolean end = false;

		while (!end) {
			printMenu();
			
			try{
				int input = in.nextInt();

				switch (input) {
					case 1:
						System.out.println("Enter book ISBN:");
						String isbn = in.next();
						System.out.println("Enter book title:");
						String titleBook = in.next();
						Publication publicationBook = new Book(isbn, titleBook);
						service.save(publicationBook);
						break;
					case 2:
						System.out.println("Enter magazine ISSN:");
						String issn = in.next();
						System.out.println("Enter magazine title:");
						String titleMagazine = in.next();
						Publication publicationMagazine = new Magazine(issn, titleMagazine);
						service.save(publicationMagazine);
						break;
					case 3:
						System.out.println("Enter the ISBN of the book you want to update:");
						isbn = in.next();
						System.out.println("Enter the new title for the book:");
						titleBook = in.next();
						service.updateBook(isbn, titleBook);
						break;
					case 4:
						System.out.println("Enter the ISSN of the magazine you want to update:");
						issn = in.next();
						System.out.println("Enter the new title for the magazine:");
						titleMagazine = in.next();
						service.updateMagazine(issn, titleMagazine);
						break;
					case 5:
						System.out.println("Enter the ISBN of the book you want to unregister:");
						isbn = in.next();
						service.deleteBook(isbn);
						break;
					case 6:
						System.out.println("Enter the ISSN of the magazine you want to unregister:");
						issn = in.next();
						service.deleteMagazine(issn);
						break;
					case 7:
						service.listPublications();
						break;
					case 8:
						System.out.println("END!");
						end = true;
						break;
					default:
						System.out.println("The input is not valid!");
						break;
				}
			}catch(InputMismatchException e){
				System.out.println("Invalid input");
				break;
			}
			
		}
	}

	public void printMenu() {
		System.out.println("1. New book");
		System.out.println("2. New magazine");
		System.out.println("3. Update book");
		System.out.println("4. Update magazine");
		System.out.println("5. Delete book");
		System.out.println("6. Delete magazine");
		System.out.println("7. List publications");
		System.out.println("8. Exit!");
	}

}
