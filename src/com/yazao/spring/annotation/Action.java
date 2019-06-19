package com.yazao.spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "action")
public class Action {
    @Value(value = "runAction")
    private String actionName;

    @Override
    public String toString() {
        return "Action{" +
                "actionName='" + actionName + '\'' +
                '}';
    }
}
