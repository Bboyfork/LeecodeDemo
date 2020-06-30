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

    /*
    public int threeSumClosest(int[] nums, int target) {
        int result = 65535;
        int differenceValue = Math.abs(65535-target);
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {//i 为第一个值
            //肯定是不行的 得优化时间
//            int tempx =
            for (int j = i+1; j < nums.length - 1; j++) {//j 为第二个值

//                第三位反向进行遍历， 如果最后一个并不是最小解，
//                即先遍历的是最大解，如果未能匹配，即差值大于
                for (int k = nums.length -1 ; k > j ; k--) {
                    System.out.println(nums[i]+"<--->"+nums[j]+"<--->"+nums[k]);
                    //result = Math.abs(nums[i]+nums[j]+nums[k] - target)< Math.abs(result-target) ? nums[i]+nums[j]+nums[k] : result;
                    int tempDiffVal = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    if(differenceValue > tempDiffVal){
                        result = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }

        return result;
    }
*/
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

    public static void main (String[] args){
        //int test[] = new int[]{-1,2,1,-4};
        int test[] = new int[]{-4,-1,1,2,3,4,9};

        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(test, 1));
    }
}
