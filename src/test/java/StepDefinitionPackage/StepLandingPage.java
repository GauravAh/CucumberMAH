package StepDefinitionPackage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
		driver = Browserclass.getBrowser();
		Thread.sleep(3000);
		log = LogManager.getLogger(StepLandingPage.class.getName());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-800)", "");

	}

	@When("Entered Emailid")
	public void entered_emailid() {
		MahLanding landing = new MahLanding(driver);
		Propclass prop = new Propclass();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + prop.getEmailid() + "';", landing.setEmailid());
		log.debug("Email is entered");
	}

	@And("Subject")
	public void subject() {
		MahLanding landing = new MahLanding(driver);
		Propclass prop = new Propclass();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + prop.getSubject() + "';", landing.setSubject());

	}

	@And("Select valid date")
	public void select_valid_date() throws Exception {
		driver.findElement(By.xpath("//*[@class='__input-box']/div/div/input[@id='date']")).click();
		Thread.sleep(2000);
		String MandY = driver.findElement(By.xpath(
				"//*[@class='__input-box']/div/div/input[@id='date']/following::div/div/span[@class='dpx-title']"))
				.getText();
		String[] arr = MandY.split(" ");
		String month = arr[0];
		String year = arr[1];
		String date = "25";
		String exmonth = "December";
		String exyear = "2023";
		System.out.println("Month and Year is.." + month + year);
		while (!(month.equals(exmonth) && year.equals(exyear))) {
			driver.findElement(By.xpath(
					"//*[@class='__input-box']/div/div/input[@id='date']/following::div/div/span[@class='dpx-next']"))
					.click();
			String MandY1 = driver.findElement(By.xpath(
					"//*[@class='__input-box']/div/div/input[@id='date']/following::div/div/span[@class='dpx-title']"))
					.getText();
			String[] arr1 = MandY1.split(" ");
			String month1 = arr1[0];
			if (month1.equals(exmonth)) {
				List<WebElement> allDates = driver.findElements(By.xpath(
						"//*[@class='__input-box']/div/div/input[@id='date']/following::div/div[2]/span[@class='dpx-out dpx-item' or @class='dpx-item']"));
			//	System.out.println("Date size is.." + allDates);
				for (int i = 0; i < allDates.size(); i++) {
					String Datte = allDates.get(i).getText();
					if (Datte.equals(date)) {
						 allDates.get(i).click();
						 break;
					}
				}
				break;
			}
		}

	}
	
	@And("Select time from dropdown")
	public void select_time_from_dropdown() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='__input-box']/following::select[@id='time']")).click();
		Select select = new Select(driver.findElement(By.xpath("//*[@class='__input-box']/following::select[@id='time']")));
		List<WebElement> allOptions = select.getOptions();
		for(WebElement timeOption : allOptions) {
			String getTimeOption = timeOption.getText();
			if(getTimeOption.equals("6:00 PM")) {
				timeOption.click();
			}
		}
	}
	

	@And("Enter Phone phoneno")
	public void enter_phone_phoneno() {
		driver.findElement(By.cssSelector("div[class*='__input']>div>div>input[id^='Phone']")).sendKeys("9988557744");
	}

	@And("Enter description")
	public void enter_description() {
		driver.findElement(By.cssSelector("div.__input-box>div#desc-drag>textarea#description")).sendKeys("testing pls..");
	}

	@And("Attach a file")
	public void attach_a_file() throws Exception {
		driver.findElement(By.cssSelector("div.__input-box>div#desc-drag>div>div>div#file-attach")).click();
		Thread.sleep(3000);
		String fLoadString = "./ExternalFiles/NFLoad.exe";
		String NFileupload =System.getProperty("user.dir") + "\\ExternalFiles\\TestingDoc.docx";
		String[] arr = {fLoadString,NFileupload};
		Runtime.getRuntime().exec(arr);
	}

	@And("Click on Free Assistance button")
	public void click_on_free_assistance_button() {
		
	}

	@Then("Page should be redirected to the dashboard page")
	public void page_should_be_redirected_to_the_dashboard_page() {

	}

}
