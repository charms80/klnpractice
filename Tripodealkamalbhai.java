import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tripodealkamalbhai {
        ChromeDriver driver;
        @Before
        public void setUp() throws Exception {
            String path = System.getProperty("user.dir");
            System.out.println("path is: " + path);
            System.setProperty("webdriver.chrome.driver", path + "/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.tripodeal.com/");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        @Test
        public void flights() throws InterruptedException {
            //Click on Round Trip
            driver.findElement(By.xpath("//input[@id='returnDateRequiredYes']")).click();
            //Click on From and select Delhi
            WebElement from = driver.findElement(By.xpath("//*[@id=\"origin\"]"));
            from.sendKeys("Delhi");
            from.sendKeys(Keys.ARROW_DOWN);
            from.sendKeys(Keys.ENTER);
            WebDriverWait Wait1 = new WebDriverWait(driver, 20);
            Wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"destination\"]")));
            //Click on To and select Surat
            WebElement To = driver.findElement(By.xpath("//*[@id=\"destination\"]"));
            To.sendKeys("Surat");
            Thread.sleep(2000);
            //     WebDriverWait Wait2 = new WebDriverWait(driver,20);
            //   Wait2.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@value='STV']")));
            To.sendKeys(Keys.ARROW_DOWN);
            To.sendKeys(Keys.ARROW_DOWN);
            To.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            //  WebDriverWait Wait3 = new WebDriverWait(driver, 20);
            //  Wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dateNew']")));
            //Click on Depart Date so that datepicker will come
            driver.findElement(By.xpath("//input[@id='dateNew']")).click();
            // Thread.sleep(4000);
       /* WebElement Datewidget = driver.findElement(By.xpath("(//div[contains(@class,'picker__box')])[1]"));
        Datewidget.findElement(By.tagName("tr"));
        List<WebElement> columns = Datewidget.findElements(By.tagName("td"));
        Thread.sleep(2000);
        WebDriverWait Wait3 = new WebDriverWait(driver, 20);
        Wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("\t//div[starts-with(@id, 'dateNew_')]")));
        for (WebElement cell : columns) {
            if (cell.getText().equals("30")) {
                cell.findElement(By.xpath("//*[@id=\"dateNew_1638230400000\"]")).click();
                System.out.println(cell.getText());
                break;
            }
        }*/
            //Click on 07 Dec.21
            driver.findElement(By.xpath("//*[@id=\"dateNew\"]")).sendKeys("21/12/21");
            //Click on Return date
            driver.findElement(By.xpath("//*[@id=\"dateNewRet\"]")).click();
            Thread.sleep(2000);
            //WebDriverWait Wait4 = new WebDriverWait(driver, 20);
            //  Wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='dateNewRet_root']//div[@title='Next month']")));
            //Click on next month arrow
            // driver.findElement(By.xpath("//div[@id='dateNewRet_root']//div[@title='Next month']")).click();
            // Thread.sleep(2000);
            //Click on 25 Dec.21
            driver.findElement(By.xpath("//*[@id=\"dateNewRet_1640390400000\"]")).click();
            //Click on Travellers
            driver.findElement(By.xpath("//*[@id=\"traveller\"]")).click();
            //click on Adult + sign
            driver.findElement(By.xpath("(//button[contains(@type,'button')])[3]")).click();
            //Click on Child two times
            driver.findElement(By.xpath("(//i[contains(@class,'zmdi zmdi-hc-2x zmdi-plus-circle')])[2]")).click();
            driver.findElement(By.xpath("(//i[contains(@class,'zmdi zmdi-hc-2x zmdi-plus-circle')])[2]")).click();
            //Click on Done
            driver.findElement(By.xpath("//input[@name='done']")).click();
            //Click on Search
            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
            //Get Carrier
            String Carrier = driver.findElement(By.xpath("//*[@class=\"custom-control-label form-filter\"]")).getText();
            //Get Price
            String Price = driver.findElement(By.xpath("//*[@class=\"float-right money\"]")).getText();
            //Print Carrier with price
            System.out.println("Carrier with price: " + Carrier + Price);
            List<WebElement> List_Price=driver.findElements(By.xpath("//*[@class='font-weight-bold h6 pt-1 money']"));
            System.out.println(List_Price.size());
            for(WebElement  List :List_Price)
            {
                System.out.println(List.getText().replace("₹",""));
            }
        }
        @After
        public void tearDown() throws Exception {
            driver.quit();
        }
    }

