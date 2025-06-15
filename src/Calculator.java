import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	private final CalculatorDisplay display;
	private final CalculatorLogic logic;
	private final CalculatorKeypad keypad;

	// when export as a jar file
	private static ImageIcon logo = new ImageIcon(".//logo//calLogo.png");

	public Calculator() {
		super("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setIconImage(logo.getImage());

		// initialize components
		display = new CalculatorDisplay();
		logic = new CalculatorLogic();
		keypad = new CalculatorKeypad(new ButtonClickListener());

		// add components to frame
		add(display.getDisplayPanel(), BorderLayout.NORTH);
		add(keypad.getKeypadPanel(), BorderLayout.CENTER);

		// window properties
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);

	}

	// inner class to handle button clicks
	private class ButtonClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			processCommand(command);
		}
	}

	private void processCommand(String command) {
		switch (command) {
		case "C":
			logic.clear();
			display.clear();
			break;
		case "=":
			try {
				double result = logic.calculatorResult();
				display.setDisplay(String.valueOf(result));
				logic.setNewNumber(true);
			} catch (ArithmeticException e) {
				display.setDisplay("Error");
				logic.clear();
			}
			break;
		case "+":
		case "-":
			if (command == "-" && logic.getCurrentNumber()==0 ) {
				display.setDisplay(command);
				logic.setNewNumber(false);
			}
		case "*":
		case "/":
			logic.setOperator(command);
			logic.setNewNumber(true);
			break;
		default:
			if (logic.isNewNumber()) {
				display.setDisplay(command);
				logic.setNewNumber(false);
			} else {
				display.appendToDisplay(command);
			}
			logic.setCurrentNumber(Double.parseDouble(display.getDisplay()));
		}
		System.out.println("Ops " + command);
		System.out.println("Current " + logic.getCurrentNumber());
		System.out.println("Stored " + logic.getStoredNumber());
		System.out.println("Result " + logic.calculatorResult());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Calculator calculator = new Calculator();
			calculator.setVisible(true);
			calculator.setIconImage(logo.getImage());
		});
	}

}
