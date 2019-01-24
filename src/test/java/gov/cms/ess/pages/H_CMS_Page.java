package gov.cms.ess.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.cms.utilities.BrowserUtils;
import gov.cms.utilities.WebDriverUtils;

public class H_CMS_Page extends BrowserUtils {
	
	public H_CMS_Page() {
		this.driver = WebDriverUtils.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@routerlink='/manage-content-types']")
	public WebElement ManageContentTypeButton;

	@FindBy(xpath = "//button[contains(text(),'Create Content Type')]")
	public WebElement CreateContentType;

	@FindBy(xpath = "//input[@name='contentTypeName']")
	public WebElement ContentTypeNameTextBox;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement CreateButton;

	@FindBy(xpath = "//button[.='Cancel']")
	public WebElement CancelButton;

	@FindBy(xpath = "//button[.='Close']")
	public WebElement CloseButton;

	@FindBy(xpath = "//div[contains(@class,'ds-l-col')]/h3")
	public WebElement ContentTypeNumber;

	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement AlertMessage;

	@FindBy(xpath = "//div[@class='ds-l-sm-col--9']")
	public List<WebElement> listOfElementsCreated;

	@FindBy(xpath = "//button[.='Edit']")
	public WebElement EditButton;

	@FindBy(xpath = "//button[.='Edit Content Type']")
	public WebElement EditContentTypeButton;

	@FindBy(xpath = "//button[.='Archive']")
	public List<WebElement> ArchiveButton;

	@FindBy(xpath = "//button[.='Archive']")
	public WebElement ArchiveButtonMetaData;

	@FindBy(xpath = "//button[.='Yes']")
	public WebElement YesButton;

	@FindBy(xpath = "//button[.='No']")
	public WebElement NoButton;

	@FindBy(xpath = "//div[text()[contains(.,'required')]]")
	public WebElement ErrorMessage;

	@FindBy(xpath = "//div[@class='toast-title ng-star-inserted']")
	public WebElement popUpName;

	// MetaData elements

	@FindBy(xpath = "//button[text()[contains(.,'Add New Field')]]")
	public WebElement AddNewField;

	@FindBy(xpath = "//input[@placeholder='Metadata Description']")
	public WebElement MetaDataDescriptionBox;

	@FindBy(xpath = "//select")
	public WebElement MetaDataTypeSelectBox;

	String textInputOption = "Text Input";
	String htmlTextOption = "Rich HTML Text";
	String textAreaOption = "Text Area";
	String dateInputOption = "Date Input";
	String booleanOption = "Boolean";
	String fileOption = "File";
	String[] options = { htmlTextOption, textInputOption, textAreaOption, dateInputOption, booleanOption, fileOption };

	@FindBy(xpath = "//input[@placeholder='Metadata Mask']")
	public WebElement MetaDataMaskBox;

	@FindBy(xpath = "//input[@placeholder='Metadata Weight']")
	public WebElement MetaDataWeightBox;

	@FindBy(name = "metaRequired")
	public WebElement RequiredCheckBox;

	@FindBy(name = "metaTaxonomy")
	public WebElement TaxonomyCheckBox;

	@FindBy(name = "metaPublic")
	public WebElement PublicCheckBox;

	@FindBy(xpath = "//input[@placeholder='Metadata Name']")
	public WebElement MetaDataNameBox;

	@FindBy(xpath = "//div[contains(@class,'ds-l-col')]/h3")
	public WebElement MetaDataNumber;

	@FindBy(className = "validation-error")
	public List<WebElement> RequiredFieldError;

	@FindBy(xpath = "//a[@aria-label='Next']")
	public WebElement NextButton;

	@FindBy(xpath = "//li[@class='page-item active']")
	// @FindBy( className = "page-item active")
	public WebElement activePageNumber;

	@FindBy(xpath = "//a[@class='page-link']") // li[@class='page-item']
	public List<WebElement> PageNumbers;

	@FindBy(xpath = "//*[@class='validation-error']")
	public WebElement errorMsg;

	@FindBy(xpath = "//*[@class='ds-c-button ds-c-button--primary']")
	public WebElement saveButton;


	String MetaDataName = "test Meta Data " + new Random().nextInt(9999);
	String MetaDataDescription = "test description Meta Data " + new Random().nextInt(9999);
	String MetaDataMask = "test Meta Data mask " + new Random().nextInt(9999);
	int MetaDataWeight = new Random().nextInt(99);

	String MetaDataCreatedMessage = "New Metadata has been created";

	// use when you looking only for one message only
	@FindBy(xpath = "//div[@class='validation-error']")
	public WebElement GeneralErrorMessage;
	
	public void openContentType() {
		newWait(20);
		waitForVisibility(ManageContentTypeButton);
		ManageContentTypeButton.click();
	}
	
	public void createNewContentType(String contentTypeName) {
		newWait(20);
		waitForVisibility(CreateContentType);
		CreateContentType.click();
		//String message = "Automation Script Content Type Test " + new Random().nextInt(9999);
		//logInfo("Creating new Content Type ", message, "", "", false);
		ContentTypeNameTextBox.sendKeys(contentTypeName);
		CreateButton.click();
	}
	
	public boolean checkForAlertMessage() {
		boolean checkr;
		if (AlertMessage.isDisplayed()) // AlertMessage.getText().contains(expectedMessage)
		{
			//logInfo("Capture Alert Message ", "", expectedMessage, AlertMessage.getText(), false);
			checkr = true;
		} else {
			//logFailureInfo("Capture Alert Message ", "", expectedMessage, AlertMessage.getText());
			checkr = false;
		}
		return checkr;
	}
	

}
