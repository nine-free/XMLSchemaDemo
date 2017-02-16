package com.soft1010.xml.schema.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zhangjifu
 * @Create time: 2016/10/8 15:53
 * @Description:
 */
public class Test {
    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "spring.xml");

    public static void main(String args[]){
        Person person= (Person)context.getBean("person");
        System.out.println(person.toString());
    }

}
