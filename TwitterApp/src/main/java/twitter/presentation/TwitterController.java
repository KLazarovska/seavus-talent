package twitter.presentation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter.domain.Tweets;
import twitter.service.TwitterServices;

@Component
public class TwitterController {

	TwitterServices service;

	@Autowired
	public TwitterController(TwitterServices service) {
		this.service = service;
	}

	public void run() {
		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		boolean end = false;

		while (!end) {
			printMenu();
			int input = in.nextInt();
			
			try {
				if (input == 1) {
					System.out.println("Enter username: ");
					String username = in.next();
					System.out.println("Enter tweet: ");
					String text = in.next();
					Tweets tweet = new Tweets(username, text);
					tweet.setDate(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE).toString());
					service.save(tweet);
				} else if (input == 2) {
					System.out.println("Enter username: ");
					String username = in.next();
					System.out.println("Enter tweet: ");
					String text = in.next();
					Tweets tweet = new Tweets(username, text);
					service.delete(tweet);
				} else if (input == 3) {
					System.out.println("Enter username: ");
					String username = in.next();
					service.listTweetsFromUser(username);
				} else if (input == 4) {
					service.listAllTweets();
				} else if (input == 5) {
					end = true;
					System.out.println("END!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input!");
			}
		}
	}

	public void printMenu() {
		System.out.println("Enter your choice: ");
		System.out.println("1. Write new tweet");
		System.out.println("2. Delete a tweet");
		System.out.println("3. List tweets from chosen user");
		System.out.println("4. List all tweets");
		System.out.println("5. Exit!");
	}
}
