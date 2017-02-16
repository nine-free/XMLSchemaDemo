package com.soft1010.xml.schema.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Author zhangjifu
 * @Create time: 2016/10/8 15:40
 * @Description:
 */
public class PersonNamespaceHandlerSupport extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("person",new PersonBeanDefinitionParser());
    }
}
