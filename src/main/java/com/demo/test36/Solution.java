package com.demo.test36;

/*
LeeCode 215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
    输入: [3,2,1,5,6,4] 和 k = 2
    输出: 5
示例 2:
    输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    输出: 4
*/
/**
 *
 **/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] numsSecond = new int[nums.length];
        for(int i =0;i<k;i++){
            int temp = -9999;
            for(int j = 0;j<nums.length;j++){
                if(temp<nums[j]){
                    numsSecond[i] = nums[j];
                }
            }
        }
        return numsSecond[k-1];
    }

}
