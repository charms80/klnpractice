package javaexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Ebaysearch {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver;
        String url = "https://www.ebay.uk";
        String path = System.getProperty("user.dir");
        System.out.println("path is " + path);
        System.setProperty("webdriver.chrome.driver", path + "/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.co.uk/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"gdpr-banner-accept\"]")).click();
        driver.findElement(By.id("gh-ac")).sendKeys("apple watch");
        Thread.sleep(1000);
        WebElement dropElement = driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));
        Select selectCategory = new Select(dropElement);
        selectCategory.selectByVisibleText("Jewellery & Watches");
        Thread.sleep(2000);
        driver.findElement(By.id("gh-btn")).click();
        //printing  total result of search of apple watch in jwellery and watches category.
        String result = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[2]/div[2]/div[1]/div[1]/h1/span[1]")).getText();
        System.out.println("Printing the search of apple watch's total result is :: " + result);
        System.out.println("--------------------------------------------------------------------------------------------");
        Thread.sleep(1000);
        //printing result of products of First page
        //store all products in data structure.
        List<WebElement> allProduct = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[2]"));
        for (WebElement product : allProduct) {
            System.out.println(product.getText());
            System.out.println("Total 50 Products on FIRST page are printed  as above ");
            System.out.println("******************************************************************************************");
        }
        // to find 10th product from  product search list
        // int itemNumber=1;
        String productXpath = String.format("//*[@id=\"srp-river-results\"]/ul/li[10]");
        String nthProduct = driver.findElement(By.xpath(productXpath)).getText();
        System.out.println("10th Product :: " + nthProduct);
        System.out.println("******************************************************************************************");
        Thread.sleep(1000);
        // get all products through scrolldown.
        Actions action = new Actions(driver);
        List<WebElement> Productsroll = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
        for (WebElement products : Productsroll) {
            action.moveToElement(products).build().perform();
            System.out.println(products.getText());
           System.out.println("--------------------------------------------------------------------------------------------");
        }
        driver.quit();
    }
}




