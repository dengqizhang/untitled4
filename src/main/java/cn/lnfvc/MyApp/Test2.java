package cn.lnfvc.MyApp;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args){
        ArrayList<String> array = new ArrayList<String>();
        array.add("hello");
        array.add("wolrd");
        array.add("java");

        array.add(2,"jaaa");
        System.out.println(array);
    }
}
