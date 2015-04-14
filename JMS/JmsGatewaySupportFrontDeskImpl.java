package com.springexample.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;

public class JmsGatewaySupportFrontDeskImpl extends JmsGatewaySupport implements FrontDesk {
	
//	JmsTemplate jmsTemplate;
	Destination destination;
	@Override
	public void sendMail(final Mail mail) {
		MessageCreator messageCreator = new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setString("mailId", mail.getMailId());
				message.setString("country", mail.getCountry());
				message.setDouble("weight", mail.getWeight());
				return message;
			}
			
		};
		this.getJmsTemplate().send(destination, messageCreator);
	}
//	public JmsTemplate getJmsTemplate() {
//		return jmsTemplate;
//	}
//	public void setJmsTemplate(JmsTemplate jmsTemplate) {
//		this.jmsTemplate = jmsTemplate;
//	}
//	public Destination getDestination() {
//		return destination;
//	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
