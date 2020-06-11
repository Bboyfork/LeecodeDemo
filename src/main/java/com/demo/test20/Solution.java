package com.demo.test20;

/*
LeeCode 739. 每日温度
根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
如果之后都不会升高，请在该位置用 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
提示：
    气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
*/
/**
 * @author Bboy_fork
 * @date 2020年6月11日09:27:31
 * */
class Solution {


    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int j=i+1;
            int temp=0;
            do{
                if(j == T.length){
                    result[i] = 0;
                    j=0;
                    break;
                }
                temp = T[j++];
            }while (temp<=T[i]);
            if(j !=0){
                result[i] = j-i-1;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
