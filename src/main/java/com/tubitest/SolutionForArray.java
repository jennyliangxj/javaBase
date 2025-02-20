package com.tubitest;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * 问题： 展开多层嵌套数组列表为一层列表
 * 比如：flat ([1, 2, 3, [4, 5]])   ==> [1, 2, 3, 4, 5]
 * author: jenny
 * time:  2025.2.18
 */
public class SolutionForArray {
    /**
     * 方法: 展开多层嵌套数组列表
     * 输入参数: 方法参数为 List<?>  多层嵌套数组列表，可以为任意类型
     * 输出参数：List<Object> 包含所有展开后的元素
     */
    public List<Object> flat(List<?> list){
        //边界值检查：如果数组列表为空，返回 null
        if (list == null) {
            return null;
        }

        // 数组不为空，继续
        // 循环遍历该数组列表每个元素：如为子列表则递归调用 flat 方法展开；否则直接添加该元素
        List<Object> result = new ArrayList<>();
        for(Object element : list){
            if(element instanceof List<?>){
                //递归处理子数组
                result.addAll(flat((List<?>) element));
            }else{
                //直接添加
                result.add((Object) element);
            }
        }
        return result;
    }


    // 测试数据
    @Test
    public void testCase(){

        //case 1： 空数组 []
        List<Object> testList1 = null;
        List<Object> resultList1 = Collections.singletonList(flat(testList1));

        System.out.println(("************* 测试数据 for 展开多层嵌套数组列表*********** \n"));
        System.out.println(("case 1: 输入空数组 \n 输出：" + resultList1));

        // case2: 一层数组[1,2,3]
        //构建嵌套的数组列表
        List<Object> testList2 = new ArrayList<>();
        testList2.add(1);
        testList2.add(2);
        testList2.add(3);
        List<Object> resultList2 = Collections.singletonList(flat(testList2));
        System.out.println(("case 2: 输入一层数组[1] \n 输出：" + resultList2));

        // case3: 一层数组含空元素[1,2,3, ]
        //构建嵌套的数组列表
        List<Object> testList3 = new ArrayList<>();
        testList3.add(1);
        testList3.add(2);
        testList3.add(3);
        testList3.add(null);
        List<Object> resultList3 = Collections.singletonList(flat(testList3));
        System.out.println(("case 3: 输入一层数组含空元素[1,2,3, ] \n 输出：" + resultList3));

        // case4: 二层嵌套含空元素 [1,2,3,[]]
        //构建嵌套的数组，
        List<Object> testList4 = new ArrayList<>();
        testList4.add(1);
        testList4.add(2);
        testList4.add(3);

        List<Object> subList4 = new ArrayList<>();
        subList4.add(null);
        List<Object> resultList4 = Collections.singletonList(flat(testList4));
        System.out.println(("case 4: 输入二层嵌套含空元素 [1,2,3,[]] \n 输出：" + resultList4));

        // case5: 二层嵌套不含空元素 [1,2,3,[4,5,6]]
        //构建嵌套的数组，
        List<Object> testList5 = new ArrayList<>();
        testList5.add(1);
        testList5.add(2);
        testList5.add(3);

        List<Object> subList5 = new ArrayList<>();
        subList5.add(4);
        subList5.add(5);
        subList5.add(6);

        List<Object> resultList5 = Collections.singletonList(flat(testList5));
        System.out.println(("case 5: 输入二层嵌套不含空元素 [1,2,3,[4,5,6]] \n 输出：" + resultList5));


        // case6: 三层嵌套含空元素 [1,2,3,[4,5,6,[7,8,9, ]]]

        //构建嵌套的数组
        List<Object> testList6 = new ArrayList<>();
        testList6.add(1);
        testList6.add(2);
        testList6.add(3);

        List<Object> subList6_1 = new ArrayList<>();
        subList6_1.add(4);
        subList6_1.add(5);
        subList6_1.add(6);
        testList6.add(subList6_1);

        List<Object> subList6_2 = new ArrayList<>();
        subList6_2.add(7);
        subList6_2.add(8);
        subList6_2.add(9);
        subList6_2.add(null);
        testList6.add(subList6_2);

        List<Object> resultList6 = Collections.singletonList(flat(testList6));
        System.out.println(("case 6: 输入三层嵌套含空元素 [1,2,3,[4,5,6,[7,8,9, ]]], \n 输出：" + resultList6));

        // case7: 三层嵌套不含空元素 [1,2,3,[4,5,6,[7,8,9,10]]]
        //构建嵌套的数组
        List<Object> testList7 = new ArrayList<>();
        testList7.add(1);
        testList7.add(2);
        testList7.add(3);

        List<Object> subList7_1 = new ArrayList<>();
        subList7_1.add(4);
        subList7_1.add(5);
        subList7_1.add(6);
        testList7.add(subList7_1);

        List<Object> subList7_2 = new ArrayList<>();
        subList7_2.add(7);
        subList7_2.add(8);
        subList7_2.add(9);
        subList7_2.add(10);
        testList7.add(subList7_2);

        List<Object> resultList7 = Collections.singletonList(flat(testList7));
        System.out.println(("case 7: 输入三层嵌套不含空元素 [1,2,3,[4,5,6,[7,8,9,10]]]，\n 输出：" + resultList7));


        // case8: 二层嵌套不含空元素 ["hello, ","you are welcome! ",["enjoy your  travel","have a nice day."]]
        //构建嵌套的数组
        List<Object> testList8 = new ArrayList<>();
        testList8.add("hello,");
        testList8.add(" you are welcome! ");
        List<Object> subList8 = new ArrayList<>();
        subList8.add("enjoy your travel");
        subList8.add("have a nice day.");
        testList8.add(subList8);

        List<Object> resultList8 = Collections.singletonList(flat(testList8));
        System.out.println(("case 8: 测试String 字符串嵌套 \n 输出：" + resultList8));

    }
}




