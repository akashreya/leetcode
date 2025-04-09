package com.akashreya.leetcode.blind75.arrayshashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence. You must write an algorithm that runs in O(n)
 * time.
 * 
 * Example 1: Input: nums = [100,4,200,1,3,2] Output: 4 Explanation: The longest
 * consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * Example 2: Input: nums = [0,3,7,2,5,8,4,6,0,1] Output: 9
 * 
 * Example 3: Input: nums = [1,0,1,2] Output: 3
 */
public class Problem128 {

	public static void main(String[] args) {
		Problem128 problem128 = new Problem128();
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		int longestConsecutive = problem128.longestConsecutive(nums);
		System.out.println(longestConsecutive);
	}

	public int longestConsecutive(int[] nums) {
		
		int longest = 0;
		if (nums.length == 1) {
			longest = 1;
		}
		else {
			Set<Integer> integers = new HashSet<Integer>();
			for(int number: nums) {
				integers.add(number);
			}
			for (Integer integer : integers) {
				if (!integers.contains(integer-1)) {
					int seq = 1;
					while (integers.contains(integer + 1)) {
						integer++;
						seq++;
					}
					longest = Math.max(seq, longest);
				}
			}
		}
		return longest;
	}

}
