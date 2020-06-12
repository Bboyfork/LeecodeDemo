package com.demo.test22;
/*
LeeCode 15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例：
    给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    满足要求的三元组集合为：
        [[-1, 0, 1],
         [-1, -1, 2]]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 超时，想不透啊
 * 凭啥人家的不超时，明明这两种都不太能省略..
 * @author Bboy_fork
 * @date 2020年6月12日15:45:08
 * */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> newList = new ArrayList<>();     //创建新集合
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        //getSumZero(0,1,2,nums,result);
        Arrays.sort(nums);
        getSumZero(nums,result);
        Iterator<List<Integer>> it = result.iterator();//根据传入的集合(旧集合)获取迭代器
        while(it.hasNext()) {
            List<Integer> next = it.next();
            if (!newList.contains(next)) {
                newList.add(next);
            }
        }
        return newList;
    }
*/
/* //回溯好像真的不是很美丽
    public void getSumZero(int a,int b ,int c,int[] nums,List result){
        System.out.println("a-->"+a+"|--->"+b+"|-c-->"+c);
        if(!(a<b && b<c && c<nums.length)){
            return;
        }

        System.out.println("a-->"+a+"|--->"+b+"|-c-->"+c);
        if(0 == nums[a] + nums[b] + nums[c]){
            ArrayList<Integer> integers = new ArrayList<Integer>();
            integers.add(nums[a]);
            integers.add(nums[b]);
            integers.add(nums[c]);
            result.add(integers);
        }
        getSumZero(a,b,c+1,nums,result);
        getSumZero(a,b+1,c+1,nums,result);
        getSumZero(a+1,b+1,c+1,nums,result);
    }
    */

    public void getSumZero(int[] nums,List result){

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    //System.out.println(i+"-=-"+j+"-=-"+k);
                    if(0 == nums[i] + nums[j] + nums[k]){
                        ArrayList<Integer> integers = new ArrayList<Integer>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        result.add(integers);
                    }
                }
            }
        }
    }

    public static void main (String[] args){
        int[] temp = new int[]{-1, 0, 1, 2, -1, -4};

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(temp);
        System.out.println("结果：：：--》");
        for (List<Integer> integers:lists) {
            for (Integer iint:integers) {
                System.out.print(iint);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}