package com.demo.test17;
/*
LeeCode 19 回文数
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    示例 1:
        输入: 121
        输出: true
    示例 2:
        输入: -121
        输出: false
        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
*/
/**
 * @author Bboy_fork
 * @date 2020年6月10日09:31:18
 * */
public class Solution {
    /**
     * 字符串对比 当然ojbk 但是应该不是特别美丽 ，
     * 直接使用int 基本数据类型 当然效率更高。
     * 原本想要递归 但是发现好像并不用， 直接翻转数字好像就可..
     * */
    public boolean isPalindrome(int x) {
        int temp =0;
        if (x<0 || (x != 0 && x%10 ==0) ){
            return false;
        }else { //大于等于0 且 除了 多位数个位为零的 全进来了
            while (x > temp){
                temp = temp*10 + x % 10;
                x /= 10;
            }
            return x == temp || x == temp/10;
        }
    }

    public static void main (String[] args) {
        Solution solution = new Solution();
        System.out.println("result ==>>>>>>"+solution.isPalindrome(-1));
    }
}
