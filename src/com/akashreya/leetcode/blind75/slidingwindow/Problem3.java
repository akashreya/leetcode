package com.akashreya.leetcode.blind75.slidingwindow;

/**
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * 
 * Example 1: Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc",
 * with the length of 3.
 * 
 * Example 2: Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with
 * the length of 1.
 * 
 * Example 3: Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke",
 * with the length of 3. Notice that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * Constraints: 0 <= s.length <= 5 * 10^4 s consists of English letters, digits,
 * symbols and spaces.
 */
public class Problem3 {

	public static void main(String[] args) {
		String word1 = "abcabcbb";
		System.out.println("Max length :" + Problem3.lengthOfLongestSubstring(word1));
		String word2 = "bbbb";
		System.out.println("Max length :" + Problem3.lengthOfLongestSubstring(word2));
		String word3 = "pwwkew";
		System.out.println("Max length :" + Problem3.lengthOfLongestSubstring(word3));
		System.out.println("Max length :" + Problem3.lengthOfLongestSubstring(" "));
		System.out.println("Max length :" + Problem3.lengthOfLongestSubstring("dvdf"));
	}

	public static int lengthOfLongestSubstring(String word) {
		int maxLength = 0;
		String maxSubString = "";
		if (word != null && word.length() > 0) {
			maxSubString = String.valueOf(word.charAt(0));
			int left = 0;
			int right = 1;
			while (right < word.length()) {
				if (maxSubString.contains(String.valueOf(word.charAt(right)))) {
					left++;
					maxSubString = word.substring(left, right+1);
				} else {
					maxSubString = word.substring(left, right + 1);
				}
				right++;
				System.out.println(maxSubString);

			}
			maxLength = maxSubString.length();
		}

		return maxLength;
	}

}
