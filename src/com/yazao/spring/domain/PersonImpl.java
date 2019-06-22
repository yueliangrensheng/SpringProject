package com.yazao.spring.domain;

import org.springframework.stereotype.Component;

@Component(value = "personImpl")
public class PersonImpl implements IUser{

    public PersonImpl() {
        System.out.println("PersonImpl 构造方法。。。。。。");
    }

    public void run(){
        System.out.println("run");
    }

    public void add() {
        int i = 1/0;
        System.out.println("------ add ------");
    }

    public void delete() {
        System.out.println("------ delete ------");
    }

    public void update() {
        System.out.println("------ update ------");
    }

    public void query() {
        System.out.println("------ query ------");
    }

    public String getName() {
        return "PersonImpl";
    }

    public void init(){
        System.out.println("PersonImpl init ------");
    }

    public void destroy(){
        System.out.println("PersonImpl destroy ------");
    }


    public void delete(int index) {
        System.out.println("------ delete ------ index= " + index);
    }
}
