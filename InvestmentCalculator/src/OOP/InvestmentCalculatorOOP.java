package OOP;

public class InvestmentCalculatorOOP {

	/**
	 * @param args
	 */

	public static int investment = 14000;
	
	public static int calculateInvestment(int investment, int percent, int value){
		if(percent != 0){
			investment = (investment / 100) * percent;
		}
		if(value != 0){
			investment -= value;
		}
		return investment;
	}
	
	public static void main(String[] args) {
		
		investment = calculateInvestment(investment, 40, 0);
		System.out.println("First year: " + investment);

		investment = calculateInvestment(investment, 0, 1500);
		System.out.println("Second year: " + investment);
		
		investment = calculateInvestment(investment, 12, 0);
		System.out.println("Third year: " + investment);

	}

}
