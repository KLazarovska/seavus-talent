package OOP;

public class DateParser {

	/**
	 * @param args
	 */
	public static void dateParser(String birthday){
		String date[] = birthday.split("/");
		
		System.out.println("Birthday - " + birthday);
		System.out.println("Day: " + date[0]);
		System.out.println("Month: " + date[1]);
		System.out.println("Year: " + date[2]);
	}
	
	public static void main(String[] args) {
		String birthday = "04/05/1991";
		
		dateParser(birthday);
		
	}

}
