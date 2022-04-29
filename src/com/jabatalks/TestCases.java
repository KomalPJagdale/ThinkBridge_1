package com.jabatalks;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {
  @Test(priority=1 )
  public void Verify_dropdown_Eng() throws IOException
  {
  	WebDriver driver= Create_Account.brawserSetup();
    driver.findElement(By.xpath("//div[@class='form-container']/section/div/div/span")).click();
  	
  	String actual= driver.findElement(By.xpath("(//div[@class='ng-binding ng-scope'])[1]")).getText();
    Assert.assertEquals(actual, "English" );
    System.out.println("language is "+actual);
    driver.close(); 
  }
  
  @Test(priority=2 )
  public void Verify_dropdown_Dutch() throws IOException
  {
  	WebDriver driver= Create_Account.brawserSetup();
  	
    driver.findElement(By.xpath("//div[@class='form-container']/section/div/div/span")).click();
  	
  	String actual= driver.findElement(By.xpath("(//div[@class='ng-binding ng-scope'])[2]")).getText();
    Assert.assertEquals(actual, "Dutch" );
    System.out.println("language is "+actual);
    driver.close(); 
  }
  
  @Test(priority=3 )
  public void Verify_Email() throws IOException, InterruptedException
  {
  	WebDriver driver= Create_Account.brawserSetup();
  	
    driver.findElement(By.xpath("//div[@class='form-container']/section/div/div/span")).click();
  	driver.findElement(By.xpath("(//div[@class='ng-binding ng-scope'])[1]")).click();
  	driver.findElement(By.id("name")).sendKeys("Komal");
  	driver.findElement(By.id("orgName")).sendKeys("Komal");
  	driver.findElement(By.id("singUpEmail")).sendKeys("komaltest1234@mailsac.com");
  	WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
  	JavascriptExecutor js = (JavascriptExecutor) driver;

  	js.executeScript("arguments[0].click();", checkbox);
  	
  	driver.findElement(By.xpath("//button[@type='submit']")).click();
  	
  	WebDriver driver1= new ChromeDriver();
  	driver1.get("https://mailsac.com/inbox/komaltest1234@mailsac.com");
  	String email=driver1.findElement(By.xpath("(//strong[@class='ng-binding'])[1]")).getText();

  
  	Assert.assertEquals(email, "donotreply-dev@jabatalks.com" );
  
    
    driver.close();
  }
}
