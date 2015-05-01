package com.springxml;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springxml.jaxb.JaxbDomain;
import com.springxml.xstream.XstreamDomain;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext-xstream.xml"})
public class XstreamXmlTestCase {
	@Resource
	XStreamMarshaller xstreamMarshaller;
	@Test
	public void test() throws IOException{
        FileOutputStream os = null;
        try {
        	XstreamDomain u = new XstreamDomain();
        	u.setName("this is xstream");
            os = new FileOutputStream("XstreamDomain.xml");
            this.xstreamMarshaller.marshal(u, new StreamResult(os));
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
	            is = new FileInputStream("XstreamDomain.xml");
	            XstreamDomain u = (XstreamDomain) this.xstreamMarshaller.unmarshal(new StreamSource(is));
	            System.out.println(u.getName());
	        } finally {
	            if (is != null) {
	                is.close();
	            }
	        }		
	}

	
}
