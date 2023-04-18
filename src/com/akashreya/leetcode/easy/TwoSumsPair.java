package com.akashreya.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumsPair {

	public static void main(String[] args) {

		// Input: nums = [2,7,11,15], target = 9
		// Output: [0,1]
		TwoSumsPair pair = new TwoSumsPair();
		int[] array = { 2, 7, 11, 15 };
		int[] twoSum = pair.twoSum(array, 9);
		System.out.println(Arrays.toString(twoSum));

	}

	public int[] twoSum(int[] nums, int target) {

		int[] positions = new int[2];

		for (int i = 0; i < nums.length; i++) {
			boolean found = false;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] + nums[i] == target) {
					positions[0] = i;
					positions[1] = j;
					found = true;
					break;
				}
			}
			if (found)
				break;
		}
		Map<Integer, Integer> numToIndex = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (numToIndex.containsKey(target - nums[i])) {
				return new int[] { numToIndex.get(target - nums[i]), i };
			}
			numToIndex.put(nums[i], i);
		}
		return positions;
		
	}

}
