package sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest {
	public WebDriver driver;
	
	  @BeforeMethod
	  public void launch() {
		  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://amazon.in");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  }

	
	@Test
  public void f() {
		String actualTitle = driver.getTitle();
		String expectedTitle = " Amazon.in: : All Categories";
		Assert.assertEquals(actualTitle, expectedTitle);
	  
	 }
	
	@Test
	public void verifylog()
	{
		boolean flag = driver.findElement(By.xpath("//a[@class=\"nav-logo-link nav-progressive-attribute\"]")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@Test(priority = 1)
	public void autosugg() throws InterruptedException
	{
		WebElement ent=driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
	    ent.click();
		ent.sendKeys("kurtas for women");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
		
	}

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
