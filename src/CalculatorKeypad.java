import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalculatorKeypad {
	private final JPanel keypadPanel;
	private final String[] buttonLabels = { "1", "2", "3", "C", "4", "5", "6", "+","7", "8", "9", "-", "=", "0", "/",
			"*",

	};
	
	public CalculatorKeypad(ActionListener listener) {
		keypadPanel = new JPanel(new GridLayout(4,4,5,5));
		keypadPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		for(String label:buttonLabels) {
			JButton button = new JButton(label);
			button.setFont(new Font("Arial",Font.BOLD,20));
			button.addActionListener(listener);
			keypadPanel.add(button);
		}
	}
	public JPanel getKeypadPanel() {
		return keypadPanel;

	}

}
