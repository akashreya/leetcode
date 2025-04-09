package com.akashreya.leetcode.easy;

/**
 * @author Akash
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 */
public class MergeSortedLinkedList {

	public static void main(String[] args) {

		MergeSortedLinkedList merged = new MergeSortedLinkedList();
		ListNode mergeTwoLists = merged.mergeTwoLists(merged.getList1(), merged.getList2());
		while (mergeTwoLists != null) {
			System.out.println(mergeTwoLists.val);
			mergeTwoLists = mergeTwoLists.next;
		}
	}

	private ListNode getList1() {
		ListNode node = new ListNode();
		node.val = 1;
		node.next = null;
		node.next = new ListNode(2, node);
		node.next.next = new ListNode(4, node.next);
		node.next.next.next = null;
		return node;
	}

	private ListNode getList2() {
		ListNode node = new ListNode();
		node.val = 1;
		node.next = null;
		node.next = new ListNode(3, node);
		node.next.next = new ListNode(4, node.next);
		node.next.next.next = null;
		return node;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
		ListNode node = head;
		while (list1 !=null || list2 !=null) {
			if (list1 !=null && list2!=null) {
				if (list1.val < list2.val) {
					node.next = list1;
					list1 = list1.next;
				}
				else {
					node.next = list2;
					list2 = list2.next;
				}
			}
			else if (list1 == null && list2 != null) {
				node.next = list2;
				list2 = list2.next;
			}
			else if (list1 != null && list2 == null) {
				node.next = list1;
				list1 = list1.next;
			}
			node = node.next;
			
		}
		return head.next;
	
    }

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
