package DDD_dataDrivenDevelopment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDD_Project {
	
	WebDriver driver;
	WebDriverWait wait;
	DDD_utils util;
	DDD_utils Xutil;
	String path = "./DataFile/employee.xlsx";
	int r = 1;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "/Users/honasa/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "login data")
	public void loginTest(String username, String password, String validation) throws IOException {
		
		Xutil = new DDD_utils(path);
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		WebElement email = driver.findElement(By.id("Email"));
		WebElement pass = driver.findElement(By.id("Password"));
		WebElement logButton = driver.findElement(By.xpath("//button"));
		//WebElement logOutButton = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
		
		
		
		email.clear();
		email.sendKeys(username);
		
		pass.clear();
		pass.sendKeys(password);
		
		logButton.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		if(validation.equals("valid")) {
			if(driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).isDisplayed()) {
				driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
				Xutil.setDataToCell(r++, 4, "Pass");
				Assert.assertTrue(true);
			}
			else {
				Xutil.setDataToCell(r++, 4, "Fail");
				Assert.assertTrue(false);
				
			}
		}
		else if(validation.equals("invalid")) {
			if(driver.findElement(By.id("Password")).isDisplayed()) {
				Xutil.setDataToCell(r++, 4, "Pass");
				Assert.assertTrue(true);
				
			}
			else {
				Xutil.setDataToCell(r++, 4, "Fail");
				Assert.assertTrue(false);
				
			}
		}
	}
	
	@DataProvider(name = "login data")
	public String[][] getData() throws IOException {
		// String loginData[][] = { {"admin@yourstore.com","admin","valid"}, {"admin@yourstore.com","admn","invalid"}};
		
		util = new DDD_utils(path);
		int rowlength = util.getRowsNumber();
		int collength = util.getCellsNumber(1);
		
		String loginData[][] = new String[rowlength][collength];
		
		for(int r=1; r<=rowlength; r++) {
			for(int c=0; c< collength; c++) {
				loginData[r-1][c] = util.getDataFromCell(r, c);
			}
		}
		
		return loginData;
	}
	
	@AfterClass
	public void tearDown() {
		driver.close(); 
	}

}
