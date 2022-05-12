package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ForgetPasswordPage {
    WebDriver driver=null;
    public ForgetPasswordPage(WebDriver driver) {this.driver=driver;}

    public WebElement resetPass(){return driver.findElement(By.id("reset"));}
    public WebElement flashRes(){return driver.findElement(By.id("flashres"));}

}
