package ApplicationController;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import TestUtilities.TestUtilitiesStorage;
import BrowserController.BrowserEventController;
import ExcelReader.ReadxlsxFile;

public class ApplicationHandlerandController extends initiateBrowser
{
	TestUtilitiesStorage ts = new TestUtilitiesStorage();
	ExtentHtmlReporter report = null;
	ExtentReports extent = new ExtentReports();
	Date date= new Date();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	public void teststepEval() throws IOException, InterruptedException
	{
	List<String> reslist = PropertyFileReader();
	String strrep[] = new String[reslist.size()];   	  
	  for (int i = 0; i < reslist.size(); i++) { 
			      		  
		  strrep[i] = reslist.get(i); 
	   } 
	  long time = date.getTime();
	  Timestamp tstp = new Timestamp(time);	  
	  String reportloc = strrep[3]+strrep[4]+"_"+sdf.format(tstp)+".html";
    report=new ExtentHtmlReporter(reportloc);
	initBrowser();
	ReadxlsxFile rx =new ReadxlsxFile();
	BrowserEventController bc = new BrowserEventController();
	extent.attachReporter(report);
	HashMap<Integer, List<String>> modname = rx.ReadModuleName("TestModules");
	for (Entry<Integer, List<String>> modentry : modname.entrySet()) 
	{
		List<String> modDetails = modentry.getValue();
  	  String modnam[] = new String[modDetails.size()];   	  
  	  for (int i = 0; i < modDetails.size(); i++) { 
  		      		  
  		 modnam[i] = modDetails.get(i); 
        } 
  	  System.out.println(modnam[0]);
	HashMap<Integer, List<String>> collhm = rx.Readxlsx(modnam[0]);
	ExtentTest exttest =extent.createTest(modnam[0]);

	for (Entry<Integer, List<String>> entry : collhm.entrySet()) 
	{
	    try{  //System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());
	      List<String> testDetails = entry.getValue();
    	  String str[] = new String[testDetails.size()];   	  
    	  for (int i = 0; i < testDetails.size(); i++) { 
    		      		  
              str[i] = testDetails.get(i); 
          } 
    	  ts.setTestStepNo(str[0]);
    	  ts.setTestDetails(str[1]);
    	  ts.setWebElementLocator(str[2]);
    	  ts.setTypeofLocator(str[3]);
    	  ts.setMethod(str[4]);
          ts.setParameter(str[5]);
          ts.setDelay(str[6]);
    	  bc.executeTestSteps(ts.getTestStepNo(), ts.getTestDetails(), ts.getWebElementLocator(), ts.getTypeofLocator(), ts.getMethod(), ts.getParameter(), ts.getDelay());
      	  exttest.log(Status.PASS, ts.getTestDetails());
	    }catch(Exception e)
	 {
    	  exttest.log(Status.FAIL, ts.getTestDetails());
    	  e.printStackTrace();
	 }
	}
	}
	  extent.flush();
	//System.out.println(collhm);
	}	
}

