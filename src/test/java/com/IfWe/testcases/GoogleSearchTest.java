package com.IfWe.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleSearchTest {

	WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		
		 if(browser.equalsIgnoreCase("firefox")){
		        //create firefox instance
			 
		            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("chrome")){
		            System.setProperty("webdriver.chrome.driver","C:\\Selenium\\DriverExe\\chromedriver.exe");
		            driver = new ChromeDriver();
		 }

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
	}

	@Test(dataProvider = "SearchGoogleDataProvider")
	public void testMethod(String searchKey, String expected) throws InterruptedException {

		
			WebElement searchText = driver.findElement(By.name("q"));
			// Search text in google text box
			searchText.sendKeys(searchKey);
			
			driver.findElement(By.xpath(".//*[@id='sblsbb']/button")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String actualResult = driver.findElement(By.xpath(".//*[@id='imagebox_bigimages']/div[1]/a")).getText();
			//Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
			Assert.assertEquals(actualResult, expected , "The Serach Result Message is not matching");
		}

		@AfterMethod
		public void tearDown() {
			driver.quit();
	}

	
	
	 @DataProvider(name="SearchGoogleDataProvider")
     public static Object[][] getDataForGoogleSearch(){
         return new Object[][] {
                 { "i'm feeling lucky","Images for i'm feeling lucky" },
                 { "i'm feeling sorry","Images for i'm feeling sorry"}
             };
     }
	 
}