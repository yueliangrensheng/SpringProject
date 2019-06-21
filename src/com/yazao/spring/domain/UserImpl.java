package com.yazao.spring.domain;

public class UserImpl implements IUser{

    public UserImpl() {
        System.out.println("User 构造方法。。。。。。");
    }

    public void run(){
        System.out.println("run");
    }

    @Override
    public void add() {
        int i = 1/0;
        System.out.println("------ add ------");
    }

    @Override
    public void delete() {
        System.out.println("------ delete ------");
    }

    @Override
    public void update() {
        System.out.println("------ update ------");
    }

    @Override
    public void query() {
        System.out.println("------ query ------");
    }

    @Override
    public String getName() {
        return "UserImpl";
    }

    public void init(){
        System.out.println("User init ------");
    }

    public void destroy(){
        System.out.println("User destroy ------");
    }


    public void delete(int index) {
        System.out.println("------ delete ------ index= " + index);
    }
}
