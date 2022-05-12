package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
//        PageFactory.initElements( driver,this);
    }

//    //Page Factory Design Pattern
//    @FindBy(id = "username")
//    WebElement usernamePF;
//
//    @FindBy(id = "password")
//    WebElement passwordPF;
//
//    @FindBy(id = "flash")
//    WebElement flashPF;
//
//    @FindBy(css= "a[href=\"/logout\"]")
//    WebElement logOutPF;


    //POM Design Pattern
    public WebElement username(){
        return driver.findElement(By.id("username"));
    }
    public WebElement passwordLog(){
        return driver.findElement(By.id("password"));
    }
    public WebElement forgetPass(){return driver.findElement(By.id("forget"));}
    public By flash(){
        return By.id("flash");
    }
    public WebElement logOut(){
      return driver.findElement(By.cssSelector("a[href=\"/logout\"]"));
    }
    public void loginSteps(String username,String password){
        username().clear();
        username().sendKeys(username);
        passwordLog().sendKeys(password);
    }
}
