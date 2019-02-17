package com.problem.linkedlist;

public class ReverseLinkedList {
	/*
	 * 1->2->3->O, 倒置后：O<-1<-2<-3
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}
}
