package com.evan.calc;

import javax.swing.JOptionPane;

public class mathOperator {

	private int mathFunction;
	
	public mathOperator() {
		
		mathFunction = 0;
	}
	
	//sets mathFunction as a number between 1-4
	public void setOperator(int i) {
		if (i != 1 && i != 2 && i != 3 && i != 4)
			throw new IllegalArgumentException("Input needs to be an integer between 1 and 4");
		mathFunction = i;
	}
	
	public int getOperator() {
		return mathFunction;
	}
	
	public int doMathOperator(int i, int g) {
		System.out.println(g);
		switch (mathFunction) {
			case 1: return (i+g);
					
			case 2: return (i-g);
					
			case 3: return (i*g);
					
			//checks for divide-by-zero error
			case 4:	if (g==0) {
						JOptionPane.showMessageDialog(null, "Cannot divide by zero");
						return 0;
					} else {
						return (i/g);
					}
			default: return (1);	
		}
	}
	
	public void clearOperator() {
		mathFunction = 0;
	}

}