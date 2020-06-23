package com.demo.test29;
/*
LeeCode 67. 二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。

示例 1:
    输入: a = "11", b = "1"
    输出: "100"
示例 2:
    输入: a = "1010", b = "1011"
    输出: "10101"
*/
/**
 * @author Bboy_fork
 * @date 2020年6月23日15:55:27
 * */
public class Solution {
    public String addBinary(String a, String b) {
        //return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2) ); 直接内置函数 当然不行！
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder result = new StringBuilder();
        int len = Math.max(a.length(),b.length()),temp = 0;
        for (int i = 0; i <= len; i++) {

            temp = (i<a.length() ? a.charAt(i) -'0':0)+( i<b.length()? b.charAt(i) - '0':0) + temp;
            if(temp == 2){
                temp = 0;
                result.append(temp);
                temp = 1;
            }else if(temp == 3){
                temp = 1;
                result.append(temp);
            }else {
                result.append(temp);
                temp = 0;
            }
        }
        result.reverse();
        if(result.indexOf("1")<0){
            return "0";
        }

        return result.substring(result.indexOf("1"));
    }

    public static void main (String[] args){

        //String a = "11", b = "1";
        // 100

        //String a = "1010", b = "1011";
        // 10101

        //String a="10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
        //   b="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        //"110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
        //"110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
        String a = "0",b ="0";
        //String a = "11" ,b ="1";
        Solution solution = new Solution();
        String result = solution.addBinary(a, b);
        System.out.println(result);
    }
}
