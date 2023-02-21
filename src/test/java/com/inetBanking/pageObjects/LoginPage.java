package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassWord;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement btnLogOut;
	
	public void setUserName(String uname)
	{
		
		txtUserName.sendKeys(uname);
		
	}
	
	public void setPwd(String pwd)
	{
		txtPassWord.sendKeys(pwd);
	}
	
	public void submit()
	{
		btnLogin.click();
	}
	
	public void Logout()
	{
		btnLogOut.click();
	}
	

}
