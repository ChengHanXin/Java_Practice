package com.xaut.test;

import com.xaut.test2.Student;

public class Test2 {
    static int a = 10;

    static void show(){
        System.out.println(a);
    }

    static class Wu{
        public void show(){
            Test2.show();
            System.out.println(a);
        }
    }

}
