package com.yazao.springmvc.controller;

import com.yazao.springmvc.domain.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//注解方式
public class ItemController2{

    @RequestMapping("/list2")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {

        //模拟数据
        List<Items> list = new ArrayList<Items>();

        for (int i = 0; i < 10; i++) {
            Items items = new Items();
            items.setId(i);
            items.setCreatetime(new Date());
            items.setName("华为手机" + i);
            items.setDetail("国产");
            items.setPrice((float) (1000 * i));
            list.add(items);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", list);//相当于是把数据放到了request域


        //设置逻辑视图：就是jsp路径: "/WEB-INF/jsp/itemList.jsp"
        //通过在springmvc.xml中配置视图解析器的prefix和suffix，来在code中简写配置视图的路径
        modelAndView.setViewName("itemList");
        return modelAndView;
    }
}
