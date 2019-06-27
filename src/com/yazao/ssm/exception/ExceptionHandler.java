package com.yazao.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1。自定义 处理器异常解析器
//2。还需要在 SpringMVC容器 springmvc.xml 中配置该 bean
public class ExceptionHandler implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        //跳转到 error 页面

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage",ex.getMessage());
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
