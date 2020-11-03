package com.julyDemo.test10;

import com.julyDemo.test9.UserDao;

import java.lang.reflect.Method;

/**
 * 测试
 * @author Bboy_fork
 * @date 2020年8月25日13:58:24
 * */
public class Solution {
    public static void main (String[] args) throws Exception{

        Solution solution = new Solution();
        solution.test();
    }

    public void test()throws Exception{

        UserDao userDao = new UserDao();



        //

        //类
        Class classzz = userDao.getClass();

        //方法
        Method selectUser = classzz.getMethod("selectUser", String.class);

        //参数
        String parammmm = "9";

        Object invoke = selectUser.invoke(new UserDao(), parammmm);

        System.out.println(invoke);


    }

}
