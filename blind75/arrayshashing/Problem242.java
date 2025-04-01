package com.akashreya.leetcode.blind75.arrayshashing;

import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

//An anagram is a string that contains the exact same characters as another string, 
//but the order of the characters can be different.
//
//Example 1:
//Input: s = "racecar", t = "carrace"
//Output: true
//
//Example 2:
//Input: s = "jar", t = "jam"
//Output: false
//Constraints:
//
//s and t consist of lowercase English letters.
public class Problem242 {

	public static void main(String[] args) {
		String s = "rat";
		String t = "car";
		Problem242 problem242 = new Problem242();
		boolean anagram = problem242.isAnagram(s, t);
		System.out.println(anagram);
	}

	public boolean isAnagramMap(String s, String t) {
		boolean flag = false;
		if (s.length() == t.length()) {
			Map<Character, Integer> charCount_S = new HashMap<Character, Integer>();
			Map<Character, Integer> charCount_T = new HashMap<Character, Integer>();
			
			for (int i =0 ; i< s.length(); i++) {
				charCount_S.put(s.charAt(i), charCount_S.getOrDefault(s.charAt(i), 0) + 1);
				charCount_T.put(t.charAt(i), charCount_T.getOrDefault(t.charAt(i), 0) + 1);
			}
			flag = charCount_S.equals(charCount_T);
		}
		return flag;
    }
	
	public boolean isAnagram(String s, String t) {
		boolean flag = false;
		if (s.length() == t.length()) {
			int[] count_s = new int[26];
			
			for (int i = 0; i < s.length(); i++) {
				count_s[s.charAt(i) - 'a']++;
				count_s[t.charAt(i) - 'a']--;
			}
			for(int i =0; i < count_s.length; i ++) {
				if (count_s[i]!=0) {
					flag = false;
					break;
				}
				else {
					flag = true;
				}
			}
		}
		return flag;
    }
}
