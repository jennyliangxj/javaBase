/**
 * 
 */
package com.problem.binarySearch;

/**
 * http://www.cnblogs.com/luoxn28/p/5767571.html
 * @author xiliang
 * @二分查找：将查找的键和子数组的中间键作比较
 * 如果小于中间键，就在左边子数组继续查找，
 * 如果大于中间键，就在右边子数组继续查找；
 * 如果等于中间键，中间键就是要找的元素；如果不等于中间键，不存在，返回。
 * 
 *
 */
public class BinarySearch {
	/*
	 * 每次移动left和right指针，在mid的基础上+1 或者 -1，防止出现死循环
	 */
	public int binarySearch(int[] array, int key){
		if(array == null){
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left <= right){
			int mid = (left + right) / 2;
			if(array[mid] == key){
				return mid;
			}else if(array[mid] < key){
				left = mid + 1;
			}else {
				right = mid -1;
			}
		}
		return -1;
	}
	
	public int binarySearch1(int[] array, int key){
		return -1;
	}
	
	
}
