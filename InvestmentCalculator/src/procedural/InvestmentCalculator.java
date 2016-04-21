package procedural;

public class InvestmentCalculator {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int investment = 14000;
		
		investment = (investment/100) * 40;
		System.out.println("first year - increased by 40%: " + investment);
		investment -= 1500;
		System.out.println("second year - lost 1.500 in value: " + investment);
		investment = (investment/100) * 12;
		System.out.println("third year - increased by 12% " + investment);

	}

}
