package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.base.Optional;
import com.inetBanking.Utilites.ReadConfig;



public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig(); 
	
	// here we getting data from Readconfig.java via dynamically
	
	public String baseUrl=readconfig.getApplicationURL();

	public String userName = readconfig.getUsername();
	
	public String passWord = readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		//Dynamic-Data
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getfirefoxpath());
			driver = new FirefoxDriver();	
		}
		else if (br.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getiepath());
			driver = new InternetExplorerDriver();	
		}
		
		driver.manage().window().maximize();
		
		//# Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseUrl);						
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname ) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot Taken");
		
		
	}

}
	
//--------------------------------------------*************-------------------------------------------------------
	
//ReadConfig readconfig=new ReadConfig();
//	
//	public String baseURL=readconfig.getApplicationURL();
//	public String username=readconfig.getUsername();
//	public String password=readconfig.getPassword();
//	public static WebDriver driver;
//	
//	public static Logger logger;
//	
//	@Parameters("browser")
//	@BeforeClass
//	public void setup(String br)
//	{			
//		logger = Logger.getLogger("ebanking");
//		PropertyConfigurator.configure("Log4j.properties");
//		
//		if(br.equals("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
//			driver=new ChromeDriver();
//		}
//		else if(br.equals("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
//			driver = new FirefoxDriver();
//		}
//		else if(br.equals("ie"))
//		{
//			System.setProperty("webdriver.ie.driver",readconfig.getiepath());
//			driver = new InternetExplorerDriver();
//		}
//		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get(baseURL);
//		System.out.println("hello world");
//	}
//	
//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}
//	
//	public void captureScreen(WebDriver driver, String tname) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
//		FileUtils.copyFile(source, target);
//		System.out.println("Screenshot taken");
//	}
	
//	public String randomestring()
//	{
//		String generatedstring=RandomStringUtils.randomAlphabetic(8);
//		return(generatedstring);
//	}
//	
//	public static String randomeNum() {
//		String generatedString2 = RandomStringUtils.randomNumeric(4);
//		return (generatedString2);
//	}
//	

//---------------------------------********-------------------------
		//	public String baseUrl="https://demo.guru99.com/V1/index.php"; 
		//	
		//	public String userName = "mngr347425";
		//	
		//	public String passWord = "pAgemeb";
		
		
		//--------------------------********------------------------------
	
	//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
	
			//WebDriverManager.chromedriver().setup();
			
			//driver = new ChromeDriver();
//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");



