package com.tcs.messaging.helloworld.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.QueueConnectionFactory;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: HelloWorldMessagingMDB
 * 
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/HelloWorldQueue") })
public class HelloWorldMessagingMDB implements MessageListener {
	/** The JMS connection factory. */
	@Resource(name = "jms/HelloWorldQueueConnectionFactory")
	@SuppressWarnings("unused")
	private QueueConnectionFactory connectionFactory;

	/** The session context of the session bean being intercepted. */
	@Resource(name = "MessageDrivenContext")
	@SuppressWarnings("unused")
	private MessageDrivenContext messageDrivenContext;

	/**
	 * Default constructor.
	 */
	public HelloWorldMessagingMDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		System.out
				.println("Processing message from HelloWorldQueue in HelloWorldMessageBean # onMessage");

		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("Hello !!!  : " 	+ textMessage.getText().toString());
				System.out.println("Message Type : " + message.getJMSType() + " : " + "Message Destination : " + message.getJMSDestination().toString());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
