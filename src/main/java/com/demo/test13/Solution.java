package com.demo.test13;

import java.util.ArrayList;

public class Solution {

    public int massage(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
    public void multiplicative(int m,int n){

        for (int i = 1;i<=m ;i++){
            for (int j = 1;j<=n ;j++){
                System.out.print(i*j+"\t");
            }
            System.out.println();
        }

    }
    public static void main (String[] args){

        int []  x = new int[10];
        System.out.println(x[9]);
        String str[] = new String[10];
        System.out.println(str[2] +"<---");


        Integer integer1 = new Integer(25);       //500            //25
        Integer integer2 = new Integer(25);

        Integer integerx = Integer.valueOf(25);
        Integer integery = Integer.valueOf(127);

        if(integerx == integer1){
            System.out.println("127127127");
        }

        Integer integerx2 = Integer.valueOf(-129);
        Integer integery2 = Integer.valueOf(-129);

        if(integerx2 == integery2){
            System.out.println("-128128128");
        }
        System.out.println("========================");


        Integer integerx3 = Integer.valueOf(-127);
        Integer integery3 = Integer.valueOf(-127);

        if(integerx3 == integery3){
            System.out.println("-127127127");
        }




        if (integer1.equals(integer2)){
            System.out.println("我就不信了 有啥区别");   //这个输出了
        }
        if(integer1 == integer2){
            System.out.println("我就是这么想的啊");
        }

        System.out.println(integer1 == integer2);       //false
        System.out.println(integer1.equals(integer2));  //true
        System.out.println(integer2.equals(25));       //true

        int arr[] = new int[]{2,8,9,3,1};
        System.out.println(new Solution().massage(arr));
        //乘法表尝试
        //new Solution().multiplicative(5,5);
        new Solution().multiplicativeResult(2,3,5);
    }
    public int multiplicativeResult(int m,int n,int k){
        int lo = 1, hi = m * n + 1;
        int mid, count;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            count = 0;
            for (int i = 1; i <= m; i++) {
                count += (mid/i > n ? n : mid/i);
            }
            if (count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
abstract class xxd{

}
