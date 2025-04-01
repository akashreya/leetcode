package com.akashreya.leetcode.blind75.arrayshashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class Problem1 {

	public static void main(String[] args) {
		Problem1 problem1 = new Problem1();
		int[] nums = {2,7,11,15};
		int[] twoSum1 = problem1.twoSum(nums, 9);
		System.out.println(twoSum1[0] + " " + twoSum1[1]);
		
		int[] nums1 = {3,2,4};
		int[] twoSum2 = problem1.twoSum(nums1, 6);
		System.out.println(twoSum2[0] + " " + twoSum2[1]);
		
		int[] nums2 = {3,3};
		int[] twoSum3 = problem1.twoSum(nums2, 6);
		System.out.println(twoSum3[0]+ " " + twoSum3[1]);
		
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] positions = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i =0; i < nums.length; i++) {
			int difference = target - nums[i];
			if (map.containsKey(difference)) {
				positions[0] = map.get(difference);
				positions[1] = i;
			}
			map.put(nums[i], i);
		}
		return positions;
    }

}
