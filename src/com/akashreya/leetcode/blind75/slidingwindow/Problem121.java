package com.akashreya.leetcode.blind75.slidingwindow;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day. You want to maximize your profit by choosing a single day to
 * buy one stock and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * 
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * Constraints:
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */
public class Problem121 {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println("Max profit: "+Problem121.maxProfit(prices));
		
		int[] prices2 = {7,6,4,3,1};
		System.out.println("Max profit: "+Problem121.maxProfit(prices2));
	}

	public static int maxProfitBruteForce(int[] prices) {
		int maxProfit = 0;
		for(int i =0; i< prices.length;i++) {
			for (int j = i+1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				maxProfit = Math.max(maxProfit, profit);
				System.out.println(maxProfit);
			}
		}
		return maxProfit;
	}
	
	public static int maxProfitDynamicProgramming(int[] prices) {
		int maxProfit = 0;
		int lowest = Integer.MAX_VALUE;
		for(int i =0; i< prices.length;i++) {
			lowest = Math.min(lowest, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i]-lowest);
		}
		return maxProfit;
	}
	
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int left = 0;
		int right = left + 1;
		while(right < prices.length) {
			if (prices[left] < prices[right]) {
				maxProfit = Math.max(maxProfit, prices[right]-prices[left]);
			}
			else {
				left = right;
			}
			right++;
		}
		
		return maxProfit;
	}


}
