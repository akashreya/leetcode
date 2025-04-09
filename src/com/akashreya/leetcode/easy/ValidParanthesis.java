package com.akashreya.leetcode.easy;

import java.util.Stack;

/**
 * @author Akash
 *Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *An input string is valid if:
 *		Open brackets must be closed by the same type of brackets.
 *		Open brackets must be closed in the correct order.
 *		Every close bracket has a corresponding open bracket of the same type.
 *
 *
 */
public class ValidParanthesis {

	public static void main(String[] args) {
		ValidParanthesis paranthesis = new ValidParanthesis();
		Boolean isValid = paranthesis.isValid("([]){");
		System.out.println(isValid);
	}

	private Boolean isValid(String string) {
		Boolean isValid = true;
		Stack<Character> chars = new Stack<Character>();

		for (int i = 0; i < string.length(); i++) {
			char charAt = string.charAt(i);
			if (charAt == '(') {
				chars.push(charAt);
			} else if (charAt == ')') {
				if (chars.size() >=1 && chars.peek() == '(') {
					chars.pop();
					isValid = true;
				}
				else {
					isValid = false;
					break;
				}
			} else if (charAt == '{') {
				chars.push(charAt);
			} else if (charAt == '}') {
				if (chars.size() >=1  && chars.peek() == '{') {
					isValid = true;
					chars.pop();
				}
				else {
					isValid = false;
					break;
				}
			} else if (charAt == '[') {
				chars.push(charAt);
			} else if (charAt == ']') {
				if (chars.size() >=1 && chars.peek() == '[') {
					isValid = true;
					chars.pop();
				}
				else {
					isValid = false;
					break;
				}
			}
		}
		if (chars.size() >= 1) {
			Character peek = chars.peek();
			if (peek== '[' || peek == '{' || peek == '(' ) {
				isValid = false;
			}
		}

		return isValid;
	}

}
