package BrowserController;

import org.openqa.selenium.By;

import ApplicationController.initiateBrowser;

public class BrowserEventController extends initiateBrowser
{
 public void selenium_xpathSendkeys(String webloc, String parameter)
 {
	 driver.findElement(By.xpath(webloc)).sendKeys(parameter);
 }
 public void selenium_xpathClick(String webloc)
 {
	 driver.findElement(By.xpath(webloc)).click();;
 }
 public void executeTestSteps(String teststepno, String testdetails, String webelemloc, String typeofwebelemloc, String method, String param, String delay) throws InterruptedException
 {
	 if(method.equalsIgnoreCase("Sendkey"))
	 {
		 selenium_xpathSendkeys(webelemloc, param);
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);		 
	 }
	 if(method.equalsIgnoreCase("Click"))
	 {
		 selenium_xpathClick(webelemloc);
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);
	 }
 }
}
