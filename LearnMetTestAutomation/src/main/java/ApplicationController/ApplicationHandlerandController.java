package ApplicationController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import TestUtilities.TestUtilitiesStorage;
import BrowserController.BrowserEventController;
import ExcelReader.ReadxlsxFile;

public class ApplicationHandlerandController extends initiateBrowser
{
	TestUtilitiesStorage ts = new TestUtilitiesStorage();
	public void teststepEval() throws IOException, InterruptedException
	{
	initBrowser();
	ReadxlsxFile rx =new ReadxlsxFile();
	BrowserEventController bc = new BrowserEventController();
	HashMap<Integer, List<String>> collhm = rx.Readxlsx("GoogleTest");
	for (Entry<Integer, List<String>> entry : collhm.entrySet()) 
	{
	      //System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());
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
	     }
	
	//System.out.println(collhm);
	}	
}

