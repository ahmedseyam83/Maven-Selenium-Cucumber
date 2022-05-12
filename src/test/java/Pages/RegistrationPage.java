package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    WebDriver driver=null;
    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement firstName(){return driver.findElement(By.id("firstname"));}
    public WebElement lastName(){return driver.findElement(By.id("lastname"));}
    public WebElement emailAddress(){return driver.findElement(By.id("email"));}
    public WebElement passwordReg(){return driver.findElement(By.id("password"));}
    public WebElement passwordCon(){return driver.findElement(By.id("passwordconfirmation"));}
    public WebElement flashReg(){return driver.findElement(By.id("flashreg"));}

    public void RegistrionSteps(String first,String last,String email,String password){
        firstName().clear();
        firstName().sendKeys(first);
        lastName().sendKeys(last);
        emailAddress().sendKeys(email);
        passwordReg().sendKeys(password);
        passwordCon().sendKeys(password);
    }
}
