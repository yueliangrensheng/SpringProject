package com.yazao.spring.test;

import com.yazao.spring.domain.IUser;
import com.yazao.spring.domain.UserImpl;
import com.yazao.spring.allannotation.SpringConfig;
import com.yazao.spring.annotation.Person;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class MyTest {

    @Test
    public void test1() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserImpl user = (UserImpl) context.getBean("user");
        user.run();

        UserImpl user2 = (UserImpl) context.getBean("user2");
        user2.run();
    }

    @Test
    public void test2() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //硬编码方式
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass("com.mysql.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hibernate");
//        dataSource.setUser("root");
//        dataSource.setPassword("123");

        //采用 spring applicationContext_jdbc.xml 动态加载
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


    @Test
    public void test3() {
        //半注解半xml

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());
    }

    @Test
    public void test4() throws SQLException {
        //全注解

        //加载注解类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());


        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }


    @Test
    public void test5() {
        // AOP -- 1.动态代理 （条件：目标类必须有接口）

        //目标类
        UserImpl user = new UserImpl();
        IUser userProxy = null;

        try {

            //参数一：和目标累一样的加载器
            //参数二：和目标类一样的接口
            //参数三：增强的业务
            userProxy = (IUser) Proxy.newProxyInstance(
                    user.getClass().getClassLoader(),
                    user.getClass().getInterfaces(),
                    new InvocationHandler() {


                        /**
                         * @param proxy
                         * @param method 要增强的方法（原有的方法）
                         * @param args 方法运行时候所需的参数
                         */
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                            if ("run".equals(method.getName())) {

                                System.out.println("------ hook before ------");
                                method.invoke(user, args);
                                System.out.println("------ hook after ------");

                            } else {
                                //执行原有方法
                                method.invoke(user, args);
                            }

                            return null;
                        }
                    }
            );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        //只要执行，就会执行增强业务方法invoke
        userProxy.run();
        userProxy.add();

        //判断代理对象是否属于目标对象类型
        //代理对象 和 目标对象 没有任何关系，只是 implement 同一个接口
        System.out.println(userProxy instanceof UserImpl);//false

    }


    @Test
    public void test6(){
        // AOP -- 2.cglib代理 （目标类没有接口）

        Enhancer enhancer = new Enhancer();//创建代理对象
        enhancer.setSuperclass(UserImpl.class);//设置目标对象类
        enhancer.setCallback(new MethodInterceptor() { //设置代理增强操作

            /**
             * @param obj 目标类对象
             * @param method 实际调用的方法
             * @param args 调用方法的参数
             * @param methodProxy  Method类的代理类，可以实现目标类对象的方法调用
             */
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                System.out.println("------ cglib hook before ------");
                Object value = methodProxy.invokeSuper(obj, args);
                System.out.println("------ cglib hook after ------");

                return value;
            }
        });

        IUser userProxy = (IUser) enhancer.create();

        userProxy.run();

        //判断代理对象是否属于目标对象类型
        //代理对象 继承了 目标对象
        System.out.println(userProxy instanceof UserImpl);//true
    }
}
