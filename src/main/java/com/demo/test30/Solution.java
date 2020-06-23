package com.demo.test30;

/*
模式匹配Temp
临时文件，另一端git忘记提交，做了一半 擦
【明天处理一下】！！！

续接思路：
    遍历能有的排列组合的情况，
    按其拟定的匹配情况，来重组字符串，然后比对如果成功return true ; 迭代最终，未能return true 则false
*/
/**
 * @author Bboy_fork
 * @date 2020年6月22日23:00:49
 * */
public class Solution {

    /**
     *
     * */
    public boolean patternMatching(String pattern, String value) {

        if( "".equals(value) && "".equals(pattern)){
            return true;
        }else if("".equals(value) || "".equals(pattern)){
            return false;
        }

        //先获取其总数情况
        int aSum = 0;
        int bSum = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'a'){
                aSum++;
            }else {
                bSum++;
            }
        }
        System.out.println(aSum + "<---asum bsum--->" + bSum);

        int aLen = 0;
        int bLen = -1;
        for (; aLen < value.length(); aLen++) {
            bLen = -1;

            for (; bLen < value.length();) {
                bLen++;
                if(value.length() == aLen * aSum + bLen * bSum){
                    System.out.println(aLen+"<----aLen==bLen--->"+bLen);

                    //此处由拿到的aLen bLen 进行匹配字符串，成功则return true 否则 不return 最终return false;
                    //----------------=-=-=-=------

                    String aTempStr = "";
                    String bTempStr = "";
                    String finalTempStr = "";

                    if(pattern.charAt(0) == 'a'){//a开
                        aTempStr = value.substring(0,aLen);
                        int bFirstIndex = pattern.indexOf("b");
                        if(bFirstIndex == -1){
                            bTempStr = "";
                        }else {
                            bTempStr = value.substring(bFirstIndex * aLen ,bFirstIndex * aLen +bLen);
                        }
                        System.out.println(aTempStr + "<-- atstr btstr -->" +bTempStr);

                        for (int i = 0; i < pattern.length(); i++) {
                            if(pattern.charAt(i) == 'a'){
                                finalTempStr += aTempStr;
                            }else {
                                finalTempStr += bTempStr;
                            }
                        }
                        if(value.equals(finalTempStr)){
                            return true;
                        }

                    }else { //b开
                        bTempStr = value.substring(0,bLen);
                        int aFirstIndex = pattern.indexOf("a");
                        if(aFirstIndex == -1){
                            aTempStr = "";
                        }else {
                            aTempStr = value.substring(aFirstIndex * bLen , aFirstIndex * bLen +aLen);
                        }
                        System.out.println(aTempStr + "<-- atstr btstr -->" +bTempStr);

                        for (int i = 0; i < pattern.length(); i++) {
                            if(pattern.charAt(i) == 'a'){
                                finalTempStr += aTempStr;
                            }else {
                                finalTempStr += bTempStr;
                            }
                        }
                        if(value.equals(finalTempStr)){
                            return true;
                        }
                    }
                    //----------------=-=-=-=------

                    break;
                }
            }
            if(aLen == bLen){
                break;
            }

        }
        return false;
    }
    public static void main(String args[]){
        Solution solution = new Solution();
        //String pattern = "abba", value = "dogcatcatdog";
        String pattern = "aaaa", value = "dogcatcatdog";
        //String pattern = "abba", value = "dogcatcatfish";
        //String pattern = "abba", value = "dogdogdogdog";
        boolean b = solution.patternMatching(pattern, value);
        System.out.println(b);
    }
}
