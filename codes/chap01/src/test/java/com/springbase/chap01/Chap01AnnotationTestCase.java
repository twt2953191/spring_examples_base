package com.springbase.chap01;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/chap01-annotation.xml")
public class Chap01AnnotationTestCase {
	@Resource
	Man dman3;
	
	
	@Test
	public void testSet() {
		System.out.println(dman3.getName());
		System.out.println(dman3.getCard().getMoney());
	}
}
