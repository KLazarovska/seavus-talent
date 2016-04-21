package presentation;

import java.sql.SQLException;
import java.util.Scanner;

import domain.Book;

import service.LibraryServices;

public class RunLibrary {
	LibraryServices functions;
	
	public RunLibrary(LibraryServices functions){
		this.functions = functions;
	}
	
	public void run(){
		Scanner in = new Scanner(System.in);
		boolean end = false;
		
		while(!end){
			printMenu();
			int input = in.nextInt();
			
			if(input == 1){
				try {
					System.out.println("Enter book ISBN:");
					String isbn = in.next();
					System.out.println("Enter book title:");
					String title = in.next();
					Book book = new Book(isbn, title);
					functions.registerBooks(book);
					end = false;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else if(input == 2){
				try {
					functions.listRegisteredBooks();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				end = false;
			}
			else if(input == 3){		
				try {
					System.out.println("Enter the ISBN of the book you want to update:");
					String isbn = in.next();
					System.out.println("Enter the new title for the book:");
					String title = in.next();
					functions.updateRegisteredBook(isbn, title);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				end = false;
			}
			else if(input == 4){
				
				try {
					System.out.println("Enter the ISBN of the book you want to unregister:");
					String isbn = in.next();
					functions.unregisterBook(isbn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				end = false;
			}
			else if(input == 5){
				end = true;
				System.out.println("END");
			}
		}
	}
	
	public void printMenu(){
		System.out.println("Enter your choice");
		System.out.println("1. Register book");
		System.out.println("2. List all registered books");
		System.out.println("3. Update registered book");
		System.out.println("4. Unregister registered book");
		System.out.println("5. Exit");
	}
}
