package stepDefinition;

import Pages.ForgetPasswordPage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class forgetStepDef {

    WebDriver driver=null;
    ForgetPasswordPage forget=null;
    LoginPage login=null;

    @And("user navigates to login page")
    public void navigateToLoginPage() throws InterruptedException {
        driver= new ChromeDriver();
        login= new LoginPage(driver);
        forget =new ForgetPasswordPage(driver);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.navigate().to("http://www.onlineshop.com/login");
    }

    @When("user click on forget password link")
    public void clickForget() throws InterruptedException {
        login.forgetPass().click();
        Thread.sleep(500);
    }

    @And("user click on reset Button")
    public void clickReset() throws InterruptedException {
        forget.resetPass().click();
        Thread.sleep(1000);
    }


    @Then("instruction sent to user")
    public void successReset(){
        String expectedResult= "Email with instructions has been sent to you.";
        String actualResult= forget.flashRes().getText();
        Assert.assertTrue(expectedResult.contains(actualResult));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
