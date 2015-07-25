package com.springbase.chap01;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/chap01.xml")
public class Chap01TestCase {
	@Resource
	Man man;
	
	@Resource
	Man cman;
	@Resource
	Man pman;
	@Resource
	Man dman;
	@Resource
	Man dman2;
	@Test
	public void testSet() {
		System.out.println(man.getName());
	}
	@Test
	public void testConstructor() {
		System.out.println(cman.getName());
	}
	@Test
	public void testPtag() {
		System.out.println(pman.getName());
	}
	@Test
	public void testDI() {
		System.out.println(dman.getName());
		System.out.println(dman.getCard().getMoney());
	}
	@Test
	public void testDI2() {
		System.out.println(dman2.getName());
		System.out.println(dman2.getCard().getMoney());
	}
}
