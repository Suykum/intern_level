package ru.job4j.calculator;
/**
 * @author Suykum
 * @version
 * @since 0.1
 */
public class Calculator {
	private double result;
	/**
	 * adding two number
	 * @param first
	 * @param second
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	 * execute substraction operation.
	 * @param first
	 * @param second
	 */
	public void substract(double first, double second) {
		this.result = first - second;
	}
	/**
	 * Execute dividing operation.
	 * @param first
	 * @param second
	 */
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
	 * Execute multiplication operation.
	 * @param first
	 * @param second
	 */
	
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	public double getResult() {
		return this.result;
	}
    }