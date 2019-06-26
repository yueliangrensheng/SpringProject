package com.yazao.ssm.controller;

import com.yazao.ssm.domain.Items;
import com.yazao.ssm.domain.QueryVo;
import com.yazao.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    public ItemService itemService;

    //展示商品列表界面
    //对应操作： /showlist.action
    // QueryVo queryVo : 这里是 绑定包装的POJO，数据来自 itemList.jsp的 查询条件：input标签的 items.name 和 items.price

    //在QueryVo中定义一个属性 int [] ids，同样，也是可以接到 ids数据的。这是因为 只要满足 jsp页面的name值 和 形参中的定义相匹配，就可以填充数据
    //对于集合参数，只能绑定到POJO中，如果在形参中直接出现集合，辣么在jsp页面中的数据 映射不到 形参中的集合中。
    @RequestMapping(value = "/showlist")
    public String showList(Model model, QueryVo queryVo, int [] ids, ArrayList<Items> itemsList) {

        List<Items> allData = itemService.findAll(queryVo);
        model.addAttribute("itemList", allData); //这个 key == itemList 是在  itemList.jsp 页面中的

        return "itemList";

    }

    //展示修改界面
    //对应修改操作： itemEdit.action?id=xx
    @RequestMapping(value = "/itemEdit")
    public String showItemEdit(Model model, @RequestParam(value = "id") int itemId) {
        Items itemData = itemService.findById(itemId);
        model.addAttribute("item", itemData); // item这个key 是在  editItem.jsp 页面中
        return "editItem";
    }

    //修改商品信息
    @RequestMapping(value = "/updateitem")
    public String updateItem(Model model, Items items) {
        int index = itemService.update(items);

        if (index > 0) {
            return "success";
        }
        return "";
    }
}
