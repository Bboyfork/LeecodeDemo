package com.julyDemo.test1;

/*
LeeCode 718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

示例 1:
    输入:
        A: [1,2,3,2,1]
        B: [3,2,1,4,7]
    输出: 3
        解释:
        长度最长的公共子数组是 [3, 2, 1]。
*/
/**
 * @author Bboy_fork
 * @date 2020年7月1日10:22:05
 * */
public class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main (String[] args){
        int testA[] = new int[]{1,2,3,2,1};
        int testB[] = new int[]{3,2,1,4,7};

        Solution solution = new Solution();
        System.out.println(solution.findLength(testA, testB));

    }
}
