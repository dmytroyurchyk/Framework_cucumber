package gov.cms.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	
	public WebDriver driver;
	
	public WebDriverWait wait;
	
	public void newWait(int sec) {
		wait = new WebDriverWait(driver, sec);
	}

	public void waitForClicability(WebElement button) {
		wait.until(ExpectedConditions.elementToBeClickable(button));
	}

	public void waitForVisibility(WebElement button) {
		wait.until(ExpectedConditions.visibilityOf(button));
	}
	
	public void checkIfCertificateAndAccept() throws InterruptedException {
		newWait(20);
		//Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		//String browserName = cap.getBrowserName();
		String title = driver.getTitle();
		String expectedTitle = "Certificate Error";
		//if (browserName.equalsIgnoreCase("Internet Explorer")) {
			if(title.contains(expectedTitle)){
				driver.get("javascript:document.getElementById('overridelink').click();");
				//logInfo("Capture title", "", expectedTitle, title, false);
				driver.get("javascript:document.getElementById('overridelink').click();");
			//}
		} else{
			//logInfo("Capture title", "", expectedTitle, title, false);
			return;
		}
	}
	
	public void PrivacyErrorCheck(){
		newWait(20);
		
		String title = driver.getTitle();
		String expectedTitle = "Privacy Error";

			if(title.contains(expectedTitle)){
				driver.get("javascript:document.getElementById('overridelink').click();");
				//logInfo("Capture title", "", expectedTitle, title, false);
				//driver.get("javascript:document.getElementById('overridelink').click();");
				PrivacyErrorCheck();
			
		} else{
			//logInfo("Capture title", "", expectedTitle, title, false);
			return;
		}
	}
	
	public void goingToHomePage( String url){
		driver.get(url);
	}
	
	public static void switchToWindow(String targetTitle) {
		String origin = WebDriverUtils.getDriver().getWindowHandle();
		for (String handle : WebDriverUtils.getDriver().getWindowHandles()) {
			WebDriverUtils.getDriver().switchTo().window(handle);
			if (WebDriverUtils.getDriver().getTitle().equals(targetTitle)) {
				return;
			}
		}
		WebDriverUtils.getDriver().switchTo().window(origin);
	}

}
