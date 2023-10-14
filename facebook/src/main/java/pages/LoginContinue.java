package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginContinue {
@FindBy (xpath="//button[@value='1']")
private WebElement continueButton;

private WebDriver driver;

public LoginContinue(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	this.driver=driver;
}

public void clickOnContinueButton()
{
	Actions act=new Actions(driver);
	act.moveToElement(continueButton).click().build().perform();
}
}
