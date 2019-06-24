# SpringMVC 入门程序
场景：浏览器输入 list.action 跳转到一个商品列表页面

步骤：
1. 创建web工程 (springMVC表现层框架，需要web工程)
2. 添加jar：springMVC、spring、junit相关jia包
3. 在web.xml中添加一个DispatcherServlet（DispatcherServlet：前端控制器，需要初始化一个SpringMVC容器）
4. 添加springmvc.xml配置文件 
5. 创建一个商品pojo
6. 创建一个商品的Controller
    传统方式：实现一个Controller接口
    注解方式：添加一个@Controller注解
7. 把Controller配置到springmvc.xml中（传统方式）
    开启包扫描器（注解方式）
8. 创建一个jsp页面
9. tomcat测试
