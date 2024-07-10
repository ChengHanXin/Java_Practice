package com.mutilthread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*   定义一个类MyCallable类来实现Callable接口
             在MyCallable中重写call方法
             创建MyCallable对象
             创建Future的实现类FutureTask对象，将MyCallable交给其管理
             创建Thread对象，将FutureTask对象作为构造方法参数
             启动线程
             调用get方法，获取线程结果
        */

        MyCallable myCallable = new MyCallable();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);

        Thread thread = new Thread(futureTask);

        thread.start();

        int res = futureTask.get();

        System.out.println(res);

    }
}
