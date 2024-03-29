package com.yazao.ssm.controller;

import com.yazao.ssm.domain.Items;
import com.yazao.ssm.domain.QueryVo;
import com.yazao.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
// 在Controller类上添加 @RequestMapping注解后，需要 请求地址是 xxx/item/showlist.action 的才可以进入到这类的方法。
@RequestMapping(value = "/item/")
public class ItemController {

    @Autowired
    public ItemService itemService;

    //展示商品列表界面
    //对应操作： /showlist.action
    // QueryVo queryVo : 这里是 绑定包装的POJO，数据来自 itemList.jsp的 查询条件：input标签的 items.name 和 items.price

    //在QueryVo中定义一个属性 int [] ids，同样，也是可以接到 ids数据的。这是因为 只要满足 jsp页面的name值 和 形参中的定义相匹配，就可以填充数据
    //对于集合参数，只能绑定到POJO中，如果在形参中直接出现集合，辣么在jsp页面中的数据 映射不到 形参中的集合中。
    //RequestMapping: 多请求地址可同时指定到一个方法上；还可以指定多个请求方式
    @RequestMapping(value = {"/showlist", "/showlist2"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String showList(Model model, QueryVo queryVo, int[] ids, ArrayList<Items> itemsList) throws Exception {

        List<Items> allData = itemService.findAll(queryVo);
        model.addAttribute("itemList", allData); //这个 key == itemList 是在  itemList.jsp 页面中的

        return "itemList";

    }

    //展示修改界面
    //对应修改操作： itemEdit.action?id=xx
    @RequestMapping(value = "/itemEdit")
    public String showItemEdit(Model model, @RequestParam(value = "id") int itemId) throws Exception {
        Items itemData = itemService.findById(itemId);
        model.addAttribute("item", itemData); // item这个key 是在  editItem.jsp 页面中
        return "editItem";
    }

    //展示修改界面
    //对应修改操作： itemEdit/2
    @RequestMapping(value = "/itemEdit/{id}")
    public String showItemEdit2(Model model, @PathVariable(value = "id") int itemId) throws Exception {
        Items itemData = itemService.findById(itemId);
        model.addAttribute("item", itemData); // item这个key 是在  editItem.jsp 页面中
        return "editItem";
    }

    //修改商品信息 --- 重定向
    @RequestMapping(value = "/updateitem")
    public String updateItem(Model model, Items items, MultipartFile pictureFile, HttpServletRequest request) throws Exception {
        String root = request.getServletContext().getRealPath("/");
        //root =  /Users/xxx/Documents/work/JavaWebProject/SpringProject/out/artifacts/SpringProject_war_exploded/
        if (pictureFile != null && !pictureFile.isEmpty()) {
            //保存文件到项目工程目录：res/pic
            try {
                String originalFilename = pictureFile.getOriginalFilename();
                String fileName = UUID.randomUUID().toString();
                String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
                pictureFile.transferTo(new File(root + "res/pic/" + (fileName + ext)));

                items.setPic(fileName + ext);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }


        int index = itemService.update(items);

        if (index > 0) {

            //重定向 --- 通知浏览器，让浏览器重新发起请求，使用的是两个不同的request域
//            return "redirect:showlist.action";

            //请求转发 --- 浏览器保留原有的请求地址，使用的是同一个request域
            return "forward:showlist.action";
        }
        return "";
    }

    //修改商品信息 -- 请求转发
//    @RequestMapping(value = "/updateitem")
//    public void updateItem(Model model, Items items, HttpServletRequest request, HttpServletResponse response) throws Exception{
//        int index = itemService.update(items);
//
//        if (index > 0) {
//
//            // 如果想要跳转页面，只能使用servlet方式 --- 请求转发
//
//            try {
//                request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    @RequestMapping(value = "/updateitemByAjax")
    @ResponseBody // 作用是：把即将返回的对象转成json字符串 并且写回到浏览器
    public Map<String, Object> updateItemByAjax(@RequestBody Items item) {//RequestBody: 强制要求传入的参数类型是json

        Map<String, Object> map = new HashMap<>();
        try {
            itemService.update(item);
            map.put("success", true);
            map.put("message", "操作成功");
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "操作失败");
        } finally {
        }

        return map;
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        session.setAttribute("username", username);
        return "success";
    }

}
