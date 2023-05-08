package com.akashreya.leetcode.easy;

public class ValidPalindrome {

	public static void main(String[] args) {

		isPalindrome("A man, a plan, a canal: Panama");
	}

	public static boolean isPalindrome(String s) {
		boolean flag = false;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char charAt = s.charAt(i);
			if (Character.isAlphabetic(charAt) || Character.isDigit(charAt)) {
				buffer.append(charAt);
			}
		}
		String withoutSpl = buffer.toString().toLowerCase();
		StringBuffer buffer2 = new StringBuffer();
		for (int i = withoutSpl.length()-1; i >=0; i--) {
			char charAt = withoutSpl.charAt(i);
				buffer2.append(charAt);
		}
		if (withoutSpl.equalsIgnoreCase(buffer2.toString())) {
			flag = true;
		}
		
		return flag;
	}

}
