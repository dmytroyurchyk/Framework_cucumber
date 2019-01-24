package gov.cms.ess.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"pretty", 
				"html:target/cucumber-report",
				"json:target/cucumber.json"
		},
		tags = "@smoke",
		features= {"src/test/resources/gov/cms/ess/features/"},
		glue="gov/cms/ess/stepDefinitions/",
		dryRun=false 
)
/**
 * 
 * 
 * @author ib3356
 */
public class Smoke_TestRunner extends AbstractTestNGCucumberTests {

}
