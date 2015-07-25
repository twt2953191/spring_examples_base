package com.springbase.chap01;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Man {
	String name;
	//必须启用annotation特性
//	@Autowired
//	@Qualifier("card2")
	@Resource
	Card card;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Man(String name) {
		super();
		this.name = name;
	}

	public Man() {
		super();
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
