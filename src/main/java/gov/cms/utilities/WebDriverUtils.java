package gov.cms.utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * 
 * @author ib3356
 */
public class WebDriverUtils {

	private WebDriverUtils() {
	}

	private static WebDriver driver;

	public static WebDriver getDriver() {

		String browser = SystemConfReader.getProperty("browser");

		if (driver == null) {
			switch (browser) {
			case "chrome":
				ChromeOptions options = getOptionsChrome();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
//				driver.manage().window().maximize();
				break;
			case "ff":
				FirefoxOptions option = getOptionsFF();
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(option);
//				driver.manage().window().maximize();
				break;
			case "ie":
				InternetExplorerOptions ieOpts = getOptionsIE();
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver(ieOpts);
//				driver.manage().window().maximize();
				break;
			case "phantom":
				DesiredCapabilities phantomCapabilities = new DesiredCapabilities();
				phantomCapabilities.setJavascriptEnabled(true);
				phantomCapabilities.setCapability("takesScreenshot", true);
				phantomCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
						new String[] { "--web-security=no", "--ignore-ssl-errors=yes" });
				WebDriverManager.phantomjs().setup();
				driver = new PhantomJSDriver(phantomCapabilities);
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		}
		return driver;
	}

	

	private static ChromeOptions getOptionsChrome() {
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setJavascriptEnabled(true);
		capability.setPlatform(Platform.ANY);

		ChromeOptions optns = new ChromeOptions();
		optns.addArguments("test-type");
		optns.addArguments("--disable-extensions");
		//optns.addArguments("--start-maximized");
		// capabilities.setCapability(ChromeOptions.CAPABILITY,
		// options);
		optns.merge(capability);
		
		return optns;
	}
	
	private static FirefoxOptions getOptionsFF(){
		FirefoxOptions fxOptns = new FirefoxOptions();
		
		fxOptns.addPreference("dom.max_chrome_script_run_time", "999");
		fxOptns.addPreference("dom.max_script_run_time", "999");
		fxOptns.addPreference("browser.download.folderList", 2);
		fxOptns.addPreference("browser.download.dir", System.getProperty("automation.dir") + "output/temp");
		fxOptns.addPreference("browser.helperApps.alwaysAsk.force", false);
		fxOptns.addPreference("browser.download.manager.showWhenStarting",false);		
		fxOptns.addPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");
		fxOptns.addPreference("pdfjs.disabled", true);
		fxOptns.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); 
		fxOptns.addPreference("extensions.update.enabled", false);
		fxOptns.addPreference("app.update.enabled", false);
		fxOptns.addPreference("app.update.auto", false);
		fxOptns.addPreference("network.http.use-cache", false);	
		fxOptns.setCapability("marionette", false);
		
		// changes
//		FirefoxProfile ffProfile = new ProfilesIni().getProfile("default");
//		DesiredCapabilities dc = DesiredCapabilities.firefox();
//		
//		// This is to handle the case where Firefox
//		// installation doesn't have a default profile
//		if (ffProfile == null)
//			ffProfile = new FirefoxProfile();
//
//		ffProfile.setPreference("signon.autologin.proxy", true);
//
//		ffProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
//		ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
//				"application/xml,application/octet-stream,text/xml,text/csv,application/vnd.ms-excel,application/csv,text/plain,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//		// driver = new FirefoxDriver(ffProfile);
//		dc.setCapability(FirefoxDriver.PROFILE, ffProfile);
		
		return fxOptns;
				
	}
	
	private static InternetExplorerOptions getOptionsIE() {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
		desiredCapabilities.setBrowserName("internet explorer");
		desiredCapabilities.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, Boolean.TRUE);
		desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, Boolean.TRUE);
		desiredCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,true);
		desiredCapabilities.setJavascriptEnabled(true);
		
		InternetExplorerOptions ieOpts = new InternetExplorerOptions();
		ieOpts.merge(desiredCapabilities);
		
		return ieOpts;
		
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
