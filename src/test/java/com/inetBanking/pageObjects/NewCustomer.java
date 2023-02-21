package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	
	WebDriver ldriver;
	
	public   NewCustomer(WebDriver rdriver) {
		// TODO Auto-generated method stub
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement NewCutomerBtn;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement cname;
	
	@FindBy(xpath="//input[@name='rad1'][1]")
	WebElement gender;
	
	@FindBy(xpath="//*[@name='dob']")
	WebElement date;
	
	@FindBy(xpath="//*[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//*[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//*[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//*[@name='pinno']")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement phone;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath="//*[@type='submit'][@value='Submit']")
	WebElement submitBtn;
	
	public void clickNewCustomer()
	{
		NewCutomerBtn.click();
	}
	
	public void setUserName(String custName)
	{
		cname.sendKeys(custName);
	}
	public void setGender()
	{
		gender.click();
	}
	public void setDate(String mm, String dd, String yyyy)
	{
		date.sendKeys(mm);
		date.sendKeys(dd);
		date.sendKeys(yyyy);		
	}
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	public void setCity(String cty)
	{
		city.sendKeys(cty);
	}
	public void setState(String st)
	{
		state.sendKeys(st);
	}
	public void setPin(String pincode)
	{
		pin.sendKeys(String.valueOf(pincode));
	}
	public void setPhoneNum(String pnum)
	{
		phone.sendKeys(String.valueOf(pnum));
	}
	public void setEmailId(String emailID)
	{
		email.sendKeys(emailID);
	}
	public void submitFormNewCustmer()
	{
		submitBtn.click();
	}
}
