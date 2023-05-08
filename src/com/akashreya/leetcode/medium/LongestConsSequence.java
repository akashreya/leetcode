package com.akashreya.leetcode.medium;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LongestConsSequence {

	public static void main(String[] args) {
		LongestConsSequence seq = new LongestConsSequence();
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int longestConsecutive = seq.longestConsecutive(nums);
		System.out.println(longestConsecutive);

	}

	public int longestConsecutive(int[] nums) {
		int longest = 0;
		if (nums.length == 1) {
			longest = 1;
		} else {
			Set<Integer> numbers = new HashSet<Integer>();
			for (int integer : nums) {
				numbers.add(integer);
			}
			for (Integer number : numbers) {
				if (!numbers.contains(number - 1)) {
					int seq = 1;
					while (numbers.contains(number + 1)) {
						number++;
						seq++;
					}
					longest = Math.max(seq, longest);
				}
			}
		}
		return longest;
	}
}