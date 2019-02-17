package com.problem.linkedlist;
/*
 * 判断链表中是否有环，两种方法
 */


public class LinkedListCycle {
	
/* 方法一：两个指针，一个快每次走两步，一个慢每次走一步
* 如果快的先为null 或者 next为空，说明没有环
* 如果慢指针在某个位置跟快指针相遇，说明有环
*/
	public static boolean hasCycle(ListNode head){
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast){
			if(fast == null || fast.next == null){
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;				
		}
		return true;
	}
	
/*
 * 方法二：
 */
	
	
}
