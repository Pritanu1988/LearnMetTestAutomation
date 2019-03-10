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
    File excelFile = new File("C:\\LearnMetAutomationWorkspace\\InputSheet1.xlsx");
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
}
