package com.tcs.messaging.helloworld.utils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import com.ibm.websphere.bo.BOFactory;
import com.ibm.websphere.sca.ServiceManager;
import com.ibm.websphere.sca.jms.data.JMSDataBinding;
import commonj.connector.runtime.DataBindingException;
import commonj.sdo.DataObject;

public class HelloWorldJMSTextDataBinding implements JMSDataBinding {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8644869535689172377L;
	private String payload = null;

	@Override
	public DataObject getDataObject() throws DataBindingException {
		ServiceManager serviceManager = new ServiceManager();
		BOFactory boFactory = (BOFactory)serviceManager.
		  locateService ("com/ibm/websphere/bo/BOFactory"); 
		DataObject messageBO = boFactory.
		  create("http://HelloWorldMessageListeningMediation", "MessageBO");
		messageBO.setString("name", payload);
		
		return messageBO;
	}

	@Override
	public void setDataObject(DataObject arg0) throws DataBindingException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMessageType() {
		return JMSDataBinding.TEXT_MESSAGE;
	}

	@Override
	public boolean isBusinessException() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void read(Message arg0) throws JMSException {
		if (!(arg0 instanceof TextMessage)) {
			System.out.println("Unexpected Message Type met!");
			throw new JMSException("Wrong Message Type - "
					+ arg0.getClass().getName() + "Error");
		}

		TextMessage textMessage = (TextMessage) arg0;
		payload = textMessage.getText();
	}

	@Override
	public void setBusinessException(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(Message arg0) throws JMSException {
		// TODO Auto-generated method stub

	}

}
