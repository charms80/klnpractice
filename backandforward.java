package ActionCommands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class backandforward {
 WebDriver driver = new FirefoxDriver();
 
 @Before
 public void beforetest() {
  driver.manage().window().maximize();
  
  driver.get("http://www.facebook.com");
 }
 
 //@After
 public void aftertest() {
  driver.quit();
  
 }
 
 @Test
 public void test () throws InterruptedException 
 { 
  driver.navigate().to("https://www.facebook.com/help/cookies/?ref=sitefooter");

  //To navigate back (Same as clicking on browser back button)
  driver.navigate().back();

  //To navigate forward (Same as clicking on browser forward button)
  driver.navigate().forward();
 }
   
}