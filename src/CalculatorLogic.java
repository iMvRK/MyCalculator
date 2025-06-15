
public class CalculatorLogic {
	private double currentNumber;
	private double storedNumber;
	private String currentOperator;
	private boolean newNumber;

	public CalculatorLogic() {
		clear();
	}

	public void clear() {
		currentNumber = 0;
		storedNumber = 0;
		currentOperator = "";
		newNumber = true;

	}

	public void setCurrentNumber(double number) {
		this.currentNumber = number;
	}

	public double getCurrentNumber() {
		return this.currentNumber;
	}

	public void setOperator(String operator) {
		if (!currentOperator.isEmpty()) {
			storedNumber = calculatorResult();
		} else {
			storedNumber = currentNumber;
		}
		currentOperator = operator;
	}

	public void setNewNumber(boolean newNumber) {
		this.newNumber = newNumber;

	}

	public boolean isNewNumber() {
		return newNumber;

	}

	public double calculatorResult() {
		switch (currentOperator) {
		case "+":
			return storedNumber + currentNumber;

		case "-":
				return storedNumber - currentNumber;
		case "*":
			return storedNumber * currentNumber;
		case "/":
			if (currentNumber == 0) {
				throw new ArithmeticException("Devided by Zero is not possible !");
			} else {
				return storedNumber / currentNumber;
			}
		default:
			return currentNumber;
		}

	}

	public double getStoredNumber() {
		return storedNumber;
	}

	public void setStoredNumber(double storedNumber) {
		this.storedNumber = storedNumber;
	}

}
