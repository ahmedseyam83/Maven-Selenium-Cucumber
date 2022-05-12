package stepDefinition;

import stepDefinition.loginStepDef;
import Pages.RegistrationPage;
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

public class registrationStepDef {
    RegistrationPage registration=null;
    WebDriver driver=null;


    @And("user navigates to Register page")
    public void navigatetoRegPage() throws InterruptedException {
        driver = new ChromeDriver();
        registration = new RegistrationPage(driver);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.navigate().to("http://ww.onlineshop.com/Reg");
    }

    @When("^user enter \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void validData(String first,String last,String email,String password){
        registration.RegistrionSteps(first,last,email,password);
    }

    @And("user click on register button")
    public void regClick() throws InterruptedException {
        registration.passwordCon().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @Then("user registered successfully")
    public void successfulReg(){
        String ExpectedResult = "You have been registered successfully";
        String ActualResult = registration.flashReg().getText();
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
    }

    @Then("user could not register successfully")
    public void failedReg(){
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
