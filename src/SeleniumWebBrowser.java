import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumWebBrowser {

    protected static WebDriver driver;
    //java main method
    public static void main(String[] args) {
        //
        System.setProperty("webdriver.chrome.driver","src\\WebDriver\\chromedriver.exe");
        //driver syntax and url open in chrome
        driver =new ChromeDriver();
        //Implicit wait applied to driver instance-which will be applied to driver until driver instant
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //driver grt the url to open demo website
        driver.get("https:/demo.nopcommerce.com/");
        //click on register for new person with xpath
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //person first name in the box with xpath
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Sofia");
        //give xpath for last name in the box
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys( "Grande");
        //using string for a not to repeat username or emailid
        String UserName =""+(int)(Math.random()*Integer.MAX_VALUE);
        String EmailID = "nehs"+UserName+"@hotmail.com";
        //give xpath for email id in the box
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(EmailID);
        //System.out.println(EmailID);
        //for password give xpath
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("test1test");
        //for using xpath confirm password
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("test1test");
        //given xpath for register button
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        //with xpath get the actual result
        String actualRegistrationSuccessMassege = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(    "Your registration completed",actualRegistrationSuccessMassege);
        //closes driver instance
        driver.quit();
    }
}
