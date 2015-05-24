package com.tcs.messaging.helloworld.ejb;

import javax.ejb.Singleton;
import javax.jws.WebService;

import com.tcs.messaging.helloworld.dto.MessageDTO;
import com.tcs.messaging.helloworld.messagehandler.MessageProducer;

/**
 * Session Bean implementation class MessageCreationBEan
 */
@WebService
@Singleton
public class MessageCreationBean  {

    /**
     * Default constructor. 
     */
    public MessageCreationBean() {
        // TODO Auto-generated constructor stub
    }

	public void createMesage(MessageDTO messageDTO) {

		MessageProducer.sendMesasge(messageDTO);
	}
    
    

}
