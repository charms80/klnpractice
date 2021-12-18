package ActionCommands;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetURL { 
 //To open Firefox browser
 WebDriver driver = new FirefoxDriver();
 
 @Before
 public void beforetest() {

 //To Maximize Browser Window
  driver.manage().window().maximize();

 //To Open URL In browser
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
 }
 
 @After
 public void aftertest() {
  driver.quit();
  
 }
 
 @Test
 public void test () 
 {  
  JavascriptExecutor javascript = (JavascriptExecutor) driver;
    
  //Get current page title
  String pagetitle=(String)javascript.executeScript("return document.title");  
  System.out.println("My Page Title Is  : "+pagetitle);
 
  
  //Get current page URL
  String CurrentURL = driver.getCurrentUrl();
  System.out.println("My Current URL Is  : "+CurrentURL);
 }
}