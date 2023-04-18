package com.akashreya.leetcode.easy;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInteger("MCMXCIV"));
	}

	private static int romanToInteger(String string) {
		int number = 0;
//		I             1
//		V             5
//		X             10
//		L             50
//		C             100
//		D             500
//		M             1000
		for (int i = string.length() - 1; i >= 0; i--) {
			char charAt = string.charAt(i);
			int num = 0;
			switch (charAt) {
			case 'I':
				num = 1;
				break;
			case 'V':
				num = 5;
				break;
			case 'X':
				num = 10;
				break;
			case 'L':
				num = 50;
				break;
			case 'C':
				num = 100;
				break;
			case 'D':
				num = 500;
				break;
			case 'M':
				num = 1000;
				break;
			default:
				break;
			}
			if (4 * num < number) {
				number = number - num;
			} else {
				number = number + num;
			}

		}
		return number;
	}

}
