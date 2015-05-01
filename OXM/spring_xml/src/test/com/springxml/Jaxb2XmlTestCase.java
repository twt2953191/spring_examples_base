package com.springxml;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springxml.jaxb.JaxbDomain;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext-jaxb2.xml"})
public class Jaxb2XmlTestCase {
	@Resource
	Jaxb2Marshaller marshaller;
	@Test
	public void test() throws IOException{
        FileOutputStream os = null;
        try {
        	JaxbDomain u = new JaxbDomain();
        	u.setName("jaxb test");
            os = new FileOutputStream("JaxbDomain.xml");
            this.marshaller.marshal(u, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }		
	}
	
	@Test
	public void test2() throws IOException{
		
	     FileInputStream is = null;
	        try {
	            is = new FileInputStream("JaxbDomain.xml");
	            JaxbDomain u = (JaxbDomain) this.marshaller.unmarshal(new StreamSource(is));
	            System.out.println(u.getName());
	        } finally {
	            if (is != null) {
	                is.close();
	            }
	        }		
	}

	
}
