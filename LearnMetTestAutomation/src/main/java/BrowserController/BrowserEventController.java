package BrowserController;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
 public void selenium_xpathDropdownselect(String webloc, String parameter)
 {
	 List<WebElement> dropelems = driver.findElements(By.xpath(webloc));
	 for(int i =1; i<=dropelems.size(); i++)
	 {
		String eachelemvalxp = webloc+"["+i+"]"+"//span";
		String eachelemval= driver.findElement(By.xpath(eachelemvalxp)).getText();
		if(eachelemval.equalsIgnoreCase(parameter))
		{	
			selenium_xpathmovetoElemClick(eachelemvalxp);
			break;
		}
	 }
 }
 public void selenium_xpathmovetoElemClick(String webloc)
 {
	 Actions action =new Actions(driver);
	 WebDriverWait wait = new WebDriverWait(driver, 30);
	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webloc)));
	 action.moveToElement(element).build().perform();
	 action.moveToElement(driver.findElement(By.xpath(webloc))).click().build().perform();
 }
 public void selenium_xpathmovetoElem(String webloc)
 {
	 Actions action =new Actions(driver);
	 action.moveToElement(driver.findElement(By.xpath(webloc))).build().perform();
 }
 public void selenium_idSendkeys(String webloc, String parameter)
 {
	 driver.findElement(By.id(webloc)).sendKeys(parameter);
 }
 public void selenium_idDropdownselect(String webloc, String parameter)
 {
	 Select country =new Select(driver.findElement(By.id(webloc)));
	 country.selectByVisibleText(parameter);
 }
 public void selenium_xpthDropdownselect(String webloc, String parameter)
 {
	 Select country =new Select(driver.findElement(By.xpath(webloc)));
	 country.selectByVisibleText(parameter);
 }
 public void selenium_xpathswitchToIframe(String webloc)
 {
	 driver.switchTo().frame(driver.findElement(By.xpath(webloc)));
 }
 public void selenium_xpathswitchToDefault()
 {
	 driver.switchTo().defaultContent();
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
	 if(method.equalsIgnoreCase("MoveToElement&Click"))
	 {
		 selenium_xpathmovetoElemClick(webelemloc);
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);
	 }
	 if(method.equalsIgnoreCase("MoveToElement"))
	 {
		 selenium_xpathmovetoElem(webelemloc);
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);
	 }
	 if(method.equalsIgnoreCase("DropdownSelect"))
	 {
		 selenium_xpathDropdownselect(webelemloc, param);
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);
	 }
	 if(method.equalsIgnoreCase("idSendkey"))
	 {
		 selenium_idSendkeys(webelemloc, param);
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);
	 }	
	 if(method.equalsIgnoreCase("idDropdownSelect"))
	 {
		 selenium_idDropdownselect(webelemloc, param);
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);
	 }
	 if(method.equalsIgnoreCase("xpathDropdownSelect"))
	 {
		 selenium_xpthDropdownselect(webelemloc, param);
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);
	 }
	 if(method.equalsIgnoreCase("SwitchToIframe"))
	 {
		 selenium_xpathswitchToIframe(webelemloc);
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);
	 }
	 if(method.equalsIgnoreCase("SwitchToDefault"))
	 {
		 selenium_xpathswitchToDefault();
		 long deltimer = Long.parseLong(delay);
		 Thread.sleep(deltimer);
	 }
 }
}
