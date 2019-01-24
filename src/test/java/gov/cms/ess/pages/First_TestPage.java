package gov.cms.ess.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.cms.utilities.BrowserUtils;
import gov.cms.utilities.WebDriverUtils;

public class First_TestPage extends BrowserUtils {
	
	
	public First_TestPage() {
		this.driver = WebDriverUtils.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='acceptButton']")
	public WebElement acceptButton;

	@FindBy(xpath = "//input[@name='username']")
	public WebElement userIDField;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement passwordField;

	@FindBy(xpath = "//input[@id='buttonUserID']")
	public WebElement loginButton;

	@FindBy(xpath = "//a[@id='overridelink']")
	public WebElement continueLinkIE;
	
	@FindBy (xpath = "//select[contains(@title,'MFA Device Type')]")
	public WebElement MFADeviceDrpDwn;
	
	@FindBy( xpath = "//input[@id='securityCode']")
	public WebElement SecurityCdFld;
	
	@FindBy( xpath = "//p[contains(text(),'Content Management')]")
	public WebElement TextLogo;
	
	public void loginToEIDMAccount(String userID, String password) throws InterruptedException {
		newWait(20);
		//checkIfCertificateAndAccept();

		waitForVisibility(acceptButton);
		acceptButton.click();
		waitForVisibility(userIDField);
		userIDField.sendKeys(userID);
		waitForClicability(loginButton);
		loginButton.click();
		waitForVisibility(passwordField);
		passwordField.sendKeys(password);
		waitForClicability(loginButton);
		loginButton.click();
	}
	
	public void loginVerification(String expectedTitle, String expectedTextLogo){
		newWait(20);
		waitForVisibility(TextLogo);
		assertTrue(TextLogo.getText().trim().equals(expectedTextLogo));
		String title = driver.getTitle();
		assertTrue(title.equals(expectedTitle));
	}

}
