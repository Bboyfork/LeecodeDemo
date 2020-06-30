package com.demo.test35;

/*
LeeCode 41. 缺失的第一个正数
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
示例 1:
    输入: [1,2,0]
    输出: 3
示例 2:
    输入: [3,4,-1,1]
    输出: 2
示例 3:
    输入: [7,8,9,11,12]
    输出: 1
*/

/**
 * @author Bboy_fork
 * @date 2020年6月27日14:22:51
 * */
public class Solution {
    public int firstMissingPositive(int[] nums) {

        /*
        这个东西 可以每次都遍历，找到就下一次循环，找不到就gg 直接返回

        */

        boolean flag = true;
        int i = 0;
        do{
            //nums[i];
        }while (flag);

        return 0;
    }

    public static void main(String args[]){
        //int test[] = new int[]{7,8,9,11,12};
        //int test[] = new int[]{3,4,-1,1};
        int test[] = new int[]{1,2,0};
        Solution solution = new Solution();
        int i = solution.firstMissingPositive(test);
        System.out.println(i);
    }
}
