package com.akashreya.leetcode.blind75.twopointers;

/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]). Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 * 
 * Return the maximum amount of water a container can store Notice that you may
 * not slant the container.
 */
public class Problem11 {

	public static void main(String[] args) {

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int maxArea = Problem11.maxAreaBruteForce(height);
		System.out.println("Max area Brute: " + maxArea);

		int maxArea2 = Problem11.maxArea(height);
		System.out.println("Max area: " + maxArea2);
	}

	public static int maxAreaBruteForce(int[] height) {

		int maxArea = 0;
		if (height.length != 1) {
			for (int i = 0; i < height.length; i++) {
				for (int j = i + 1; j < height.length; j++) {
					int lowest = Math.min(height[i], height[j]);
					int area = lowest * (j - i);
					if (area > maxArea) {
						maxArea = area;
					}
				}
			}
		}
		return maxArea;
	}

	public static int maxArea(int[] height) {

		int maxArea = 0;
		if (height.length != 1) {
			int i = 0;
			int j = height.length - 1;
			int leftheight = height[i];
			int rightHeight = height[j];
			while (i != j) {

				int area = Math.min(height[i], height[j]) * (j - i);
				maxArea = Math.max(maxArea, area);
				if (leftheight <= rightHeight) {
					i++;

				} else if (leftheight > rightHeight) {
					j--;
				}

			}
		}
		return maxArea;
	}
}
