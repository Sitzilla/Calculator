package com.evan.calc;

public class numberArray {

	private int[] inputArray;
	
	public numberArray(){
		inputArray = new int[2];
		inputArray[0] = 0;
		inputArray[1] = 0;
		
		
	}
	
	public void setArray(int input, int i){
		if (i != 0 && i != 1) {
			throw new IllegalArgumentException("Did not specify a correct position in the array");
		}
		//first number in the array
		
		if (inputArray[i] == 0) {
			inputArray[i] = input;
		} else {
			inputArray[i] = (inputArray[i]*10) + input;
		}
	}
	
	public int getArray(int i){
		if (i != 0 && i != 1) {
			throw new IllegalArgumentException("Did not specify a correct position in the array");
		}
		return inputArray[i];
	}
	public void updateArray(int i) {
		inputArray[0] = i;
		inputArray[1] = 0;
		
	}
	
	public void clearArray(){
		inputArray[0] = 0;
		inputArray[1] = 0;
	}
}