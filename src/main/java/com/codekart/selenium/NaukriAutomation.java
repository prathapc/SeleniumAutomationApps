package com.codekart.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class NaukriAutomation {

	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.naukri.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testNaukriAutomated() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Login")).click();
	    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
	    driver.findElement(By.id("pwd1")).clear();
	    driver.findElement(By.id("pwd1")).sendKeys("Naukri.com");
	    driver.findElement(By.name("Login")).click();
	    driver.findElement(By.cssSelector("a[title=\"Home\"]")).click();
	    driver.findElement(By.cssSelector("button.w140")).click();
	    driver.findElement(By.linkText("Edit")).click();
	    driver.findElement(By.cssSelector("button.w150bt.fl")).click();
	    driver.findElement(By.linkText("Logout")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
