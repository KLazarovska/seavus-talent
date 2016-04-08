
public class Numbers {

	static int convertNumbers(String number){
		
		switch(number){
			case "zero":
				return 0;
			case "one":
				return 1;
			case "two":
				return 2;
			case "three":
				return 3;
			case "four":
				return 4;
			case "five":
				return 5;
			case "six":
				return 6;
			case "seven":
				return 7;
			case "eight":
				return 8;
			case "nine":
				return 9;
		}
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int i = 0;
		while (i < args.length){
			System.out.print(convertNumbers(args[i]));
			i++;
		}

	}

}
