package PagefactoryPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
	
	@FindBys({@FindBy(id = "autocomplete"), @FindBy(xpath = "//*[@class='easy-autocomplete']/input[@name='Subject_Name' and @id='autocomplete']")})
	static WebElement Subjectfield;
	
	public WebElement setEmailid() {
		return Emailid;
	}
	
	public WebElement setSubject() {
		return Subjectfield;
	}
	
}
