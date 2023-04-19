package com.leetcode.akashreya.easy;

import java.util.Arrays;

public class RemoveDups {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 2, 5 };
		int[] b = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		RemoveDups removeDups = new RemoveDups();
		int[] uniqueArray = removeDups.removeDuplicate(a);
		System.out.println(Arrays.toString(uniqueArray));
		removeDups(b);
	}

	private static int removeDups(int[] a) {
		int length = a.length;
		int k = 0;
		for (int i = 0; i < length - 1; i++) {
			if (a[i] < a[i + 1]) {
				a[k++] = a[i + 1];
			}
		}
		System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0, k)));
		return k;
	}

	private int[] removeDuplicate(int[] a) {
		int length = a.length;
		int k = 0;
		int[] b = new int[length];
		for (int i = 0; i < length; i++) {
			boolean duplicate = false;
			for (int j = 0; j < i; j++) {
				System.out.println(a[i] + " : " + a[j]);
				if (a[i] == a[j]) {
					duplicate = true;
					break;
				}
			}
			if (!duplicate) {
				b[k++] = a[i];
			}
		}
		return Arrays.copyOfRange(b, 0, k);
	}

}
