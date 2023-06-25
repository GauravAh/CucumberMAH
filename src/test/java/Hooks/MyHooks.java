package Hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import DriverFactory.Browserclass;
import UtilitiesPackage.Propclass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
	
	static WebDriver driver;
	static Logger log;
	
	@Before
	public void loadBrowser() {
		Propclass pp = new Propclass();
		Browserclass.browserSet("chrome");
		driver= Browserclass.getBrowser();
		log = LogManager.getLogger(MyHooks.class.getName());
		driver.get(pp.getUrl());
		log.debug("Url redirected to MAH");
		driver.manage().window().maximize();
		log.debug("Browser is maximized");
	}
	 
	@After
	public void quitBrowser(Scenario scenario) throws Exception {
		
		String scenarioName = scenario.getName().replaceAll(" " , "_");
		
		if(scenario.isFailed()) {
			TakesScreenshot Ts = (TakesScreenshot)driver;
			byte[] byt = Ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(byt, "image/png", scenarioName);
		}
		
		Thread.sleep(3000);
		driver.close();
		log.debug("Window is closed");
	}
	
}
