package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccount {
@FindBy (xpath="//a[text()='Create new account']")
WebElement createNewAccount;

@FindBy (xpath="//select[@id='day']")
WebElement dayOfBirthday;

@FindBy (xpath="//select[@id='month']")
WebElement monthOfBirthday;

@FindBy (xpath="//select[@id='year']")
WebElement yearOfBirthday;

@FindBy (xpath="//select[@name='preferred_pronoun']")
WebElement pronoun;

WebDriver driver;
public CreateNewAccount(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	this.driver=driver;
}

public void clickOnCreateNewAccount()
{
	createNewAccount.click();
	
}

public void selectBirthDate()
{
	Select d=new Select(dayOfBirthday);
	d.selectByVisibleText("25");
	
	Select m=new Select(monthOfBirthday);
	m.selectByVisibleText("Mar");
	
	Select y=new Select(yearOfBirthday);
	y.selectByVisibleText("1995");
	
}
public void checkPronounIsDisplayed()
{
	boolean result=pronoun.isDisplayed();
	System.out.println(result);
}
}
