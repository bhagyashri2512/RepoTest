package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
public static String getDataFromExcelSheet(String filepath,String sheetname,int row,int cell) throws EncryptedDocumentException, IOException 
	{
	
		String data="";
		InputStream file=new FileInputStream(filepath);
		Workbook workbook=WorkbookFactory.create(file);
//		System.out.println(workbook);
//		Sheet sheet=workbook.getSheet(sheetname);
//		System.out.println(sheet);
		
		try
		{
		     data=workbook.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	         
	         
		}
		catch(IllegalStateException refe)
		{
			double value=workbook.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
			data=String.valueOf(value);
		}
		catch(NullPointerException refe)
		{
			System.out.println("Cell is blank");
		}
		file.close();

//		InputStream file1=new FileInputStream(filepath);
//		Workbook workbook1=WorkbookFactory.create(file1);
//		String  r1=workbook.getSheet(sheetname).getRow(1).getCell(1).getStringCellValue();
//		System.out.println(r1);
		
		return data;
		
	}

//public static  void captureScreenshot(String TestID) throws InterruptedException, IOException
//{
//	WebDriver driver = new ChromeDriver();
//	  driver.get("https://www.gmail.com"); 
//	  Thread.sleep(3000); 
//	  driver.manage().window().maximize();
//	 for(int i=0;i<5;i++)
//	 {
//		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");  
//			String currentDateTime=dateFormat.format(new Date());
//		 
//	 TakesScreenshot ts=(TakesScreenshot)driver;
//	 File src=ts.getScreenshotAs(OutputType.FILE);
//	 File dest=new File("C:\\Users\\nitin\\Documents\\Bhagya_Testing\\Screenshot\\Test"+TestID+currentDateTime+".jpeg");
//	
//	 FileHandler.copy(src, dest);
//	 Thread.sleep(1000); 
//	 
//	 }	 
//}

	

public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	
	
	String filepath="src\\test\\resources\\DataResource\\TestData.xlsx";
    String sheetname="Data";
    int row=2;
    int cell=2;
	String r=getDataFromExcelSheet(filepath,sheetname,row,cell);
	//System.out.println(r);	
	//captureFailedScreenshot("G123");
	
}
public static void captureFailScreenshot(WebDriver driver,String testId) throws IOException, InterruptedException
{

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");  
		String currentDateTime=dateFormat.format(new Date());
		 
	     TakesScreenshot ts=(TakesScreenshot)driver;
	     File src=ts.getScreenshotAs(OutputType.FILE);
	   
	     File dest=new File("test-output\\FailedTestScreenshot\\"+testId+currentDateTime+".png");
	
	 FileHandler.copy(src, dest);
	 Thread.sleep(1000); 
	 
	 }	 	
}

