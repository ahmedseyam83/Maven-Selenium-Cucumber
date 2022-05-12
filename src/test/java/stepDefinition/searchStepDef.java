package stepDefinition;


import Pages.homePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchStepDef {
    WebDriver driver=null;
    homePage home=null;

    @When("^user search about \"(.*)\" products$")
    public void searchFor(String product){
        home.search().sendKeys(product);
        home.search().sendKeys(Keys.ENTER);
    }

    @And("user navigates to home page")
    public void navigateToHomePage() throws InterruptedException {
        driver = new ChromeDriver();
        home= new homePage(driver);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.navigate().to("http://www.onlineshop.com/home");
    }

    @And("Not found a result")
    public void notFound(){
        String expectedResults ="Not found a result";
        String actualResults = home.flashRes().getText();
        Assert.assertTrue(actualResults.contains(expectedResults));
    }
    @Then("navigates to search result")
    public void navigateToSearch(){Assert.assertNotEquals("http://www.onlineshop.com/home",driver.getCurrentUrl());}

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
