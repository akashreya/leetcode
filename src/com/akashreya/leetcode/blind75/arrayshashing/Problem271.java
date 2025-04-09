package com.akashreya.leetcode.blind75.arrayshashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a single string. 
 * The encoded string is then decoded back to the original list of strings.
 * Please implement encode and decode
 * 
 * Example 1:
 * Input: ["neet","code","love","you"]
 * Output:["neet","code","love","you"]
 * 
 * Example 2:
 * Input: ["we","say",":","yes"]
 * Output: ["we","say",":","yes"]
 * 
 * Constraints:
 * 0 <= strs.length < 100
 * 0 <= strs[i].length < 200
 * strs[i] contains only UTF-8 characters.
 */
public class Problem271 {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("neet","code","love","you");
		String encodedString = encode(input);
		System.out.println(encodedString);
		List<String> output = decode(encodedString);
		System.out.println(output);
		
	}
	public static String encode(List<String> input) {
		StringBuffer buffer = new StringBuffer();
		if (!input.isEmpty()) {
			for (String string : input) {
				buffer.append(string.length()).append("#").append(string);
			}
		}

		return buffer.toString();
    }

    public static List<String> decode(String str) {
    	List<String> decodedList = new ArrayList<String>();
    	int i =0;
    	while (i < str.length()) {
    		int j =i;
    		while(str.charAt(j) != '#') {
    			j++;
    		}
    		int stringLength = Integer.parseInt(str.substring(i, j));
    		i = j + 1;
    		j = i + stringLength;
    		decodedList.add(str.substring(i, j));
    		i = j;
    	}
    	return decodedList;
    }
}
