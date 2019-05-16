package com.aumohanraj.jasper.datasource;

import java.util.List;

import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestRunnable;
import com.eviware.soapui.model.testsuite.TestStepResult;

public class MockTestRunner implements TestCaseRunner{

	public void cancel(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void fail(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getReason() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getStartTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Status getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public TestRunnable getTestRunnable() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getTimeTaken() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	public void start(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	public Status waitUntilFinished() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TestStepResult> getResults() {
		// TODO Auto-generated method stub
		return null;
	}

	public TestCaseRunContext getRunContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public TestCase getTestCase() {
		// TODO Auto-generated method stub
		return null;
	}

	public void gotoStep(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void gotoStepByName(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public TestStepResult runTestStepByName(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}	
}
