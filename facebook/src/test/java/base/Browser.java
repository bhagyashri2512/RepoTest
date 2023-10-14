package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
 public static WebDriver launchChrome()
 {
	 System.setProperty("WebDriver.chrome.driver","src\\test\\resources\\BrowserFiles\\chromedriver.exe");
	 ChromeOptions options=new ChromeOptions();
	 options.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(options);
	return driver;
 }
 
 public static WebDriver launchEdge()
 {
	 //System.setProperty("WebDriver.edge.driver","C:\\Users\\nitin\\Downloads\\IEDriverServer_Win32_4.11.0\\IEDriverServer.exe");
	 System.setProperty("WebDriver.edge.driver","src\\test\\resources\\BrowserFiles\\IEDriverServer.exe");
	 WebDriver driver=new EdgeDriver();
	 return driver;
 }
}
