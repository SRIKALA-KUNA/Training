package com.epam.engx.cleancode.naming.task3;

public class HarshadNumber {

	public static final int BASE = 10;
	public static final int COUNT = 1000;
	
	public static void main(String[] args) {
		for (int i = 1; i <= COUNT; i++) {
			if (i % getSumOfNumbersDigits(i) == 0) {
				System.out.println(i);
			}
		}
	}

	private static int getSumOfNumbersDigits(int number) {
		int sum = 0;
		while (number != 0) {
			sum += number % BASE;
			number = number / BASE;
		}
		return sum;
	}

}
