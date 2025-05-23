package com.suanfa;


import com.problem.linkedlist.ListNode;

/**
 * @description: 反转链表
 * @author: jenny liang
 * @date: 2025/3/31  12:12
 */
public class Leetcode_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode temp = null;

        while (current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
