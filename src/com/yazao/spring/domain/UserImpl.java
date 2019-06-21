package com.yazao.spring.domain;

public class UserImpl implements IUser{

    public UserImpl() {
        System.out.println("构造方法。。。。。。");
    }

    public void run(){
        System.out.println("run");
    }

    @Override
    public void add() {
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

    public void init(){
        System.out.println("------ init ------");
    }

    public void destroy(){
        System.out.println("------ destroy ------");
    }
}
