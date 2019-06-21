package com.yazao.spring.test;

import com.yazao.spring.domain.IUser;
import com.yazao.spring.domain.PersonImpl;
import com.yazao.spring.domain.UserImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//1。加载applicationContext.xml文件
@ContextConfiguration(value = "classpath:applicationContext.xml")
//2。使用 SpringJUnit4ClassRunner 来单元测试
@RunWith(value = SpringJUnit4ClassRunner.class)
public class SpringJunit {


    //异常信息： nested exception is org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'user' is expected to be of type 'com.yazao.spring.domain.UserImpl' but was actually of type 'com.sun.proxy.$Proxy18'
    //
    //如果：
    //@Resource(name="user")
    //private UserImpl user;
    //
    //这样定义 user的 类型 话，将会抛出上面的异常信息。
    //
    //原因是：由于Spring AOP的缘故。如果目标类有实现接口，辣么Spring AOP默认采用的是 JDK的动态代理方式，这样定义的 user 类型必须是接口类型。否则会报上面的异常信息。
    //                           如果目标类有实现接口，还想使用目标类类型来定义user，辣么可以指定Spring AOP 使用 cglib代理，操作是： 在 applicationContext.xml中，指定 <aop:config proxy-target-class="true">  默认值是false
    //
    @Resource(name="user")
    private UserImpl user; //这里使用 实现类 来定义 user，是因为 ：applicationContext.xml中，指定 <aop:config proxy-target-class="true">
    @Autowired
    private IUser user2;

   @Resource(name = "personImpl")
    private IUser personImpl; //这里使用 实现类或者接口 都可以来定义 user。因为这里是采用 <aop:aspectj-autoproxy></aop:aspectj-autoproxy> 注解方式（Spring会自动处理采用JDK动态代理或者cglib代理）

    @Test
    public void test1(){
//        user2.run();
//
        user.run();
        user.delete();
        user.add();

    }


    @Test
    public void test2(){
        personImpl.run();
    }

}
