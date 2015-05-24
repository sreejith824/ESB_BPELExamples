package com.tcs.messaging.helloworld.messagehandler;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tcs.messaging.helloworld.dto.MessageDTO;



/**
 * Message producer is responsible for sending messages to the JMS queue.
 * 
 * @author G9007LI
 * 
 */
public class MessageProducer {

	/**
	 * Send message method will send message to the JMS queue.
	 * 
	 * @param messageDTO
	 */
	public static void sendMesasge(MessageDTO messageDTO) {
		System.out.println("Inside MessageProducer # sendMesasge");
		try {
		
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY,
					"com.ibm.websphere.naming.WsnInitialContextFactory");
			env.put(Context.PROVIDER_URL, "iiop://localhost:2812");
			InitialContext initialContext = new InitialContext(env);
			initialContext.lookup("");

			// Look up queue connection factory.
			QueueConnectionFactory queuConnectionFactory = (QueueConnectionFactory) initialContext
					.lookup("jms/HelloWorldQueueConnectionFactory");
			// Look up JMS queue.
			Queue queue = (Queue) initialContext.lookup("jms/HelloWorldQueue");
			Queue mediationQueue = (Queue) initialContext.lookup("jms/HelloWorldMediationQueue");
			try {
				QueueConnection queueConnection = queuConnectionFactory
						.createQueueConnection();
				QueueSession queueSession = queueConnection.createQueueSession(
						true, QueueSession.AUTO_ACKNOWLEDGE);
				QueueSender queueSender = null; 
				QueueSender mediationQueueSender = null;

				// Sending text message.
				queueSender = queueSession.createSender(queue);
				mediationQueueSender = queueSession.createSender(mediationQueue);
				
				TextMessage textMessage = queueSession.createTextMessage();
				textMessage.setText(messageDTO.getName());
				// Sending message to HelloWorldQueue.
				System.out
						.println("Sending message to HelloWorldQueue [TextMessage].");
				queueSender.send(textMessage);
				
				textMessage.setText(messageDTO.getName() + " For mediation" );
				mediationQueueSender.send(textMessage);
			} catch (JMSException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
