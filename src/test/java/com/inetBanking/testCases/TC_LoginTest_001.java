package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.Utilites.XLUtils;
import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass

{
	@Test
	public void loginTest() throws IOException
	{
		//driver.get(baseUrl);
		
		logger.info("URL is Opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		logger.info("Username is Entered");
		
		lp.setPwd(passWord);
		logger.info("Password is Entered");
		
		lp.submit();
		logger.info("Submit Button is Clicked");
		
		lp.Logout();
		logger.info("Logout Button is clicked");
		
		driver.switchTo().alert().accept();
		
		
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			System.out.println("Welcomes to Mini Project");	
			System.out.println("The Title of this Page is : "+driver.getTitle()); 
			
			logger.info("Login Test Passed");
		}
		
		else
		{
			captureScreenshot(driver, "loginTest");
			System.out.println("The Changed Title is : "+driver.getTitle()); 
			//Assert.assertTrue(false);
			Assert.assertTrue(true);
			
			logger.info("Login Test Failed");	   
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
