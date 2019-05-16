package com.aumohanraj.soapui.listeners;

import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aumohanraj.jasper.datasource.TestCaseRunnerDataBean;
import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.panels.support.MockTestRunner;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestSuiteRunContext;
import com.eviware.soapui.model.testsuite.TestSuiteRunListener;
import com.eviware.soapui.model.testsuite.TestSuiteRunner;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestRunListener implements TestSuiteRunListener{	


	TestSuiteRunner testSuiteRunner;
	public void afterRun(TestSuiteRunner testSuiteRunner, TestSuiteRunContext testSuiteRunContext) {
		
		this.testSuiteRunner = testSuiteRunner;		
		JasperReport jasperReport = null;
		JasperPrint jasperPrint = null;
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(getDataSource());
		
		Map<String, Object> parameters = new HashMap<String, Object>();		
		parameters.put("TEST_SUITE_RUNNER", testSuiteRunner);
		parameters.put("REPORT_TITLE", testSuiteRunner.getTestSuite().getName());
		parameters.put("SUITE_TIME_TAKEN", String.valueOf((testSuiteRunner.getTimeTaken()/1000))+" seconds");
		parameters.put("SUITE_START_TIME", new Timestamp(testSuiteRunner.getStartTime()).toString());
		parameters.put("SUITE_END_TIME", new Timestamp(testSuiteRunner.getStartTime() + testSuiteRunner.getTimeTaken()).toString());
		parameters.put("TOTAL_TC", this.testSuiteRunner.getTestSuite().getTestCaseCount());
		parameters.put("PASS_COUNT", this.getPasscount());
		parameters.put("FAIL_COUNT", this.getFailcount());
		
		try {
			
			File outDir = new File("reportsOutput");
			outDir.mkdirs();
			
			String reportUrl = "/SummaryReport.jrxml";
			InputStream reportFile = null;
			reportFile = getClass().getResourceAsStream(reportUrl);
			jasperReport = JasperCompileManager
			           .compileReport(reportFile);
			
			jasperPrint = JasperFillManager.fillReport(jasperReport,
			           parameters, datasource);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					outDir.getAbsolutePath()+"\\SummaryReport_"+testSuiteRunner.getTestSuite().getName()+".pdf");
			SoapUI.log.info("Report Generated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			SoapUI.log.info("Error in generaing jasper reports");
			SoapUI.log.info(e.getMessage());
		}
	}

	public void afterTestCase(TestSuiteRunner arg0, TestSuiteRunContext arg1, TestCaseRunner arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeRun(TestSuiteRunner arg0, TestSuiteRunContext arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeTestCase(TestSuiteRunner arg0, TestSuiteRunContext arg1, TestCase arg2) {
		// TODO Auto-generated method stub
		
	}
	
	public Collection<TestCaseRunnerDataBean> getDataSource() {		
		if(testSuiteRunner.getResults() != null) {		
			Collection<TestCaseRunnerDataBean> testCaseRunnerDataBeans = new ArrayList<TestCaseRunnerDataBean>();
			for(TestCaseRunner runner : testSuiteRunner.getResults()) {		
				testCaseRunnerDataBeans.add(new TestCaseRunnerDataBean(runner));
			}			
			return testCaseRunnerDataBeans;
		}		
		return null;		
	}
	
	public static List<TestCaseRunnerDataBean> getMockTestCaseRunners(){
		List<TestCaseRunnerDataBean> testCaseRunnerDataBeans = new ArrayList<TestCaseRunnerDataBean>();		
		TestCaseRunner testCaseRunner = new MockTestRunner(null);		
		testCaseRunnerDataBeans.add(new TestCaseRunnerDataBean(testCaseRunner));
		testCaseRunnerDataBeans.add(new TestCaseRunnerDataBean(testCaseRunner));
		return testCaseRunnerDataBeans;		
	}
	
	public TestSuiteRunner getTestSuiteRunner() {
		return this.testSuiteRunner;
	}
	
	public int getPasscount() {
		int passCount = 0;
		for(TestCaseRunner testCaseRunner : this.testSuiteRunner.getResults()) {
			if(testCaseRunner.getStatus().equals(Status.FINISHED)) {
				passCount++;
			}
		}		
		return passCount;
	}
	
	public int getFailcount() {
		int failCount = 0;
		for(TestCaseRunner testCaseRunner : this.testSuiteRunner.getResults()) {
			if(testCaseRunner.getStatus().equals(Status.FAILED)) {
				failCount++;
			}
		}		
		return failCount;
	}
}