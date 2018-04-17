package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US3StepsDef {
    private PhantomJSDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver",
                "drivers\\MicrosoftWebDriver.exe");
        System.setProperty("webdriver.chrome.driver",
                "drivers\\chromedriver.exe");
        System.setProperty("phantomjs.binary.path",
                "drivers\\phantomjs.exe");


        driver = new PhantomJSDriver();
        driver.get("http://35.187.16.192/COSProject/index.php");
    }



    @When("^i type \"([^\"]*)\" on the input box$")
    public void iTypeOnTheInputBox(String name) throws Throwable {
        WebElement searchbox = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='data-table_filter']/label/input")));

        searchbox.sendKeys(name);
    }

    @Then("^the result should be \"([^\"]*)\" user$")
    public void theFieldIsFilledOutWith(int aux) throws Throwable {
        int i = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr")).size();
        assertEquals(aux, i);
    }


    @Then("^the result should be \"([^\"]*)\" error message$")
    public void theResultShouldBe(String results) throws Throwable {
        assertEquals(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr/td")).getText(),results);
    }



}
