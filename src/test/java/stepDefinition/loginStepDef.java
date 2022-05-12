package stepDefinition;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginStepDef {
    public LoginPage login=null;
    public WebDriver driver =null;

    @Given("user open browser")
    public void openBrowser()  {
        String Chromepath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",Chromepath);
    }


    @And("user navigates to login page")
    public void navigateToLoginPage() throws InterruptedException {
        driver = new ChromeDriver();
        login= new LoginPage(driver);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.navigate().to("http://www.onlineshop.com/login");
    }

    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void validData(String username,String password){
        login.loginSteps(username,password);
    }
    @And("user click on login button")
    public void loginClick() throws InterruptedException {
        login.passwordLog().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

//    @Then("user could login successfully")
//    public void successLogin(){
//        String expectedResults ="You logged in successfully";
//        String actualResults = driver.findElement(login.flash()).getText();
//        Assert.assertTrue(actualResults.contains(expectedResults));
//        Assert.assertTrue(login.logOut().isDisplayed());
//    }

    @Then("user could not login successfully")
    public void failedlogin(){
        String expectedResults= "Your data is invalid!";
        String actualResults = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualResults.contains(expectedResults));
    }
    @And("go to home page")
    public void homePage(){
        Assert.assertEquals("http://www.onlineshop.com/home",driver.getCurrentUrl());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
