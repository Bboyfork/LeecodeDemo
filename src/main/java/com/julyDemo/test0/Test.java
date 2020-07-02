package com.julyDemo.test0;

/**
 * 测试类 抬手就测那种
 * @author Bboy_fork
 * @date 2020年7月2日14:59:33
 * */
public class Test {

    public String[] test01(String str){
        return str.split("\\|");
    }

    private static String tenancy_ID = "";

    public static void main (String[] args){

/*        Test test = new Test();
        String[] strings = test.test01("FH183A200|841001FIQ1592992522000624|20200624|20200624095527000|010331441|DA0030000|840|C|6710.00|0000000000|");

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }*/
        String interfaceID = "FH183A200";
        String file_globalTraceID = "841001FIQ1592992522000624";
        String file_transactionDate = "20200624";
        String file_transactionTimestamp = "20200624095527000";
        String inst_ID = "010331441";
        tenancy_ID = "DA0030000";
        String currencyCode = "840";
        String drcrCode = "C";
        String tranAmt = "6710.00";

        //String sys_serialID = StringUtil.PIC9V9(String.valueOf(recordNo), 10); //"0000000001";

        Test0702 test0702 = new Test0702(
                null,							// balance sum of Ans file, no need.
                file_transactionDate,
                file_transactionTimestamp,
                inst_ID,
                "",
                tenancy_ID,
                currencyCode,
                drcrCode,
                tranAmt,
                file_globalTraceID
                //sys_serialID
        );

    }
}
