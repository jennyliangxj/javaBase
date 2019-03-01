package com.problem.stack;

import org.testng.annotations.Test;

/**
 * @description:
 * @author: liangxiujie
 * @create: 2019-02-22
 */

public class MinStackTest {

    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.getMin());

        minStack.push(1);
        System.out.println(minStack.getMin());

        minStack.push(0);
        System.out.println(minStack.getMin());

        minStack.push(2);
        System.out.println(minStack.getMin());

        System.out.println("=== begin pop ====");

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
