package com.suanfa;


/**
 * @description:
 * @author: jenny liang
 * @date: 2025/3/28  15:24
 */
public class Leetcode_59_SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];

        int startX = 0, startY = 0; //每一圈的起始点
        int offset = 1;
        int count = 1; //矩阵中需要填写的数字
        int loop = 1; //记录当前的圈数
        int i, j = 0; // i代表行，j代表列

        while (loop <= n / 2) {

            //顶部
            //左闭右开：判断循环结束时，j 不能等于 n-offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }
            //右列
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            //底部
            //左闭右开，判断循环结束时， j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            //左列
            //左闭右开，判断循环结束时，i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }

        if( n%2 ==1){ //n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] =count;
        }
        return nums;
    }
}
