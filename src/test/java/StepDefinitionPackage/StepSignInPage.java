package StepDefinitionPackage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.swing.JScrollBar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

import DriverFactory.Browserclass;
import UtilitiesPackage.LoginHashmap;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepSignInPage {

	static WebDriver driver;

	@Given("User should be on landing page")
	public void user_should_be_on_landing_page() throws Exception {
		driver = Browserclass.getBrowser();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-800)", "");
		Thread.sleep(2000);
	}

	@When("Click on Login icon")
	public void click_on_login_icon() {
		Actions actions = new Actions(driver);
		WebElement loginIcon = driver
				.findElement(By.xpath("//*[@class='text-right top-nav-cta-adjust']/div/button/img[@title='menu']"));
		actions.moveToElement(loginIcon).click().build().perform();
	}

	@And("Click mouse over SignIn button")
	public void click_mouse_over_sign_in_button() {
		Actions actions = new Actions(driver);
		WebElement SignIn = driver.findElement(By.xpath(
				"//*[@class='text-right top-nav-cta-adjust']/div/div/a[@href='https://myassignmenthelp.com/Home/login.php']"));
		actions.moveToElement(SignIn).click().build().perform();
	}

	@And("Page redirected to new tab")
	public void page_redirected_to_new_tab() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> itr = allWindow.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
	}

	@And("Enter Emailid")
	public void enter_emailid() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('txtEmail').value='abc@gmail.com';");
	}

	@And("Enter Password")
	public void enter_password() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('password').value='123456';");
	}

	@And("Wait for chat section to appear")
	public void Wait_for_chat_section_to_appear() throws Exception {
		Thread.sleep(12000);
		List<WebElement> allFrames = driver.findElements(By.xpath("//iframe"));
		System.out.println("Frame size is.." + allFrames.size());
		if (allFrames.size() > 0) {
			WebElement FrameId = driver.findElement(By.id("iframeId"));
			driver.switchTo().frame(FrameId);
			WebElement EElement = driver.findElement(By.xpath("//*[@id='ngkisraj']/div/div/following::footer/div/div[4]/div/div/textarea[@id='question']"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].value='testing pls ignore it';", EElement);
		}
	}

	@And("Enter message in chat window")
	public void Enter_message_in_chat_window() throws Exception {
		driver.switchTo().defaultContent();
		JavascriptExecutor lgnBtn = (JavascriptExecutor)driver;
		WebElement lgnBtn1 = driver.findElement(By.id("submit"));
		lgnBtn.executeScript("arguments[0].click();", lgnBtn1);
		Thread.sleep(3000);
	}
	
	@And("NEnter Emailid")
	public void nenter_emailid() throws Exception {
		driver.navigate().to("https://myassignmenthelp.com/Home/forgot.php");
		Thread.sleep(2000);
		System.out.println("Title is.." + driver.getTitle());
		LoginHashmap ii = new LoginHashmap();	
		HashMap<Integer, String> rrtt = ii.hashEg();
		for(int l=1;l<=rrtt.size();l++) {
			driver.findElement(By.cssSelector("div.p-relative>input#txtEmail")).sendKeys(rrtt.get(l));
			driver.findElement(By.cssSelector("div.p-relative>input#txtEmail")).clear();	
		}
		
	}

	@And("NEnter Password")
	public void nenter_password() {
		
	}
	
	@When("Enter Login Emailid as {string}")
	public void nn_enter_login_emailid_as(String emaill) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('txtEmail').value='"+emaill+"';");
	}
	@When("Enter Login Password as {string}")
	public void nn_enter_login_password_as(String ppasss) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('password').value='"+ppasss+"';");
	}
	
	@When("Enter Login Emailid and Password")
	public void enter_login_emailid_and_password(DataTable table) {
		 List<Map<String, String>> ffs = table.asMaps(String.class,String.class);
		for(int i=0;i<ffs.size();i++) {
		String emailii = ffs.get(i).get("emailid");
		String ppppass =ffs.get(i).get("password");
		driver.findElement(By.cssSelector("div.p-relative>input#txtEmail")).sendKeys(emailii);
		driver.findElement(By.cssSelector("div.p-relative>input#password")).sendKeys(ppppass);
		}
	}


}
