package PagefactoryPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MahLanding {
	
	static WebDriver driver;
	
	public MahLanding(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@class='__input-box auto-signin']/input[@id='email']")
	static WebElement Emailid;
	
	public WebElement setEmailid() {
		return Emailid;
	}

}
