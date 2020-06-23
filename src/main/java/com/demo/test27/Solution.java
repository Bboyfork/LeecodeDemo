package com.demo.test27;

/*
LeeCode 16.18. 模式匹配
你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），
该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。
编写一个方法判断value字符串是否匹配pattern字符串。
示例 1：
    输入： pattern = "abba", value = "dogcatcatdog"
    输出： true
示例 2：
    输入： pattern = "abba", value = "dogcatcatfish"
    输出： false
示例 3：
    输入： pattern = "aaaa", value = "dogcatcatdog"
    输出： false
示例 4：
    输入： pattern = "abba", value = "dogdogdogdog"
    输出： true
    解释： "a"="dogdog",b=""，反之也符合规则

*/
/**
 * @author Bboy_fork
 * @date 2020年6月22日09:31:01
 * */
public class Solution {

    /**
     * 思路1：
     *
     * */
    public boolean patternMatching(String pattern, String value) {
        int suma = 0;
        int sumb = 0;
        //在之前，先找到ab的数量。
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'a'){
                suma++;
            }else {
                sumb++;
            }
        }
        System.out.println(suma+"<----aaaaasumbbbbb---->"+sumb);
        //再找到ab长度的可能、
        boolean flag = true;
        int alen = -1;

        while (flag){
            alen++;
            for (int j = 0; j < value.length(); j++) {        //j b的长度
                if(alen*suma + j*sumb == value.length()){
                    if(alen == j){ flag = false;}
                    System.out.println(alen + "<----i -a长度b- j ---->" +j);
                    //--------------==--
                    //现在已经求出ab所代表的的长度和出现的次数的可能了 按情况匹配生成字符串 如果成功直接return true 都没成功 则最后return false
                    String stringTemp = "";
                    String stra = "";
                    String strb = "";
                    int indexA = pattern.indexOf("a");
                    int indexB = pattern.indexOf("b");
                    stra = value.substring(indexA*alen,(indexA+1)*alen);
                    strb = value.substring(indexB*j,(indexB+1)*j);

                    for (int i = 0; i < pattern.length(); i++) {
                        if(pattern.charAt(i) == 'a'){
                            stringTemp += stra;
                        }else {
                            stringTemp += strb;
                        }
                    }
                    if(value.equals(stringTemp)){
                        return true;
                    }

                    //--------------==--
                    break;
                }
            }

        }

        return false;
    }

    public static void main (String[] args){
        Solution solution = new Solution();
        boolean b = solution.patternMatching("ababaa", "dogcatdogcatdogdog");
        System.out.println("abba"+"<----====---->"+"dogcatcatdog");
        System.out.println(b);
    }
}
