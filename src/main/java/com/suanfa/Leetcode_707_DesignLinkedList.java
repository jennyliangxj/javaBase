package com.suanfa;


import com.problem.linkedlist.ListNode;

/**
 * @description:
 * @author: jenny liang
 * @date: 2025/3/29  18:53
 */
public class Leetcode_707_DesignLinkedList {

    //size存储链表元素的个数
    private int size;

    // 注意这里记录的是虚拟头结点
    private ListNode head;

    //初始化链表
    public Leetcode_707_DesignLinkedList(){
        this.size = 0;
        this.head = new ListNode(0);
    }

    // 获取第 index个节点的数值,注意 index是从0开始的，第 0 个节点就是虚拟头结点
    public int get(int index){
        //如果 index 非法，返回 -1
        if(index < 0 || index >= size){
            return -1;
        }

        ListNode current = head;
        // 第 0 个节点是虚拟头节点，所以查找第 index + 1个节点
        for(int i = 0; i <= index; i++){
            current = current.next;
        }
        return current.val;
    }

    // 在链表最前面插入一个节点，等价于在第0个元素前添加； 虚拟头节点指向新的头节点
    public void addAtHead(int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    //在链表的最后面插入一个节点
    public void addAtTail(int val){
        ListNode newNode = new ListNode(val);
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    // 在链表第 index个节点前插入一个新节点
    public void addAtIndex(int index, int val){
        if(index < 0 || index > size){
            return;
        }
        //找到要插入节点的前驱
        ListNode pre = head;
        for(int i = 0; i< index++; i++){
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    // 删掉第 index 个节点
    public void deleteAtIndex(int index){
        if(index < 0 || index >= size){
            return;
        }

        ListNode pre = head;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }

        pre.next = pre.next.next;
        size--;
    }
}
