package com.suanfa;


import com.problem.linkedlist.ListNode;

/**
 * @description:
 * @author: jenny liang
 * @date: 2025/3/29  14:17
 */
public class Leetcode_203_RemoveLinkedListElements {

    //单独分析头节点
    public ListNode removeElements1(ListNode head, int val) {
        // 如果头节点相同
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 如果头节点不相同
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    //设置一个虚拟头结点
    public ListNode removeElement2(ListNode head, int val) {
        //设置一个虚拟头节点, 指向原来的头节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        //头节点和其他节点相同处理方式
        ListNode current = dummyHead;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }
}
