package com.akashreya.leetcode.blind75.arrayshashing;

import java.util.*;
import java.util.Map.Entry;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique
 */
public class Problem347 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		System.out.println(new Problem347().topKFrequent(nums, 2));

		//4,1,-1,2,-1,2,3
		int[] nums2 = {4,1,-1,2,-1,2,3};
		System.out.println(new Problem347().topKFrequent(nums2, 2));
	}
	
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(); 
		for(int number: nums) {
			countMap.put(number, countMap.getOrDefault(number, 0)+1);
		}
		
		List<int[]> values = new ArrayList<int[]>();
		for (Entry<Integer, Integer> entry : countMap.entrySet()) {
			values.add(new int[] {entry.getValue(), entry.getKey()});
		}
		values.sort((a, b) -> b[0]-a[0]);
		
		int[] keys = new int[k];
		for (int i = 0; i < k; i++) {
			keys[i] = values.get(i)[1];
		}
		return keys;
    }

}
