package gov.cms.ess.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gov.cms.utilities.WebDriverUtils;
/**
 * 
 * 
 * @author ib3356
 */
public class Hooks {
	
	@Before
	public void setUp(Scenario scenario) {
		WebDriver driver = WebDriverUtils.getDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) WebDriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES);
			// adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
		}
		WebDriverUtils.closeDriver();
	}


}
