package TestPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginContinue;
import pages.LoginOrSignUpPage;

public class Test1 {
	public static void main(String[] args)
	{
		System.setProperty("WebDriver.chrome.driver","C:\\Users\\nitin\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		  //  WebDriverManager.chromedriver().setup();
		    WebDriver driver=new ChromeDriver();
	        driver.get("https://www.facebook.com");	
	        
	        LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
	        loginOrSignUpPage.sendUserName("bhagya789");
	        loginOrSignUpPage.sendPassword("bhagya123");
	        loginOrSignUpPage.clickOnLoginButton();
	        
	        
	        LoginContinue loginContinue=new LoginContinue(driver);
	        loginContinue.clickOnContinueButton();
	        
	}

}
