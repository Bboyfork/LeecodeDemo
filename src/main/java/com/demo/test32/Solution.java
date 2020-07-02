package com.demo.test32;
/*
LeeCode 16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
找出 nums 中的三个整数，使得它们的和与 target 最接近。
返回这三个数的和。假定每组输入只存在唯一答案。

示例：
    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
*/

import java.util.Arrays;

/**
 * @author Bboy_fork
 * @date 2020年6月24日17:05:42
 * */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 65535;
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {//i 为第一个值
            //肯定是不行的 得优化时间
            //int tempx =
            for (int j = i+1; j < nums.length - 1; j++) {//j 为第二个值

                for (int k = j + 1; k < nums.length; k++) {
                    System.out.println(nums[i]+"<--->"+nums[j]+"<--->"+nums[k]);
                    result = Math.abs(nums[i]+nums[j]+nums[k] - target)< Math.abs(result-target) ? nums[i]+nums[j]+nums[k] : result;
                }
            }
        }

        return result;
    }

    public static void main (String[] args){
        int test[] = new int[]{-1,2,1,-4};

        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(test, 1));
    }
}
