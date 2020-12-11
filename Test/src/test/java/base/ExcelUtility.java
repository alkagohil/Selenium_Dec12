package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtility {

HSSFWorkbook file;
HSSFSheet s;
public Object[][] readExcel(String path,String sheetname)
{
	FileInputStream fin;
	try {
		fin = new FileInputStream(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		fin=null;
	}
	try {
		file=new HSSFWorkbook(fin);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//s=file.getSheetAt(0);
	s=file.getSheet(sheetname);
	Object[][] data = new Object[s.getLastRowNum()][s.getRow(1).getLastCellNum()];
	System.out.println(s.getLastRowNum());
	//String data = s.getRow(rNoum).getCell(cNum).toString();
	int r=0;
	for(int i=1;i<=s.getLastRowNum();i++)
	{
		
		for(int j=0;j<s.getRow(i).getLastCellNum();j++)
		{
			data[r][j]=s.getRow(i).getCell(j).toString();
		System.out.println(data[r][j]);
		}
		r=r+1;
		}
		
	
	return data;
}
public void writeExcel(String path,String sheetname,int r,int c,String result)
{
	FileInputStream fin;
	FileOutputStream fout;
	try {
		fin = new FileInputStream(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		fin=null;
	}
	try {
		file=new HSSFWorkbook(fin);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//s=file.getSheetAt(0);
	s=file.getSheet(sheetname);
	s.getRow(r).createCell(c).setCellValue(result);
	try {
		fout = new FileOutputStream(path);
		file.write(fout);
		fout.flush();
		file.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
public static void main(String args[])
{
	ExcelUtility e = new ExcelUtility();
	e.readExcel("C:\\alka\\testdata.xls", "LoginData");
	
}
}
