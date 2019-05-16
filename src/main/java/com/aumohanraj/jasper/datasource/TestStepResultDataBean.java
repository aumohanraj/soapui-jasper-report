package com.aumohanraj.jasper.datasource;

import com.eviware.soapui.model.testsuite.TestStepResult;

public class TestStepResultDataBean {
	TestStepResult testStepResult;
	
	public TestStepResultDataBean(TestStepResult testStepResult){
		this.testStepResult = testStepResult;
	}
	
	public TestStepResult getTestStepResult() {
		return testStepResult;
	}
	
	public String getMessages() {
		String messages = "";
		for(String message : this.testStepResult.getMessages()) {
			messages = messages + message + "\n";
		}
		return messages;
	}
}
