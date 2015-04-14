package com.springexample.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.core.support.JmsGatewaySupport;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class SimpleBackOfficeImpl implements BackOffice {
    public Mail receiveMail() {
		// Create a ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection =null;
		try {
			// Create a Connection
			connection = connectionFactory.createConnection();
			connection.start();

			// Create a Session
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Create the destination (Topic or Queue)
			Destination destination = session.createQueue("mail.queue");

			// Create a MessageProducer from the Session to the Topic or Queue
			MessageConsumer consumer = session.createConsumer(destination);

			MapMessage message =(MapMessage)consumer.receive();
			Mail mail = new Mail();
			mail.setMailId(message.getString("mailId"));
			mail.setCountry(message.getString("country"));
			mail.setWeight(message.getDouble("weight"));
			// Clean up
			session.close();
			return mail;
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
		return null;    	
    }
}
