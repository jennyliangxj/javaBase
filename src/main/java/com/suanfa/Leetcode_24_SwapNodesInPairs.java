package com.suanfa;


import com.problem.linkedlist.ListNode;

/**
 * @description:
 * @author: jenny liang
 * @date: 2025/3/31  12:34
 */
public class Leetcode_24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head){
        ListNode dumyhead = new ListNode(-1);
        dumyhead.next = head;

        ListNode current = dumyhead;
        ListNode temp;
        ListNode firstNode;
        ListNode secondNode;

        while (current.next != null && current.next.next != null){
            temp = current.next.next.next;
            firstNode = current.next;
            secondNode = current.next.next;

            current.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            current = firstNode;
        }
        return dumyhead.next;
    }
}
