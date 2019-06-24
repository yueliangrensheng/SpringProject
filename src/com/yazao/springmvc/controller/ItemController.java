package com.yazao.springmvc.controller;

import com.yazao.springmvc.domain.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//传统方式实现 -- 弊端：只可以定义一种请求方式。如： xxx/list.action; 不能再处理 xxx/edit.action 这样的请求
public class ItemController implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {

        //模拟数据
        List<Items> list = new ArrayList<Items>();

        for (int i = 0; i < 10; i++) {
            Items items = new Items();
            items.setId(i);
            items.setCreatetime(new Date());
            items.setName("小米手机" + i);
            items.setDetail("国产");
            items.setPrice((float) (1000 * i));
            list.add(items);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", list);//相当于是把数据放到了request域


        //设置逻辑视图：就是jsp路径
        modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
        return modelAndView;
    }
}
