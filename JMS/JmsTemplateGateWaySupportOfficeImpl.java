package com.springexample.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.support.JmsGatewaySupport;

public class JmsTemplateGateWaySupportOfficeImpl extends JmsGatewaySupport implements BackOffice {
	Destination destination;
	@Override
	public Mail receiveMail() {
		MapMessage message = (MapMessage)this.getJmsTemplate().receive(destination);
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
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
