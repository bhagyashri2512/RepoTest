package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {
@FindBy (xpath="//input[@type='text']")
private WebElement userName;

@FindBy (xpath="//input[@type='password']")
private WebElement password;

@FindBy(xpath="//button[text()='Log in']")
private WebElement loginButton;

private WebDriver driver;
//String user;
//String pwd;

public LoginOrSignUpPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	this.driver=driver;	
}

 public  void sendUserName(String user)
 {
	 userName.sendKeys(user);
 }
 
 public String getUserNameResult()
 {
	// return "bhagya";
	//return userName.getText().toString();
	 return userName.getAttribute("value");
	 }
 
 public void sendPassword(String pwd)
 {
	 password.sendKeys(pwd);
 }
 
 public String getPasswordResult()
 {
	
	return password.getAttribute("value");
 }
 

 public void clickOnLoginButton()
 {
 	Actions act=new Actions(driver);
 	act.moveToElement(loginButton).click().build().perform();
 }
}
