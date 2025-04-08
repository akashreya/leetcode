package com.akashreya.leetcode.blind75.arrayshashing;

import java.util.*;

//Given an array of strings strs, group the anagrams together. 

//You can return the answer in any order.

/**
 * Example 1: Input: strs = ["eat","tea","tan","ate","nat","bat"] 
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] 
 * Explanation: There is no string in strs that can be rearranged to form "bat". The strings "nat" and "tan" are
 * anagrams as they can be rearranged to form each other. The strings "ate",
 * "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * 
 * Example 2: Input: strs = [""] 
 * Output: [[""]]
 * 
 * Example 3: Input: strs = ["a"] 
 * Output: [["a"]]
 * 
 * Constraints: 1 <= strs.length <= 104 0 <= strs[i].length <= 100\ strs[i]
 * consists of lowercase English letters.
 */
public class Problem49 {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> groupAnagrams = new Problem49().groupAnagramsSorted(strs);
		System.out.println(groupAnagrams.toString());
		
		List<List<String>> groupAnagrams21 = new Problem49().groupAnagrams(strs);
		System.out.println(groupAnagrams21.toString());
		
		
		String[] strs1 = { };
		List<List<String>> groupAnagrams1 = new Problem49().groupAnagrams(strs1);
		System.out.println(groupAnagrams1.toString());
		
		String[] strs2 = {"akash" };
		List<List<String>> groupAnagrams2 = new Problem49().groupAnagrams(strs2);
		System.out.println(groupAnagrams2.toString());
	}

	public List<List<String>> groupAnagramsSorted(String[] strs) {
		Map<String, List<String>> anagramsMap = new HashMap<String, List<String>>();
		if (strs.length != 0) {
			for (String word: strs) {
				char[] charArray = word.toCharArray();
				Arrays.sort(charArray);
				String sortedWord = String.valueOf(charArray);
				anagramsMap.putIfAbsent(sortedWord, new ArrayList<String>());
				anagramsMap.get(sortedWord).add(word);
			}
		}
		return new ArrayList<List<String>>(anagramsMap.values());
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anagramsMap = new HashMap<String, List<String>>();
		if (strs.length != 0) {
			for (String word: strs) {
				int[] counts = new int[26];
				for(Character character: word.toCharArray()) {
					counts[character - 'a']++;
				}
				String countedWord = Arrays.toString(counts);
				anagramsMap.putIfAbsent(countedWord, new ArrayList<String>());
				anagramsMap.get(countedWord).add(word);
			}
		}
		return new ArrayList<>(anagramsMap.values());
	}

}
