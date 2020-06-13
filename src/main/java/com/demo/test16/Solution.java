package com.demo.test16;

/*
LeeCode 46 	把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：
    0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法

示例 1:
    输入: 12258
    输出: 5
    解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

理解：
    此题可转换为 拆分数字， 判断由多少个小于25的数组成，求排列组合的问题
    进一步，全是1位数字肯定可以 两位数字小于25的可以，

    所以这可以用一个递归的函数来解决，
    test(){
        //如果递归到最后成功，则result+1
        //匹配一位数，
        //匹配两位数，
        //并将其从数字中减掉，并且递归，

    }
 */

/**
 * @author Bboy_fork
 * @date 2020年6月9日11:13:15
 * */
class Solution {

    /*
    int result = 0;

    public int translateNum(int num) {
        findWay(num);
        //(num+"").toCharArray();
        //突然想到这里转为字符串再转为字符数组肯定很消耗资源，
        // 所以干脆使用字符串截取然后转数字，好像消耗也不小，
        //能不能使用位运算呢？ 但是/10 毕竟不是/2  不过好像也不用位运算 直接传递int类型的值，取模就ok啊

        return result;
    }

//看看我写的 什么破玩意 废弃！
    public void findWay(int num){
        System.out.println(num + "<===num 初始====");
        int i = num/10;
        int j = num/100;
        System.out.println(i + "<===i + j====>"+j);
        if(num>=10){
            if(i!=0){
                findWay(i);
            }
            if(j!=0){
                findWay(j);
            }
        }

        if(num<10){
            result++;
            return;
        }else if(num < 26){
            result++;
            return;
        }else if(num <100){
            return;
        }
    }
*/

    /**
    * 递归还是ojbk的
    * */
    public int translateNum1(int num) {
        if (num<=9) {return 1;}
        int ba = num%100;
        if(ba<=9||ba>=26){
            return translateNum(num/10);
        }else{
            return translateNum(num/10)+translateNum(num/100);
        }
    }


    public static void main (String[] args){
        Solution solution = new Solution();
        int result = solution.translateNum(12258); //12258
        System.out.println("result===>>>>>>"+result);
    }

/*
* 官方解法： 还没看懂*/
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0;
        int q = 0;//
        int r = 1;//结果
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }

            //两位
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

}