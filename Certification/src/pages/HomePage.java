package pages;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;

import Wrappers.GenericWrappers;
import certification.CertificationTest1;

public class HomePage extends GenericWrappers{
	
	FirefoxDriver driver = null;
	Logger logger = Logger.getLogger(HomePage.class);

	
	public HomePage(FirefoxDriver driver) {
		logger.info("Initializing homepage objects");
		this.driver = driver;
	}
	
	public HomePage launchURL(String url) throws IOException {
		driver.get(url);
		driver.manage().window().maximize();
		return this;
	}
	
	
	public HomePage verifyWindowTitle(String title) throws IOException {
		System.out.println("Expected:"+title);
		verifyPageTitle(title);
		//TakeScreenshot(driver,"Google.png");
		return this;
	}
	
	public HomePage enterSearchContent(String content) throws IOException {
		EnterByXpath(".//*[@name='q']", content);
		return this;
	}

}

