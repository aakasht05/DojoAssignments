package com.aakashtripathi.calculator1;

public class Calculator implements java.io.Serializable {

	private double x;
	private double y;
	private double results;
	private String sign;

	public Calculator() {
		
	}
	
	public void setOperandOne(double d) {
		this.x = d;
	}

	public void setOperation(String sign) {
		this.sign = sign;
	}

	public void setOperandTwo(double y) {
		this.y = y;
	}

	public void performOperation() {
		switch (sign) {
		case "+":
			results = x + y;
			break;
		case "-":
			results = x - y;
			break;
		case "*":
			results = x * y;
			break;
		case "/":
			results = x / y;
			break;
		default:
			break;
		}
	}

	public double getResults() {
		System.out.println(results);
		return results;
	}
}

