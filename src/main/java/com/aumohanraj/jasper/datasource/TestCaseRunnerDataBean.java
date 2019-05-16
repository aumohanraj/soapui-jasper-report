package com.aumohanraj.jasper.datasource;

import java.util.ArrayList;
import java.util.List;

import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestStepResult;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestCaseRunnerDataBean{		
	TestCaseRunner testCaseRunner;		
	public TestCaseRunnerDataBean(TestCaseRunner testCaseRunner) {
		this.testCaseRunner = testCaseRunner;
	}
	
	public TestCaseRunner getTestCaseRunner() {
		return testCaseRunner;
	}
	
	public long getTestStartTime() {		
		return testCaseRunner.getStartTime();
	}
	
	public void setTestCaseRunner(TestCaseRunner testCaseRunner) {
		this.testCaseRunner = testCaseRunner;
	}
	
	public List<TestStepResultDataBean> getResultsDataBean() {
		List<TestStepResultDataBean> testStepResultDataBeans = new ArrayList<TestStepResultDataBean>();
		for(TestStepResult testStepResult :this.testCaseRunner.getResults()) {
			testStepResultDataBeans.add(new TestStepResultDataBean(testStepResult));
		}
		return testStepResultDataBeans;
	}
	
	public JRBeanCollectionDataSource getTestStepResultsAsDataSource() {			
		return new JRBeanCollectionDataSource (getResultsDataBean(), false);			
	}
}