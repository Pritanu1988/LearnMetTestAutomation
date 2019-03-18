package ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ApplicationController.initiateBrowser;
import TestUtilities.TestUtilitiesStorage;

public class ReadxlsxFile 
{
	TestUtilitiesStorage tus = new TestUtilitiesStorage();
	initiateBrowser iB =new initiateBrowser();
 public HashMap<Integer, List<String>> Readxlsx(String sheetname) throws IOException
 {
	HashMap<Integer, List<String>> hm = new HashMap<Integer, List<String>>();
	 List<String> reslist = iB.PropertyFileReader();
	 String str[] = new String[reslist.size()];   	  
	  for (int i = 0; i < reslist.size(); i++) { 
		      		  
         str[i] = reslist.get(i); 
     } 
	  String excelloc = str[1];
	File excelFile = new File(excelloc);
    FileInputStream fis = new FileInputStream(excelFile);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheet(sheetname);
    Iterator<Row> rowIt = sheet.iterator();
    int ct=0;
    int count=1;
    while(rowIt.hasNext()) {
        Row row = rowIt.next();
        
        Iterator<Cell> cellIterator = row.cellIterator();
        if(ct!=0)
        {
        while (cellIterator.hasNext()) {
          List<String> list =new ArrayList<String>();
          //Cell cell = cellIterator.next();        
          list.add(tus.setTestStepNo(row.getCell(0).getStringCellValue()));
          list.add(tus.setTestDetails(row.getCell(1).getStringCellValue()));
          list.add(tus.setWebElementLocator(row.getCell(2).getStringCellValue()));
          list.add(tus.setTypeofLocator(row.getCell(3).getStringCellValue()));
          list.add(tus.setMethod(row.getCell(4).getStringCellValue()));
          list.add(tus.setParameter(row.getCell(5).getStringCellValue()));
          list.add(tus.setDelay(row.getCell(6).getStringCellValue()));
          hm.put(count, list);
          break;
        }
        count++;
        }        
        ct++;       
      }

      workbook.close();
      fis.close();
      return hm;
 } 
 public HashMap<Integer, List<String>> ReadModuleName(String sheetname) throws IOException
 {
	 HashMap<Integer, List<String>> modname = new HashMap<Integer, List<String>>();
	 List<String> reslist = iB.PropertyFileReader();
	 String str[] = new String[reslist.size()];   	  
	  for (int i = 0; i < reslist.size(); i++) { 
		      		  
         str[i] = reslist.get(i); 
     } 
	  String excelloc = str[1];
	File excelFile = new File(excelloc);
    FileInputStream fismod = new FileInputStream(excelFile);
	XSSFWorkbook wb = new XSSFWorkbook(fismod);
    XSSFSheet sw = wb.getSheet(sheetname);
    Iterator<Row> rowit = sw.iterator();
    int ct=0;
    int count=1;
    while(rowit.hasNext()) {
        Row row = rowit.next();
        
        Iterator<Cell> cellIterator = row.cellIterator();
        if(ct!=0)
        {
        while (cellIterator.hasNext()) {
          List<String> listmod =new ArrayList<String>();
          //listmod.add(tus.setSequenceNo(row.getCell(0).getStringCellValue()));
          listmod.add(tus.setModuleName(row.getCell(1).getStringCellValue()));
          modname.put(count, listmod);
          break;
        }
        count++;
        }        
        ct++;       
      }

      wb.close();
      fismod.close();
	 return modname;	 
 }
}
