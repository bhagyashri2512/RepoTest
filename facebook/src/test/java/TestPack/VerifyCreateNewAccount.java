package TestPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateNewAccount;

public class VerifyCreateNewAccount {
WebDriver driver;

@BeforeClass
public void launchBrowser()
{
	System.setProperty("WebDriver.chrome.driver","C:\\Users\\nitin\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	 ChromeOptions options=new ChromeOptions();
	 options.addArguments("--remote-allow-origins=*");
	 driver=new ChromeDriver(options);
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
}

@BeforeMethod
public void openLoginPage()
{
	driver.get("https://www.facebook.com");	
    driver.manage().window().maximize();
}

@Test
public void verifyCreateNewAccountButton()
{
	
	CreateNewAccount createNewAccount =new CreateNewAccount(driver);
	createNewAccount.clickOnCreateNewAccount(); 
	
	createNewAccount.selectBirthDate();
	createNewAccount.checkPronounIsDisplayed();
}

@AfterMethod
public void logOutFromApplication()
{
	System.out.println("LogOut");
}
 
@AfterClass
public void closeBrowser()
{
	//driver.quit();
	
}
	

}
