
######spring xml扩展的四个步骤

1、定义配置属性javabean

```
public class Person {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
```

2、提供一个xsd文件

```
<?xml version="1.0" encoding="UTF-8" ?>
<xsd:schema xmlns="http://soft1010.com/schema/demo"
            xmlns:xsd="http://www.w3.org/2001/XMLSchema"
            xmlns:beans="http://www.springframework.org/schema/beans"
            targetNamespace="http://soft1010.com/schema/demo"
            elementFormDefault="qualified"
            attributeFormDefault="unqualified">

    <xsd:import namespace="http://www.springframework.org/schema/beans" />

    <xsd:element name="person">
        <xsd:complexType>
            <xsd:complexContent>
                <xsd:extension base="beans:identifiedType">
                    <xsd:attribute name="name" type="xsd:string" use="required" />
                    <xsd:attribute name="age" type="xsd:integer" use="required" />
                </xsd:extension>
            </xsd:complexContent>
        </xsd:complexType>
    </xsd:element>

</xsd:schema>
```

3、编写NamespaceHandler和BeanDefinitionParser完成解析工作

```
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
```

```
public class PersonNamespaceHandlerSupport extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("person",new PersonBeanDefinitionParser());
    }
}
```

4、编写spring.handlers和spring.schemas串联起所有部件

```
http\://soft1010.com/schema/demo=com.soft1010.xml.schema.spring.PersonNamespaceHandlerSupport
```

```
http\://soft1010.com/schema/demo/Person.xsd=META-INF/Person.xsd
```

5、应用

```
public class Test {
    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "spring.xml");

    public static void main(String args[]){
        Person person= (Person)context.getBean("person");
        System.out.println(person.toString());
    }
}
```




