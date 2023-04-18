package com.akashreya.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();

		int[] nums2 = { 1, 2, -2, -1 };
		List<List<Integer>> list2 = threeSum.threeSum(nums2);
		System.out.println(list2.toString());

	}

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> bigList = new HashSet<List<Integer>>();
		int length = nums.length;
		if (length >= 3) {
			Arrays.sort(nums);
			Map<Integer, Integer> numToIndex = new HashMap<>();
			for (int i = 0; i < length - 2; i++) {
				int target = nums[i];
				for (int j = i; j < length; j++) {
					if (i != j) {
						int negNum = -1 * target;
						int key = negNum - nums[j];
						if (numToIndex.containsKey(key)) {
							List<Integer> list = new ArrayList<>();
							list.add(target);
							list.add(key);
							list.add(nums[j]);
							Collections.sort(list);
							bigList.add(list);
							while (j < (length - 1) && nums[j] == nums[j + 1]) 
								j++;
						}
						else {
							numToIndex.put(key, j);
						}
					}
				}
				numToIndex.clear();
			}
		}

		return new ArrayList<>(bigList);
	}

}
