package com.tcs.messaging.helloworld.utils;

import commonj.connector.runtime.FunctionSelector;
import commonj.connector.runtime.SelectorException;

public class HelloWorldFunctionSelector implements FunctionSelector {

	@Override
	public String generateEISFunctionName(Object[] arg0)
			throws SelectorException {
		String functionName = "readMesasge";
		return functionName;
	}

}
