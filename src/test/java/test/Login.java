package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	@Test(priority=5)
	public void negativelogin() throws InterruptedException {
	System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
	WebDriverManager.edgedriver().setup();
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://magento.com");
	driver.findElement(By.xpath("//*[@id=\"gnav_565\"]/span/span/span/span")).click();
	driver.findElement(By.id("email")).sendKeys("test@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("welcome");
	driver.findElement(By.id("send2")).click();
	Thread.sleep(3000);
	String error=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
	System.out.println(error);
	Assert.assertEquals(error, "Invalid login or password.");
	driver.quit();
	}
	@Test(priority=10,enabled=false)
	//(dependsOnMethods="negativelogin")
	public void positivelogin() throws InterruptedException {
	System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
	WebDriverManager.edgedriver().setup();
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://magento.com");
	driver.findElement(By.xpath("//*[@id=\"gnav_565\"]/span/span/span/span")).click();
	driver.findElement(By.id("email")).sendKeys("test@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("welcome");
	driver.findElement(By.id("send2")).click();
	Thread.sleep(3000);
	driver.quit();
	
	}
}
