package Tendable_OverallFlow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;




public class TestTendableFunctionality {
	public static WebDriver driver;
	public static WebElement RequestDemo;
	
	public static WebElement elementisclickable(WebElement xpathvalue)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	return wait.until(ExpectedConditions.elementToBeClickable(xpathvalue));
	
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 
		
		
		driver.get("https://www.tendable.com");
		//Checking Home Option Accessibility
		driver.findElement(By.xpath("//a//img[contains(@src,'tendable')]")).click();
		Assert.assertTrue(RequestDemo.isDisplayed());
		elementisclickable(RequestDemo);
		
		//Checking Our Story Option Accessibility
		driver.findElement(By.xpath("//a[text()='Our Story']")).click();
		Assert.assertTrue(RequestDemo.isDisplayed());
		elementisclickable(RequestDemo);
		
		//Checking Our Solution Option Accessibility
		driver.findElement(By.xpath("//a[text()='Our Solution']")).click();
		Assert.assertTrue(RequestDemo.isDisplayed());
		elementisclickable(RequestDemo);
		
		//Checking Why Tendable Option Accessibility
		driver.findElement(By.xpath("//a[text()='Why Tendable?']")).click();
		Assert.assertTrue(RequestDemo.isDisplayed());
		elementisclickable(RequestDemo);
		
		 RequestDemo=driver.findElement(By.xpath("//a[text()='Request A Demo']"));
		
	
		//Filling Form
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		
		driver.findElement(By.xpath("(//div[contains(text(),'Marketing')]//following::button[text()='Contact'])[1]")).click();
		
		driver.findElement(By.xpath("(//input[@name='fullName'])[1]")).sendKeys("abc");
		driver.findElement(By.id("form-input-organisationName")).sendKeys("xyzservices");
		driver.findElement(By.id("form-input-cellPhone")).sendKeys("8899776655");
		driver.findElement(By.id("form-input-email")).sendKeys("abc@gmail.com");
		WebElement Jobroll=driver.findElement(By.xpath("(//select[@name='jobRole'])[1]"));
		Select s=new Select(Jobroll);
		s.selectByVisibleText("Management");
		
		
		
		driver.findElement(By.xpath("(//label[text()='I Agree'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).submit();
		
		//Verify error message
		WebElement errormsg=driver.findElement(By.xpath("//div[@class='ff-form-errors']"));
		Assert.assertTrue(errormsg.isDisplayed(),"Error masg is not present");
		
		
		
		
		
		
	}

}
