package com.springxml.jaxb;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jaxbroot")
public class JaxbDomain {
	String name;
	 
	 public void setName(String name){
		 this.name=name;
	 }
	 
	 @XmlElement(required = true)
	 public String getName(){return this.name;}
}
