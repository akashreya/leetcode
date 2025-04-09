package com.akashreya.leetcode.blind75.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1: Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] +
 * nums[2] + nums[4] = 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2
 * + (-1) = 0. The distinct triplets are [-1,0,1] and [-1,-1,2].
 * 
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 * 
 * Example 2: Input: nums = [0,1,1] Output: [] Explanation: The only possible
 * triplet does not sum up to 0.
 * 
 * 
 * Example 3: Input: nums = [0,0,0] Output: [[0,0,0]]
 * 
 * Explanation: The only possible triplet sums up to 0.
 * 
 * Constraints: 3 <= nums.length <= 3000 -10^5 <= nums[i] <= 10^5
 */
public class Problem15 {

	public static void main(String[] args) {

		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> threeSum = Problem15.threeSum(nums);
		System.out.println(threeSum.toString());
		
		List<List<Integer>> threeSum2 = Problem15.threeSum(nums);
		System.out.println(threeSum2.toString());
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> list = new HashSet<List<Integer>>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					list.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					if (left < right & nums[left] == nums[left - 1]) {
						left++;
					}
				}
			}

		}

		return new ArrayList<List<Integer>>(list);
	}

	public static List<List<Integer>> threeSumUsingMap(int[] nums) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.get(nums[i]) - 1);
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			for (int j= i+1; j < nums.length; j++) {
				map.put(nums[j], map.get(nums[j]) - 1);
				if (j > 0 && nums[j] == nums[j - 1]) {
					continue;
				}
				int target = - (nums[i]+nums[j]);
				if (map.getOrDefault(target, 0) > 0) {
					list.add(Arrays.asList(nums[i], nums[j], target));
				}
			}
			
			for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[j], map.get(nums[j]) + 1);
            }

		}

		return list;
	}
}
