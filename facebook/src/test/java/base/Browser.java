package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
 public static WebDriver launchChrome()
 {
	 ChromeOptions options=new ChromeOptions();
	 options.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(options);
	return driver;
 }
 
 public static WebDriver launchEdge()
 {
	 WebDriver driver=new EdgeDriver();
	 return driver;
 }
}
