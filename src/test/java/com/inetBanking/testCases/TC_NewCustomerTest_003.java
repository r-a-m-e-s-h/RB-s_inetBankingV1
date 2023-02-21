package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewCustomer;

import net.bytebuddy.utility.RandomString;

public class TC_NewCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPwd(passWord);
		lp.submit();

		Thread.sleep(1000);

		NewCustomer newcust =new NewCustomer(driver); 
		newcust.clickNewCustomer();
		logger.info("new customer btn is clicked");

		newcust.setUserName("Tom");
		logger.info("UserName is entered");

		newcust.setGender();
		logger.info("gender is selected");

		newcust.setDate("15","08","1998");
		logger.info("Date  btn is Entered");

		newcust.setAddress("tambaram");
		logger.info("address is entered");

		newcust.setCity("chennai");
		logger.info("City is entered");

		newcust.setState("tamilnadu");
		logger.info("State is entered");

		newcust.setPin("6120021");
		logger.info("PinNumber btn is entered");

		newcust.setPhoneNum("1234567890");
		logger.info("PhoneNumber is entered");

		Thread.sleep(2000);

		//newcust.setEmailId("tom@gmail.com");

		String AutoEmailId = RandomString()+"@gmail.com";
		newcust.setEmailId(AutoEmailId);
		logger.info("EmailId is entered");

		newcust.submitFormNewCustmer();
		logger.info("Submit btn is clicked");

		//Taking Screenshot after entering the customer details 
		captureScreenshot(driver, "addNewCustomer");



	}

	public String RandomString()//ud fun()
	{
		String generatedTxt = RandomStringUtils.randomAlphabetic(9);
		return generatedTxt;

	}

}
