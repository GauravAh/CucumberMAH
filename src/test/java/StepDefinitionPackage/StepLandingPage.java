package StepDefinitionPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import DriverFactory.Browserclass;
import PagefactoryPackage.MahLanding;
import UtilitiesPackage.Propclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepLandingPage {

	static WebDriver driver; 
	Logger log;
	
	@Given("User should be on MAH landing page")
	public void user_should_be_on_mah_landing_page() throws Exception {
		driver =Browserclass.getBrowser();
		Thread.sleep(3000);
		log = LogManager.getLogger(StepLandingPage.class.getName());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)","");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-800)","");
		
	}
	@When("Entered Emailid")
	public void entered_emailid() {
		MahLanding landing = new MahLanding(driver);
		Propclass prop = new Propclass();
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].value='"+prop.getEmailid()+"';",landing.setEmailid());
		log.debug("Email is entered");
	}
	@And("Subject")
	public void subject() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement SubjectField = driver.findElement(By.id("autocomplete"));
		js.executeScript("arguments[0].value='testing_tech-maths';",SubjectField);
	  
	}
	@And("Select valid date")
	public void select_valid_date() {
	   
	}
	@And("Select time from dropdown")
	public void select_time_from_dropdown() {
	   
	}
	@And("Enter Phone phoneno")
	public void enter_phone_phoneno() {
	    
	}
	@And("Enter description")
	public void enter_description() {
	    
	}
	@And("Attach a file")
	public void attach_a_file() {
	    
	}
	@And("Click on Free Assistance button")
	public void click_on_free_assistance_button() {
	    
	}
	
	@Then("Page should be redirected to the dashboard page")
	public void page_should_be_redirected_to_the_dashboard_page() {
	    
	}




}
