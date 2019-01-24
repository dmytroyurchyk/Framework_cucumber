package gov.cms.ess.runners;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport="target/cucumber.json",
                          overviewReport =true,
                          detailedAggregatedReport = true,
                          coverageReport=true,
                          jsonUsageReport ="target/cucumber_usage.json",
                          toPDF= true,
                          outputFolder="target")
@CucumberOptions(
		plugin = {"pretty", 
				"html:target/cucumber-report",
				"json:target/cucumber.json"
		},
		tags = {"@tag", "@tag1"},
		features= {"src/test/resources/gov/cms/ess/features/"},
		glue="gov/cms/ess/stepDefinitions/",
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun=false
)
/**
 * 
 * 
 * @author ib3356
 */
public class MainRunner extends AbstractTestNGCucumberTests {

}