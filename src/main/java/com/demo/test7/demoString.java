package com.demo.test7;

public class demoString {
    public static void main (String[] args){
        String str = "abcdefg";
        char[] ch = new char[]{'a','e','i','o','u'};
        int res = 0;
        char[] chars = str.toCharArray();

        for (char c : str.toCharArray()) {
            for (char e: ch){
                if(Character.compare(c,e) == 0)
                    res++;
            }
        }
        System.out.println(res);

    }

}
