package com.problem.stack;

import java.util.Stack;

/**
 * @description:
 *  实现一个栈Stack，要求实现Push（入栈）、Pop（出栈）、Min（返回最小值的操作）的时间复杂度为O(1)
 * 【要求】 1.pop、push、getMin操作的时间复杂度都是O(1)。 2.设计的栈类型可以使用现成的栈结构。
 * @author: liangxiujie
 * @create: 2019-02-22
 */

public class MinStack {

    //一个栈存放数据元素，一个栈存放min数
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack(){
        this.dataStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    //入栈
    //向栈中存放元素时，先与minstack栈中顶部元素比较，如果小于当前最小值，则将该值存入minstack
    //如果大于当前最小值,则再次压入当前栈顶最小值
    public void push(int value){
        if(minStack.isEmpty()){
            minStack.push(value);
        }else if(value < minStack.peek()){
            minStack.push(value);
        }else{
            minStack.push(minStack.peek());
        }
        dataStack.push(value);
    }

    //出栈
    //出栈时，minstack栈中也同时将栈顶元素推出
    public Integer pop(){
        if(this.dataStack.isEmpty()){
            throw new RuntimeException("Stack is NULL");
        }
        this.minStack.pop();
        return this.dataStack.pop();
    }

    public int getMin(){
        if(this.minStack.isEmpty()){
            throw new RuntimeException("Stack is NULL");
        }
        return this.minStack.peek();
    }

}
