package gov.cms.ess.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.cms.ess.pages.First_TestPage;
import gov.cms.ess.pages.H_CMS_Page;
import gov.cms.utilities.ConfigurationReader;

public class Test_stepDefinition {
	
	First_TestPage testPage = new First_TestPage();
	
	H_CMS_Page hcmsPage = new H_CMS_Page();
	
	@Given("^I am going to \"([^\"]*)\"$")
	public void i_am_going_to(String EIDM_url) {
	   String URL = ConfigurationReader.getProperty(EIDM_url);
	   testPage.goingToHomePage(URL);
	}

	@And("^checking for security certificates$")
	public void checking_for_security_certificates() throws InterruptedException {
		testPage.checkIfCertificateAndAccept();
	}

	@Then("^I am entering \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_am_entering_DYURCHYK_TEST_and_Summr(String userID, String password) throws InterruptedException {
	    testPage.loginToEIDMAccount(userID, password);
	}

	@Then("^verifying that I have logged in successfully and title is \"([^\"]*)\"$")
	public void verifying_that_I_have_logged_in_successfully(String title) {
		String expectedTextLogo = "Content Management";
	    testPage.loginVerification(title, expectedTextLogo);
	}

	@Then("^I am going to Manage Content Type Page$")
	public void i_am_going_to_Manage_Content_Type_Page() {
		hcmsPage.openContentType();
	}

	@When("^clicking on create content type and entering \"([^\"]*)\" in Content Type name field$")
	public void pop_up_came_out_I_am_entering_Content_name_in_Content_Type_name_field(String ContentTypeName) {
	    hcmsPage.createNewContentType(ContentTypeName);
	}

	@Then("^I am verifying that Content Type has been created$")
	public void i_am_verifying_that_Content_Type_has_been_created() {
	    hcmsPage.checkForAlertMessage();
	}

}
