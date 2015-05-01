package com.springxml.jaxb;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public JaxbDomain createPerson() {
        return new JaxbDomain();
    }

}