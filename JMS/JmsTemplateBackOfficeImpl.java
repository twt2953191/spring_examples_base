package com.springexample.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;

public class JmsTemplateBackOfficeImpl implements BackOffice {
	JmsTemplate jmsTemplate;
	Destination destination;
	@Override
	public Mail receiveMail() {
		MapMessage message = (MapMessage)jmsTemplate.receive(destination);
		if(message==null){
			return null;
		}
		
		Mail mail = new Mail();
		try {
			mail.setMailId(message.getString("mailId"));
			mail.setCountry(message.getString("country"));
			mail.setWeight(message.getDouble("weight"));		
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return mail;
	}
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
