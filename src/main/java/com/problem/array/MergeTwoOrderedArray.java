package com.problem.array;

/**
 * @description:
 * @author: liangxiujie
 * @create: 2019-02-19
 * 合并两个有序数组成一个有序数组
 */

public class MergeTwoOrderedArray {

    /**
     * https://www.cnblogs.com/clarke157/p/6910425.html
     * 新建一个数组,长度为两个数组长度之和，将两个数组都copy到新数组，然后排序。
     * 有两种实现思路：
     * 1. 定义一个新数组，长度为两个数组长度之和，将两个数组都copy到新数组，然后排序。
     * 2. 给两个数组分别定义一个下标，最大长度是数组长度减一，按位循环比较两个数组，较小元素的放入新数组，下标加一（注意，较大元素对应的下标不加一），
     * 直到某一个下标超过数组长度时退出循环，此时较短数组已经全部放入新数组，较长数组还有部分剩余，最后将剩下的部分元素放入新数组，大功告成。
     *
     */
    public static int[] merge(int[] arr1,int[] arr2){
        if(arr1 == null && arr2 == null){
            return null;
        }
        if(arr1 != null && arr2 == null){
            return arr1;
        }
        if (arr1 == null && arr2 != null){
            return arr2;
        }

        int[] result = new int[arr1.length + arr2.length];

        for(int i = 0; i < arr1.length; i++){
            result[i] = arr1[i];
        }

        for (int j = 0; j < arr2.length;j++){
            result[arr1.length + j] = arr2[j];
        }

        //新数组排序

        int result_lenght = result.length;
        for(int m = 0; m < result_lenght -1;m++){
            for(int n = 0; n < result_lenght -1 -m ; n++){
                if(result[n+1] <result[n]){
                    int temp = result[n+1];
                    result[n+1] = result[n];
                    result[n] = temp;
                }
            }
        }

        for(int x = 0; x < result_lenght; x++){
            System.out.print(result[x] + " ");
        }
        return result;
    }


    public static int[] merge2(int[] arr1,int[] arr2){
        if(arr1 == null || arr2 == null){
            return (arr1 != null) ? arr1 : arr2;
        }

        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                result[k++] = arr1[i++];
            } else{
                result[k++] = arr2[j++];
            }
        }

        while( i < arr1.length){
            result[k++] = arr1[i++];
        }
        while(j < arr2.length){
            result[k++] = arr2[j++];
        }

        for(int x = 0; x < result.length; x++){
            System.out.print(result[x] + " ");
        }
        return result;
    }


    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,4,5,5,8,8,9,10};
        int[] arr2 = {3,4,5,6,6,7,8,10,11,13};

        int[] result = merge(arr1,arr2);
        System.out.println();
        int[] result2 = merge2(arr1,arr2);
    }
}
