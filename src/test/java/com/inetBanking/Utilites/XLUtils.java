//package com.inetBanking.Utilites;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class XLUtil {
//	
//	
//	public static FileInputStream fis;
//	public static FileOutputStream fos;
//	public static XSSFWorkbook book;
//	public static  XSSFSheet sheet;
//	public static XSSFRow row;
//	public static XSSFCell cell;
//
//	public static int getRowCount(String xlfile,String xlsheet) throws IOException
//	{
//	fis = new FileInputStream(xlfile);
//	book= new XSSFWorkbook(fis);
//	sheet=book.getSheet(xlsheet);
//	int rowCount=sheet.getLastRowNum();
//	book.close();
//	fis.close();
//	return rowCount;
//	
//	}
//	
//	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
//	{
//	fis = new FileInputStream(xlfile);
//	book= new XSSFWorkbook(fis);
//	sheet=book.getSheet(xlsheet);
//	int cellCount = row.getLastCellNum();
//	book.close();
//	fis.close();
//	return cellCount;
//	
//	}
//	
//	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnm) throws IOException
//	{
//	fis = new FileInputStream(xlfile);
//	book= new XSSFWorkbook(fis);
//	sheet=book.getSheet(xlsheet);
//	row=sheet.getRow(rownum);
//	cell=row.getCell(colnm);
//	String data;
//	
//	try {
//		
//		DataFormatter formatter =  new DataFormatter();
//		String cellData = formatter.formatCellValue(cell);
//		return cellData;
//		
//	} catch (Exception e) {
//		// TODO: handle exception	
//		data="";
//	}
//	
//	book.close();
//	fis.close();
//	return data;
//	
//	}
//	
//	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnm,String data) throws IOException
//	{
//		fis = new FileInputStream(xlfile);
//		book= new XSSFWorkbook(fis);
//		sheet=book.getSheet(xlsheet);
//		row=sheet.getRow(rownum);
//		cell=row.createCell(colnm);
//		cell.setCellValue(data);
//		fos= new FileOutputStream(xlfile);
//		book.write(fos);
//		fis.close();
//		fos.close();
//		
//	}
//	
//	
//	
//	
//
//}


package com.inetBanking.Utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	
	
}