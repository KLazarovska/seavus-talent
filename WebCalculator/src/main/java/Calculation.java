
public class Calculation {

	private int inputValue1;
	private int inputValue2;
	private String operation;
	
	public Calculation(int inputValue1, int inputValue2, String operation) {
		super();
		this.inputValue1 = inputValue1;
		this.inputValue2 = inputValue2;
		this.operation = operation;
	}

	public int getInputValue1() {
		return inputValue1;
	}

	public void setInputValue1(int inputValue1) {
		this.inputValue1 = inputValue1;
	}

	public int getInputValue2() {
		return inputValue2;
	}

	public void setInputValue2(int inputValue2) {
		this.inputValue2 = inputValue2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
