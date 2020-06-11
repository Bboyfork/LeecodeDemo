package com.demo.test21;
/*
LeeCode 22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：
    输入：n = 3
    输出：["((()))",
           "(()())",
           "(())()",
           "()(())",
           "()()()"]
*/
import java.util.LinkedList;
import java.util.List;

/**
 * @author Bboy_fork
 * @date 2020年6月11日16:17:07
 * */
class Solution {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<>();
        backtrack(0,0,new char[2*n],result);
        return result;
    }
/*      智障第一版 考虑不足，flag来标识能否左右的话 ）后 -1 了 岂不是又能（了 这不和谐 重来
    public void backtrack(int flag,int place,int len,char[] track,List<String> result){
        if(track[track.length-1]==41){
            result.add(new String(track));
            return;
        }

        if(flag<0 || flag > len){
            return;
        }
        track[place+1] = '(';
        backtrack(flag+1,place+1,len,track,result);

        track[place+1] = ')';
        backtrack(flag-1,place+1,len,track,result);
    }*/

    public void backtrack(int left,int right,char[] track,List<String> result){

        //如果 ')' 数量大于'(' 显然是不匹配的，  || '(' 数量大于n 肯定也不行
        if(right>left || left>track.length/2){
            return;
        }
        if(right+left == track.length){
            result.add(new String(track));
            return;
        }

        track[left+right] = '(';
        backtrack(left+1,right,track,result);

        track[left+right] = ')';
        backtrack(left,right+1,track,result);
    }

    public static void main (String[] args){
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        for (String str:strings) {
            System.out.println(str);
        }
    }
}