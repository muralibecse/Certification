package certification;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import Wrappers.ProjectWrapper;
import pages.HomePage;

public class CertificationTest1 extends ProjectWrapper{
	FirefoxDriver driver ;
	Logger logger = Logger.getLogger(CertificationTest1.class);
	
	@Test
	public void testCase() throws IOException {
		
		BasicConfigurator.configure();	

		
		driver = initDriver();
		logger.info("driver launched");
		HomePage hm = new HomePage(driver);
		hm.launchURL("https://www.google.com")
		.verifyWindowTitle("Google2")
		.verifyWindowTitle("Google");
		driver.quit();
		
		
	}

}
