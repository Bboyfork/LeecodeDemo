package com.demo.test8;

public class Solution {

    public static void main (String[] args) {

        String s1 = "xxssdfdgtret";
        String s2 = "xsxsdfdtgret";

        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        for(char a : s1.toCharArray()){
            arr1[a] += 1;
        }
        for(char a : s2.toCharArray()){
            arr2[a] += 1;
        }


    }

    public boolean isUnique(String astr) {
        long low64 = 0;
        long high64 = 0;

        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bitIndex = 1L << c - 64;
                if ((high64 & bitIndex) != 0) {
                    return false;
                }
                high64 |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((low64 & bitIndex) != 0) {
                    return false;
                }
                low64 |= bitIndex;
            }
        }
        return true;
    }
}
