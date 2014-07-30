package com.codekart.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AkoshaAutomationApp {
	
	private static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.get("http://www.akosha.com");
		driver.findElement(By.linkText("Login / Signup")).click();
		driver.findElement(By.id("txtEmail")).sendKeys("ppchowdary@yahoo.in");
		driver.findElement(By.id("txtPassword")).sendKeys("prathap1228");
		driver.findElement(By.id("signbt")).click();
		
		driver.findElement(By.cssSelector("a.logged-user.dropdown-toggle > b")).click();
		driver.findElement(By.linkText("My Profile")).click();
		driver.findElement(By.linkText("Update Profile")).click();
		
		driver.findElement(By.cssSelector("a.logged-user.dropdown-toggle > b")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	}

}
