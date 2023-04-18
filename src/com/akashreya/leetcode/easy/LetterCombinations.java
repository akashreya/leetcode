package com.akashreya.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Akash
 * 
 *         Given a string containing digits from 2-9 inclusive, return all
 *         possible letter combinations that the number could represent
 *
 */
public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations combinations = new LetterCombinations();
		List<String> letterCombinations = combinations.letterCombinations("234");
		for (String string : letterCombinations) {
			System.out.print(string + " ");
		}

	}

	List<String> combinations = new ArrayList<String>();
	public  List<String> letterCombinations(String digits) {
		if (digits != null && !digits.isBlank() ) {
			getCombo(digits, "",  0);
		}
		return combinations;
	}

	private  void getCombo(String digits, String letters,  int index) {
		if (digits.length() == index) {
			combinations.add(letters);
		} else if (index < digits.length()){
			char digit = digits.charAt(index);
			String[] lettersForNumber = getLettersForNumber(Character.getNumericValue(digit));
			for (int i = 0; i < lettersForNumber.length; i++) {
				String string = lettersForNumber[i];
				getCombo(digits, letters + string, index + 1);
			}
		}
	}

	private static String[] getLettersForNumber(int numericValue) {
		String[] letters = new String[3];
		switch (numericValue) {
		case 2:
			letters[0] = "a";
			letters[1] = "b";
			letters[2] = "c";
			break;
		case 3:
			letters[0] = "d";
			letters[1] = "e";
			letters[2] = "f";
			break;
		case 4:
			letters[0] = "g";
			letters[1] = "h";
			letters[2] = "i";
			break;
		case 5:
			letters[0] = "j";
			letters[1] = "k";
			letters[2] = "l";
			break;
		case 6:
			letters[0] = "m";
			letters[1] = "n";
			letters[2] = "o";
			break;
		case 7:
			letters = new String[4];
			letters[0] = "p";
			letters[1] = "q";
			letters[2] = "r";
			letters[3] = "s";
			break;
		case 8:
			letters[0] = "t";
			letters[1] = "u";
			letters[2] = "v";
			break;
		case 9:
			letters = new String[4];
			letters[0] = "w";
			letters[1] = "x";
			letters[2] = "y";
			letters[3] = "z";
			break;
		default:
			break;
		}
		return letters;
	}

}
