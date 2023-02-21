package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.Utilites.XLUtils;
import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass

{

	@Test(dataProvider="LoginData")
	public void loginDDT(String u_name, String p_wd) throws InterruptedException, IOException
	{
		//#Logger used to store the logs in Backend
		logger.info("URL is Opened");
		System.out.println("hello world");
		
		LoginPage lp= new  LoginPage(driver);
		

		lp.setUserName(u_name);
		logger.info("Username is Entered");
		
		lp.setPwd(p_wd);
		logger.info("UPassword is Entered");
		
		lp.submit();
		logger.info("submitBtn is Clicked");
		
		Thread.sleep(3000);
		//Alert Statement
		if(isAlertPresent()==true)
		{
			//# User entered the invalid credentials , so we handles the alert for invalid user 
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			 Assert.assertTrue(false);
			 logger.warn("invalid user cresdentials");
		
		}
		else
		{
			//# user click on the LogOut Button
			Assert.assertTrue(true);
			lp.Logout();
			driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			logger.info("LogOutBtn is Clicked");
		}
		captureScreenshot(driver, "loginDDT");
	}
	
	
	public boolean isAlertPresent()// User defined Method to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	

	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet");
		int colcount=XLUtils.getCellCount(path,"Sheet",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet", i,j);//1 0
			}
				
		}
	System.out.println(logindata);	
	return logindata;
	}
	
	
}

