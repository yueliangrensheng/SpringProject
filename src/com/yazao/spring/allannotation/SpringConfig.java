package com.yazao.spring.allannotation;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration //表示该类是一个注解类
@ComponentScan(basePackages = "com.yazao.spring")
// 替代了： <context:component-scan base-package="com.yazao.spring.annotation"></context:component-scan>
@PropertySource(value = "classpath:jdbc.properties")
// 替代了： applicationContext_jdbc.xml 中的： <context:property-placeholder location="classpath:jdbc.properties"/>
@EnableAspectJAutoProxy //替代了：<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "dataSource")// 替代：applicationContext_jdbc.xml 中的： <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
