package com.suanfa;
/**
 * @description:
 * @author: jenny liang
 * @date: 2025/3/27  17:41
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 思路：要知道数组的元素在内存地址中是连续的，不能单独删除数组中的某个元素，只能覆盖。

 */
public class Leetcode_277_RemoveElement {

    /**
    //暴力解法:两层for循环，一个for循环遍历数组元素 ，第二个for循环更新数组。
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)

     暴力法的本质是什么:
    双层循环,第一层循环比较每个元素，第二层循环删除 与 val 相等的元素（把后面的数组往前挪）
    注意：第二层循环挪完之后，第一层的 i 要减 1 ，继续参与比较

     **/
    public int solution1(int[] nums, int val){
        //暴力法
        int n = nums.length;
        for(int i = 0; i< n; i++){ //第一层循环比较每个元素
            if(nums[i] == val){
                for(int j = i+1; j<n;j++){ //第二层循环删除 与 val 相等的元素（把后面的数组往前挪）
                    nums[j-1] = nums[j];
                }
                i--; // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                n--; // 此时数组的大小-1
            }
        }
        return n;
    }


    /**
    //快慢指针:通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
    //定义快慢指针
    //快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
    //慢指针：指向更新 新数组下标的位置;

    fast指针遍历整个数组，slow指针维护结果数组；一开始结果数组长度为0（即slow=0）；

    当fast指针遍历到属于结果数组的元素时（也就是值不等于val的元素），就将当前fast指针指向的元素与slow位置交换，元素进入结果数组，此时结果数组长度+1，因此slow+1，指向下一个位置；
    当fast指针遍历到不属于结果数组的元素时（也就是值等于val的元素），直接不管（因为不用进入结果数组）。

    当fast指针遍历完整个数组之后，slow维护的就是结果数组，返回slow的值，也就是结果数据的长度。



     2、快慢指针:
     替换双层循环
     快指针做第一层循环比较每一个元素
     慢指针接收 fast !== val 的元素，相当于第二层循环的删除
     **/

    public int solution2(int[] nums, int val){
        int slowIndex = 0;
        for(int fastIndex = 0;  fastIndex < nums.length; fastIndex++){
            if(nums[fastIndex] != val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
