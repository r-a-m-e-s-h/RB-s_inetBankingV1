package com.inetBanking.Utilites;

//Listener class used to generate Extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	// It is a listener class used to generate extent report
	
		public ExtentHtmlReporter htmlReporter;
		public ExtentReports extent;
		public ExtentTest logger;
		
		public void onStart(ITestContext testContext)
		{
			
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = "Test-Report-"+timestamp+".html"; 
			
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");	
			
			extent=new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host name","localhost" );
			extent.setSystemInfo("Environment","QA" );
			extent.setSystemInfo("user","Tom" );
			
			htmlReporter.config().setDocumentTitle("inetBanking Test Project");
			htmlReporter.config().setReportName("Functional Test Report");
			htmlReporter.config().setTheme(Theme.DARK);
			
		}
		
		public void onTestSuccess(ITestResult tr)
		
		{
			
			logger=extent.createTest(tr.getName()); //create new entry in the report
			logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
			
		}
		
		public void onTestFailure(ITestResult tr)
		{
			logger=extent.createTest(tr.getName()); //create new entry in the report
			logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
			
			String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
			File f = new File(screenshotPath);
			
			if(f.exists())
			{
				try {
					
					logger.fail("Screenshot is below: "+ logger.addScreenCaptureFromPath(screenshotPath));
					
					
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}		
		}
		
		public void onTestSkipped(ITestResult tr)
		{

			logger=extent.createTest(tr.getName()); //create new entry in the report
			logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		}
		
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
		
		}
}


















	
	



