package TestPack;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pages.CreateNewAccount;
import pages.LoginOrSignUpPage;
import utilities.Utility;

public class VerifyCreateNewAccount  extends Browser{
WebDriver driver;
private CreateNewAccount createNewAccount;
@Parameters("browser")

@BeforeTest 
public void launchBrowser(@Optional("Chrome") String browserName)
{
	if(browserName.equals("Chrome"))
	{
	
	    driver=launchChrome();
	
     }

	if(browserName.equals("Edge"))
	{
	 
	 driver=launchEdge();
	}
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));   
}

@BeforeClass
public void craetePOMObject()
{
	createNewAccount=new CreateNewAccount(driver);
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
	int cnt=1;
	CreateNewAccount createNewAccount =new CreateNewAccount(driver);
	createNewAccount.clickOnCreateNewAccount(); 
	
	createNewAccount.selectBirthDate();
	createNewAccount.checkPronounIsDisplayed();
	
}

@AfterMethod
public void logOutFromApplication(ITestResult result) throws IOException, InterruptedException
{
	System.out.println(ITestResult.FAILURE==result.getStatus());
	if(ITestResult.FAILURE==result.getStatus())
	{
		
	Utility.captureFailScreenshot(driver,"B123");
	}
	System.out.println("LogOut");
	
}
 
@AfterClass
public void clearObject()
{
	createNewAccount=null;
	
}
@AfterTest
public void closeBrowser()
{
	
	driver.quit();
	driver=null;
	
	System.gc();
}

	

}
