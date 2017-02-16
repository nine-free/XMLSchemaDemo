package com.soft1010.xml.schema.spring;


import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;


/**
 * @Author zhangjifu
 * @Create time: 2016/10/8 15:16
 * @Description:
 */
public class PersonBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {


    @Override
    protected Class<?> getBeanClass(Element element) {
        return Person.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        builder.addPropertyValue("name",element.getAttribute("name"));
        builder.addPropertyValue("age",element.getAttribute("age"));
        super.doParse(element, builder);
    }
}
