package com.tcs.messaging.helloworld.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5094935818279482536L;
	public MessageDTO() {
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	private String name;
	

}
