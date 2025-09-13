package org.facebook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static FileInputStream fi;
	public static Workbook book;
	
	public static void browserLaunch() {
		driver=new ChromeDriver();
	}
	public static void waits() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void maxBrowser() {
		driver.manage().window().maximize();
	}
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	public static void dateAndTime() {
		Date d=new Date();
		System.out.println(d);
	}
	
	public static String dataFromExcel(String name,int rowNo,int cellNo) {
		File f=new File("C:\\Users\\ss\\eclipse-workspace\\BddCucumber\\src\\test\\resources\\data\\karthick.xlsx");
		try {
			fi=new FileInputStream(f);			//To file read
		} catch (FileNotFoundException e) {}
		try {
			book=new XSSFWorkbook(fi);			//Work book type
		} catch (IOException e) {}
		Sheet sheet=book.getSheet(name);		//sheet.....>row......>cell
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		String value=null;
		
		if (cellType==CellType.STRING) {
			value = cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat s=new SimpleDateFormat();
			value = s.format(d);
		}else {
			double d = cell.getNumericCellValue();
			long l=(long)d;
			value = String.valueOf(1);
		}
		return value;	
	}
	
	
	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
//	public static String pageUrl() {
//		String currentUrl = driver.getCurrentUrl();
//		return currentUrl;
//	}
	public static void pageUrl() {
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
	}
	public static void closeTheBrowser() {
		driver.close();
	}
	public static void passTxt(WebElement element,String txt) {
		element.sendKeys(txt);
	}
	
	public static void btnClick(WebElement button) {	
		button.click();
	}
	public static void screenShot(String newFile)  {
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\ss\\Music\\fb\\sceenshot\\"+newFile+".png");
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {}
	}
	public static void drag(WebElement from,WebElement to) {
		a =new Actions(driver);
		a.dragAndDrop(from, to);
	}
}
