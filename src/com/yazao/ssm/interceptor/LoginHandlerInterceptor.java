package com.yazao.ssm.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 应用场景：在访问showlist.action页面时候，判断是否有 登录状态，如果没有，跳转到登录页面，否则进入showlist.action页面
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截之前处理方法 返回值：true：放行； false：拦截

        Object username = request.getSession().getAttribute("username");

        if (username == null) {
            //未登录 --- 拦截并跳转到 登录页面

            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;

                //如果是登录请求，辣么放行
                if ("login".equals(handlerMethod.getMethod().getName())) {
                    return true;
                }
            }

            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            return false;
        } else {
            //已登录 --- 放行
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //拦截执行处理方法
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //拦截之后处理方法
    }
}
