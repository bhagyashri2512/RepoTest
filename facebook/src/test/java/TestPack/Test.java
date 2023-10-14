package TestPack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginContinue;
import pages.LoginOrSignUpPage;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
public static void main(String[] args)
{
	System.setProperty("WebDriver.chrome.driver","C:\\Users\\nitin\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	  //  WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");	
        
        LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
        loginOrSignUpPage.sendUserName("bhagya123");
        loginOrSignUpPage.sendPassword("bhagya");
        loginOrSignUpPage.clickOnLoginButton();
        
       
        
}
}
