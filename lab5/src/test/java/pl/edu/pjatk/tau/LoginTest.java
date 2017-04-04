package pl.edu.pjatk.tau;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	static WebDriver driver;
	
    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
    }
    
    @Test
    public void showLoginPage() throws IOException {
       driver.get("http://localhost/login.php");
       
       WebElement loginForm = driver.findElement(By.cssSelector(".login-section form"));
       assertNotNull(loginForm);
       
       WebElement loginField = driver.findElement(By.className("login-input"));
       assertEquals("Nazwa u¿ytkownika", loginField.getAttribute("placeholder"));
       
       WebElement passwordField = driver.findElement(By.className("password-input"));
       assertEquals("Has³o", passwordField.getAttribute("placeholder"));
       
       
       File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(scrFile, new File("target\\validatedLoginPage.png"));
    }
    
    @Test
    public void checkIncorrectCredentials() throws IOException {
    	
    	driver.get("http://localhost/login.php");
    	File scrFile;

    	WebElement loginField = driver.findElement(By.className("login-input"));
    	assertNotNull(loginField);
    	loginField.sendKeys("wrong");
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkIncorrectCredentials-loginEntered.png"));
    	
    	WebElement passwordField = driver.findElement(By.className("password-input"));
    	assertNotNull(passwordField);
    	passwordField.sendKeys("password");
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkIncorrectCredentials-passwordEntered.png"));
    	
    	WebElement loginButton = driver.findElement(By.className("login-button"));
    	assertNotNull(loginButton);
    	loginButton.click();
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkIncorrectCredentials-done.png"));
    }
    
    @Test
    public void checkCorrectCredentials() throws IOException {
    	
    	driver.get("http://localhost/login.php");
    	File scrFile;

    	WebElement loginField = driver.findElement(By.className("login-input"));
    	assertNotNull(loginField);
    	loginField.sendKeys("admin");
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkCorrectCredentials-loginEntered.png"));
    	
    	WebElement passwordField = driver.findElement(By.className("password-input"));
    	assertNotNull(passwordField);
    	passwordField.sendKeys("admin");
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkCorrectCredentials-passwordEntered.png"));
    	
    	WebElement loginButton = driver.findElement(By.className("login-button"));
    	assertNotNull(loginButton);
    	loginButton.click();
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkCorrectCredentials-done.png"));
    	
    	WebElement homePageHref = driver.findElement(By.cssSelector("header > nav > ul > li:first-child"));
    	assertNotNull(homePageHref);
    	homePageHref.click();
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkCorrectCredentials-homeCLicked.png"));
    	
    	WebElement panelPageHref = driver.findElement(By.cssSelector("header > nav > ul > li:last-child"));
    	assertNotNull(panelPageHref);
    	panelPageHref.click();
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkCorrectCredentials-panelCLicked.png"));
    	
    	driver.navigate().back();
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkCorrectCredentials-backToHomePage.png"));
    	
    	driver.navigate().forward();
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkCorrectCredentials-forwardToPanelPage.png"));
    	
    	WebElement logoutPageHref = driver.findElement(By.cssSelector(".panel-navigator > ul > li:last-child"));
    	assertNotNull(logoutPageHref);
    	logoutPageHref.click();
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkCorrectCredentials-invalidateSuccess.png"));
    	
    	
    }
    
    @Test
    public void checkIfJQueryIsLoaded() throws IOException {
    	driver.get("http://localhost/login.php");
    	File scrFile;
    	
    	WebElement jQueryScript =
    			(WebElement) ((JavascriptExecutor)driver).
    			executeScript("checkJQuery();");
    			
    	
    	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("target\\checkIfJQueryIsLoaded-message.png"));
    }
    
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
	
}
