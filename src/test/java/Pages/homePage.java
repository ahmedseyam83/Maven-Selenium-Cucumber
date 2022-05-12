package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
    WebDriver driver=null;
    public homePage(WebDriver driver) {this.driver=driver;}
    public WebElement search(){return driver.findElement(By.id("search"));}
    public WebElement flashRes(){return driver.findElement(By.id("flashres"));}

}
