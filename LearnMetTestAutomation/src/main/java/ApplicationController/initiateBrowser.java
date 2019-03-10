package ApplicationController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class initiateBrowser 
{
 public static WebDriver driver=null;
 public List<String> PropertyFileReader()
 {
	 Properties prop = new Properties();
     List<String> resourcelst = new ArrayList<String>();
	 try {
	     prop.load(new FileInputStream("C:/LearnMetAutomationWorkspace/LearnMetTestAutomation/src/main/resources/config.properties"));
	     resourcelst.add(prop.getProperty("APPURL"));
	     resourcelst.add(prop.getProperty("INPUTSHEETLOCATION"));
	     resourcelst.add(prop.getProperty("CHROMEDRIVERL_LOC"));
	 } catch (IOException e) {
	     e.printStackTrace();
	 }
	 return resourcelst;
 }
 public void initBrowser()
 {
	 List<String> reslist = PropertyFileReader();
	 String str[] = new String[reslist.size()];   	  
	  for (int i = 0; i < reslist.size(); i++) { 
		      		  
         str[i] = reslist.get(i); 
     } 
	  String chromedriverloc = str[2];
	  String appurl =str[0];
	 System.setProperty("webdriver.chrome.driver", chromedriverloc);
	 driver=new ChromeDriver();	 
	 driver.get(appurl); 
	 driver.manage().window().maximize();
 }
}
