package com.yazao.spring;

public class User {

    public User() {
        System.out.println("构造方法。。。。。。");
    }

    public void run(){
        System.out.println("run");
    }

    public void init(){
        System.out.println("init-----------");
    }

    public void destroy(){
        System.out.println("destroy ---------");
    }
}
