package com.demo.test19;
/*
LeeCode 01.02. 判定是否互为字符重排
给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

示例 1：
    输入: s1 = "abc", s2 = "bca"
    输出: true
示例 2：
    输入: s1 = "abc", s2 = "bad"
    输出: false
说明：
    0 <= len(s1) <= 100
    0 <= len(s2) <= 100
*/

import java.util.Arrays;

/**
 * @author Bboy_fork
 * @date 2020年6月10日14:58:34
 * */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }
}
