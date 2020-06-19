package com.demo.test24;

/*
LeeCode 70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
示例 1：
    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
    1.  1 阶 + 1 阶
    2.  2 阶

示例 2：
    输入： 3
    输出： 3
    解释： 有三种方法可以爬到楼顶。
    1.  1 阶 + 1 阶 + 1 阶
    2.  1 阶 + 2 阶
    3.  2 阶 + 1 阶

*/

/**
 * @author Bboy_fork
 * @date 2020年6月13日15:47:17
 * */
class Solution {

    /*
    int result;
    public int climbStairs(int n) {
        //尝试回溯来解决
        findTrack(n,0);
        return result;
    }

    public void findTrack(int n,int now){
        if(now == n){
            result++;
            return;
        }else if (now >n){
            return;
        }

        findTrack(n,now+1);
        findTrack(n,now+2);
    }
*/

    public static void main(String[] args){
        Solution solution = new Solution();
        int i = solution.climbStairs(23);
        System.out.println(i);
    }


    /**
     * 动态分配方式， 但是不如说是对结果规律的总结
     * */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}