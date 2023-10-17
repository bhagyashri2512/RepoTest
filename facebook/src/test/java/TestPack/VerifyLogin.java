package TestPack;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pages.LoginContinue;
import pages.LoginOrSignUpPage;
import utilities.Utility;


public class VerifyLogin extends Browser {
WebDriver driver;
private LoginOrSignUpPage loginOrSignUpPage;

static ExtentTest test;
static ExtentHtmlReporter reporter;

@Parameters("browser")

		@BeforeTest 
		public void launchBrowser(@Optional("Chrome") String browserName)
		{
	
	reporter=new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
	ExtentReports extend=new ExtentReports();
	extend.attachReporter(reporter);
			if(browserName.equals("Chrome"))
			{
			
			driver=launchChrome();
			
			//			 ChromeOptions options=new ChromeOptions();
//			 options.addArguments("--remote-allow-origins=*");
//			 driver=new ChromeDriver(options);
			
		}

			if(browserName.equals("Edge"))
			{
			 
			 driver=launchEdge();
			// driver=new EdgeDriver();
			   
		}
			 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));   
		}
        @BeforeClass
        public void creatingPOMObject()
        {
        	  loginOrSignUpPage=new LoginOrSignUpPage(driver); 
        }

		@BeforeMethod
		public void openLoginPage() throws InterruptedException
		{
			driver.get("https://www.facebook.com");	
		    driver.manage().window().maximize();
		   
		    loginOrSignUpPage.sendUserName("bhagya12345");
		    loginOrSignUpPage.sendPassword("bhagya123");
		    Thread.sleep(2000);
		    
		    String userid=loginOrSignUpPage.getUserNameResult();
		    System.out.println(userid);
		   
		    
		    String pwd=loginOrSignUpPage.getPasswordResult();
		    System.out.println(pwd);
		    
//		    if(userid.equals("bhagya12345") && pwd.equals("bhagya123"))
//		    {
//				loginOrSignUpPage.clickOnLoginButton();
//		         System.out.println("Login Test case Pass");
//		    }
//		    else
//		    {
//		    	System.out.println("Login Fail");
//		    }
		    	SoftAssert softAssert=new SoftAssert();
		    softAssert.assertEquals(userid,"bhagya12345","Username not matched");
		   // boolean r="bhagya12345".equals(userid);
		   // softAssert.assertFalse(r);
		    softAssert.assertAll();
		    
		    loginOrSignUpPage.clickOnLoginButton();
		    
		    
		}
		
		@Test
		public void verifyLoginContinuePage()
		{
			int cnt=1;
			LoginContinue loginContinue=new LoginContinue(driver);
			loginContinue.clickOnContinueButton();
			if(cnt==1)
			{
				Assert.fail();
				
			}
			else
			{
				System.out.println("Pass");
			}
		}
		@AfterMethod
		public void logOutFromApplication(ITestResult result) throws IOException, InterruptedException
		{
			System.out.println(ITestResult.FAILURE==result.getStatus());
			if(ITestResult.FAILURE==result.getStatus())
			{
				
			Utility.captureFailScreenshot(driver,"A123");
			}
			System.out.println("LogOut");
			
		}
		 
		@AfterClass
		public void clearObject()
		{
			loginOrSignUpPage=null;
			
		}
		@AfterTest
		public void closeBrowser()
		{
			
			driver.quit();
			driver=null;
			
			System.gc();
		}
		
			
			
			
		}

