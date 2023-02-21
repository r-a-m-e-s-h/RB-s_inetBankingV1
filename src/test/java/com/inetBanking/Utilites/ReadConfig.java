package com.inetBanking.Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	public ReadConfig() {
		// TODO Auto-generated constructor stub
		
		File src =new File("./Configuration/config.properties") ;
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception is  "+e.getMessage()); 
		}
		
		
	}
	
	public String getApplicationURL()
	{
		String url =pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername()
	{
		String Username=pro.getProperty("userName");
		return Username;
		
	}
	
	public String getPassword()
	{
		String PassWord =pro.getProperty("passWord");
		return PassWord;
	}
	
	public String getChromePath()
	{
		String chromepath =pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getiepath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
	public String getfirefoxpath()
	{
		String firfoxpath =pro.getProperty("firfoxpath");
		return firfoxpath;
	}
	
	
	
	
	
	

}
