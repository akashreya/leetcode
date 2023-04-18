package com.akashreya.leetcode.easy;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
		System.out.println(commonPrefix.longestCommonPrefix(strs));
		
		String[] strs1 = { "a" };
		System.out.println(commonPrefix.longestCommonPrefix(strs1));


	}

	public String longestCommonPrefix(String[] strs) {
		
		String word  = strs[0];
		if (strs.length > 1) {
			for (int i = 1; i < strs.length; i++) {
				while (!strs[i].startsWith(word)) {
					word = word.substring(0, word.length() - 1);
					if (word.isEmpty()) {
						break;
	                }
				}
			}
		}
		return word;
	}
}
