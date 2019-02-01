package Wrappers;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class GenericWrappers extends Reporter{

	public static FirefoxDriver driver ;
	
	/*public void TakeScreenshot(FirefoxDriver driver,String filePath) throws IOException {
		TakesScreenshot tscrShot =((TakesScreenshot)driver) ;
		File srcFile = tscrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		FileUtils.copyFile(srcFile, destFile);
	}*/
	
	public FirefoxDriver initDriver() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", false);
		driver = new FirefoxDriver(options);
		return driver;
	}
	
	public void launchURI(String url) {
		driver.get(url);
	}
	
	public void verifyPageTitle(String ExpectedValue) throws IOException {
		String retrieveWindowTitle = driver.getTitle();
		try {
			Assert.assertEquals(ExpectedValue, retrieveWindowTitle);
			
			System.out.println("Macthed successful:"+retrieveWindowTitle +" against expected "+ExpectedValue);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			fail(e.getMessage());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	public void EnterByXpath(String xpath,String content) {
		try {
		driver.findElement(By.xpath(xpath)).sendKeys(content);
		System.out.println("Text has been entered successfully");
		}catch(AssertionError e) {
			fail("Not able to enter text.");
		}
	}
	
	//@SuppressWarnings({ "deprecation", "unused" })
	public void WaituntilExistsByXpath(String xpath,String content) {
		try {
			 // Waiting 30 seconds for an element to be present on the page, checking

			  // for its presence once every 5 seconds.
			  Wait<FirefoxDriver> wait = new FluentWait<FirefoxDriver>(driver)
			    .withTimeout(Duration.ofSeconds(30))
			    .pollingEvery(Duration.ofSeconds(3))
			    .ignoring(NoSuchElementException.class);

			  wait.until(new Function<WebDriver,WebElement>(){
				  public WebElement apply(WebDriver driver) {
					  return driver.findElement(By.xpath(xpath));
				  }
			  });
			}catch(Exception e) {
				fail("Not able to enter text.");
			}
		}
	
	
	public void TakeSnap() throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot)driver;
		
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File("temp.png"));
		
		
	}
	
	
	
	
	/*
	  WebElement element = wait.until(new Function<WebDriver,WebElement>(){

	    public WebElement apply(WebDriver driver) {

	    return driver.findElement(By.xpath(xpath));

	    }
	   });*/
	
}
