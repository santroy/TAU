package pl.edu.pjatk.tau.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.io.FileUtils.copyFile;

public class CarGarage extends WebDriverPage {

    public CarGarage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void openPage() {
        get("http://bakemono.pl/tau/login.php");
        manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        manage().window().maximize();

        try {
            File screenshot = ((TakesScreenshot) this.getDriverProvider().get()).getScreenshotAs(OutputType.FILE);
            copyFile(screenshot, new File("20.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setUser(String email) {
        WebElement element = findElement(By.className("login-input"));
        element.sendKeys(email);

        try {
            File screenshot = ((TakesScreenshot) this.getDriverProvider().get()).getScreenshotAs(OutputType.FILE);
            copyFile(screenshot, new File("21.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setPassword(String password) {
        WebElement element = findElement(By.className("password-input"));
        element.sendKeys(password);

        try {
            File screenshot = ((TakesScreenshot) this.getDriverProvider().get()).getScreenshotAs(OutputType.FILE);
            copyFile(screenshot, new File("22.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void submitLoginClick() {
        WebElement element = findElement(By.className("login-button"));
        element.click();
        //manage().window().maximize();

        try {
            File screenshot = ((TakesScreenshot) this.getDriverProvider().get()).getScreenshotAs(OutputType.FILE);
            copyFile(screenshot, new File("23.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String getLoginFailedMessage() {
        WebElement element = findElement(By.id("badData"));
        assertEquals("Nieprawid³owe dane logowania.", element.getText());

        try {
            File screenshot = ((TakesScreenshot) this.getDriverProvider().get()).getScreenshotAs(OutputType.FILE);
            copyFile(screenshot, new File("24.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return element.getText();
    }
    
  
}