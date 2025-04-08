package com.akashreya.leetcode.blind75.arrayshashing;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of 
 * nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * 
 */
public class Problem238 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		
		int[] productExceptSelf = productExceptSelf(nums);
		for (int product : productExceptSelf) {
			System.out.println(product);
		}
		
		int[] productExceptSelf2 = productExceptSelfBruteForce(nums);
		for (int product : productExceptSelf2) {
			System.out.println(product);
		}

	}

	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] products = new int[len];
		int product = 1;
		for (int i = 0; i < nums.length; i++) {
			products[i] = product;
			product = product * nums[i];
		}
		product = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			products[i] = products[i] * product;
			product = product * nums[i];
		}
		return products;
	}
	
	public static int[] productExceptSelfBruteForce(int[] nums) {
		int len = nums.length;
		int[] products = new int[len];
		
		for (int i = 0; i < len; i++) {
			int product = 1;
			for (int j = 0; j < len; j++) {
				if (i != j) {
					product = product * nums[j];
				}
				
			}
			products[i] = product;
		}
		return products;
	}
	
}
