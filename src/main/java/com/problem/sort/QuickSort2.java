package com.problem.sort;

/**
 * @description:
 * @author: liangxiujie
 * @create: 2019-02-18
 *
 *
 */

/*
 * 快速排序采用了分治策略。就是在一个数组中取一个基准数字，把小的数放基准的左边，大的数放基准的右边。
 * 基准左边和右边分别是新的序列。在新的序列中再取一个基准数字，小的放左边，大的放右边。
 * 这个里面用到的递归。我们需要三个参数，一个是数组，另外两个是序列的边界
 *
 * https://blog.csdn.net/qq_34218892/article/details/80708359
 */
public class QuickSort2 {

    public static void quickSortHelp(int[] arr) {
        quickSort(arr,0, arr.length-1);
    }

    public static void quickSort(int[] arr,int low, int high) {
        if(low<high) {
            int partition = partition(arr,low,high);
            quickSort(arr,low, partition-1);  //对低子表递归排序
            quickSort(arr,partition+1, high);  //对高子表递归排序
        }

    }
    public static int partition(int[] arr,int low,int high) {
        while(low<high) {
            while(arr[high]>=arr[low] && low<high){
                high--;
            }
            Swap(arr,high,low);

            while(arr[low]<=arr[high] && low<high) {
                low++;
            }
            Swap(arr,high,low);
        }
        return low;
    }
    public static void Swap(int[] arr,int high,int low) {
        int temp = arr[low];
        arr[low] =arr[high];
        arr[high] = temp;
    }
    public static void main(String[] args) {
        int[] array = { 2, 8, 5, 6, 10, 5, 4, 6, 11, 15, 3 };
        quickSortHelp(array);
        for (int s : array) {
            System.out.print(s + " ");
        }
    }
}
