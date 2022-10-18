package tm;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LearnL {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");

	}

	@Test
	public void login() throws InterruptedException {

		WebElement userNameElement = driver.findElement(By.xpath("//input[@type='text']"));
		WebElement passwordElement = driver.findElement(By.xpath("//input[@type='password']"));
		WebElement signInButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
		
		                       
		
		
		userNameElement.sendKeys("demo@techfios.com");
		passwordElement.sendKeys("abc123");
		signInButtonElement.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='get_activity']"))));
		
		WebElement ringButtonElement = driver.findElement(By.xpath("//a[@id='get_activity']"));
                                         
		            
		
		
		Assert.assertTrue("no button",ringButtonElement.isDisplayed());
		
		

		Thread.sleep(3000);
	}

	@After
	public void tearDown() {

		driver.close();
		driver.quit();

	}

}
