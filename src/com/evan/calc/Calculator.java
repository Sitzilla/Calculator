package com.evan.calc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JPanel implements ActionListener {
	
	public static void main(String args[]) {
		JFrame window = new JFrame("Java Calculator");
		Calculator content = new Calculator();
		window.setContentPane(content);
		Dimension d = new Dimension(300,500);
		window.setPreferredSize(d);
		window.setResizable(false);
		window.pack();
		window.setLocation(200,200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
	}
	
	//creates the panes for each row
	JPanel panelOne = new JPanel();
	JPanel panelTwo = new JPanel();
	JPanel panelThree = new JPanel();
	JPanel panelFour = new JPanel();
	JPanel panelFive = new JPanel();
	
	JLabel labelOutput = new JLabel("0");
	
	Font f = new Font("1",1 ,16);
	
	//creates the buttons for each row
	JButton numberOne = new JButton("1");
	//JButton.setFont(f);
	JButton numberTwo = new JButton("2");
	JButton numberThree = new JButton("3");
	JButton numberFour = new JButton("4");
	JButton numberFive = new JButton("5");
	JButton numberSix = new JButton("6");
	JButton numberSeven = new JButton("7");
	JButton numberEight = new JButton("8");
	JButton numberNine = new JButton("9");
	JButton numberZero = new JButton("0");
	
	JButton mathAdd = new JButton("+");
	JButton mathSub = new JButton("-");
	JButton mathMul = new JButton("*");
	JButton mathDiv = new JButton("/");
	
	JButton buttonClear = new JButton("Clear");
	JButton buttonEnter = new JButton("Enter");
	
	//creates new instance of other object classes
	numberArray inputArray = new numberArray();
	mathOperator mathFunction = new mathOperator();
	int arrayIndex = 0;
	int restartIndex = 0;
	
	public Calculator() {
//		setBackground //need to create method 	

		
//Creates the four panels for the calculator and populates them with buttons
		panelOne.setLayout( new GridLayout(1,1));
		panelOne.add(labelOutput);
		
		panelTwo.setLayout( new GridLayout(1,4));
		numberOne.addActionListener(this);
		panelTwo.add(numberOne);
		numberTwo.addActionListener(this);
		panelTwo.add(numberTwo);
		numberThree.addActionListener(this);
		panelTwo.add(numberThree);
		mathAdd.addActionListener(this);
		panelTwo.add(mathAdd);
		
		panelThree.setLayout( new GridLayout(1,4));
		numberFour.addActionListener(this);
		panelThree.add(numberFour);
		numberFive.addActionListener(this);
		panelThree.add(numberFive);
		numberSix.addActionListener(this);
		panelThree.add(numberSix);
		mathSub.addActionListener(this);
		panelThree.add(mathSub);
		
		panelFour.setLayout( new GridLayout(1,4));
		numberSeven.addActionListener(this);
		panelFour.add(numberSeven);
		numberEight.addActionListener(this);
		panelFour.add(numberEight);
		numberNine.addActionListener(this);
		panelFour.add(numberNine);
		mathMul.addActionListener(this);
		panelFour.add(mathMul);
		
		panelFive.setLayout( new GridLayout(1,4));
		buttonEnter.addActionListener(this);
		panelFive.add(buttonEnter);
		numberZero.addActionListener(this);
		panelFive.add(numberZero);
		buttonClear.addActionListener(this);
		panelFive.add(buttonClear);
		mathDiv.addActionListener(this);
		panelFive.add(mathDiv);
		
		
//adds all of the rows to the frame
		setLayout( new GridLayout(5,1));
		add(panelOne);
		add(panelTwo);
		add(panelThree);
		add(panelFour);
		add(panelFive);
		
	
		
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource(); //finds the source of the objects that triggers the event
		
		//determines if currently program is on first or second number in the array
		if (mathFunction.getOperator() == 0) {
			arrayIndex = 0;
		} else {
			arrayIndex = 1;
		}
		//if math button is pressed
		if (source==mathAdd) {
		pressMathButton(source, arrayIndex, 1);	
		}else if (source==mathSub){
		pressMathButton(source, arrayIndex, 2);
		}else if (source==mathMul){
		pressMathButton(source, arrayIndex, 3);		
		}else if (source==mathDiv){
		pressMathButton(source, arrayIndex, 4);	
		}
		
		
		//if number button is pressed
		pressNumberButton(source, arrayIndex);
		
		
		
		//nested if's to check for mathematical operators
		 
		
		//if statement that performs mathematical function on both statements in the array
		 if (source==buttonClear) {
			 inputArray.clearArray();
			 arrayIndex = 0;
			 mathFunction.clearOperator();
			 labelOutput.setText("0");
		} else if (source==buttonEnter) {
			labelOutput.setText(Integer.toString(mathFunction.doMathOperator(inputArray.getArray(0), inputArray.getArray(1))));
			inputArray.updateArray(mathFunction.doMathOperator(inputArray.getArray(0), inputArray.getArray(1)));
			mathFunction.clearOperator();
		}
		
	}
		public void pressMathButton(Object obj, int arrayIn, int mathOper){
				if (arrayIn==0){
					mathFunction.setOperator(mathOper);
				} else {
					labelOutput.setText(Integer.toString(mathFunction.doMathOperator(inputArray.getArray(0), inputArray.getArray(1))));
					inputArray.updateArray(mathFunction.doMathOperator(inputArray.getArray(0), inputArray.getArray(1)));
					mathFunction.setOperator(mathOper);
				}	
		}
		public void pressNumberButton(Object obj, int i) {
			int tempVar = 0;
			if(obj.toString()=="numberOne") {
			System.out.println(obj);
			}
			if (obj==numberOne) {
			tempVar = 1; 
			} else if (obj==numberTwo){
			tempVar = 2;
			} else if (obj==numberThree){
			tempVar = 3; 
			} else if (obj==numberFour){
			tempVar = 4; 
			} else if (obj==numberFive){
			tempVar = 5; 
			} else if (obj==numberSix){
			tempVar = 6; 
			} else if (obj==numberSeven){
			tempVar = 7; 
			} else if (obj==numberEight){
			tempVar = 8; 
			} else if (obj==numberNine){
			tempVar = 9; 
			} else if (obj==numberZero){
			tempVar = 0; 
			} else {
				return;
			}
			
			inputArray.setArray(tempVar, arrayIndex);
			labelOutput.setText(Integer.toString(inputArray.getArray(arrayIndex)));
			
		}
	
		
		
}