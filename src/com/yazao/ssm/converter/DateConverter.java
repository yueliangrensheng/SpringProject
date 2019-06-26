package com.yazao.ssm.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//在SpringMVC中，将String类型的日期数据 转化为 Date类型的日期数据。

//方式一 ： 自定义 转化器;需要实现接口Converter
//需要在 springmvc.xml中配置如下：

//<!-- 配置自定义转化器 begin -->
//<mvc:annotation-driven conversion-service="conversionService"/>
//<!-- 转换器配置 -->
//<bean id="conversionService"
//class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
//<property name="converters">
//<set>
//<bean class="com.yazao.ssm.converter.DateConverter"/>
//</set>
//</property>
//</bean>
//<!-- 配置自定义转化器 end -->

//方式二：在相应的POJO上的属性字段上 使用注解 @DateTimeFormat(pattern="yyyy-MM-DD HH:mm:ss")

//    public class Items {
//                    ...
//
//        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//        private Date createtime;
//
//                    ...
//    }




// Converter<S,T> : S是 Source，T是Target ; 将 S 转化为 T
public class DateConverter implements Converter<String, Date> {

    //S : 2016-02-03 13:22:53
    //T : Date
    @Override
    public Date convert(String source) {
        try {
            return new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }
}
