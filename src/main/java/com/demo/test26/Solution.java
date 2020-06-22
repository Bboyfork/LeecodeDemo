package com.demo.test26;

/*
LeeCode 1016. 子串能表示从 1 到 N 数字的二进制串
给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，
如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。


读错题了
    查看字符串0110 条件3
        不是遍历 0 01 011
        也不是 0 1 1
    而是tmd遍历 1 2 3
    擦！
*/
/**
 * @author Bboy_fork
 * @date 2020年6月21日19:58:26
 * */
public class Solution {
    public boolean queryString(String S, int N) {
        for (int i = 0; i <= N; i++) {
            //String s = Integer.toBinaryString(new Integer(S.substring(0, i+1)));
            //String s = Integer.toBinaryString(S.charAt(i)-'0');
            String s = Integer.toBinaryString(i);

            System.out.println("s-->"+s);
            if(!S.contains(s)){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        boolean b = solution.queryString("1", 1);
        System.out.println(b);
    }
}
