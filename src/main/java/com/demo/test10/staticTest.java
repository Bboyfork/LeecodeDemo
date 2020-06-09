package com.demo.test10;


import java.util.Iterator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class staticTest implements Iterator {
    static int i;
    static boolean out(char c){
        try {
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return false;
        }
    }

    public static staticTest t1 = new staticTest();
    int a = 0;

    {

        System.out.println("普通代码块");
    }
    
    static {
        System.out.println("静态代码块");
    }

    public static void test2() throws RuntimeException{

        throw new RuntimeException();
    }
    public void test3(){
        synchronized (this){

        }
    }

    public static void main (String[] argv){

            int x = 0;
            int y = 0;
            int k = 0;
            for (int z = 0; z < 5; z++) {
                if ((++x > 2) && (++y > 2) && (k++ > 2))
                {
                    x++;
                    ++y;
                    k++;
                }
            }
            System.out.println(x + "" +y + "" +k);
        String s1=new String("xyz");
        String s2=new String("xyz");
        Boolean b1=s1.equals(s2);
        Boolean b2=(s1==s2);
        System .out.print(b1+ " " +b2);
        int a = 1;
        int b = 1;
        a ^= b;
        int i = 0;

        for(out('A') ; out('B') && (i<2);out('C')){
            i++;
            out('D');
        }

        float aa = 45.0f;
        //staticTest t2 = new staticTest();
        String str = "成都市(成华区)(武侯区)(高新区)";
        Pattern p = Pattern.compile(".*?(?=\\()");

        Matcher matcher = p.matcher(str);
        if(matcher.find())
            System.out.println(matcher.group());
        str.hashCode();
        
        

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
