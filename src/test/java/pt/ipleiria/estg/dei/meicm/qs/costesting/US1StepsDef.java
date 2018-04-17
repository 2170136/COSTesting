package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class US1StepsDef {
    private  PhantomJSDriver driver;
    private String guid = "";

    @Given("^I access the landing page of COS$")
    public void iAccessTheLandingPageOfCOS() throws Throwable {
        driver.get("http://35.187.16.192/COSProject/index.php");
        assertEquals("Contacts Orchestrator Solution", driver.getTitle());
    }

    @Then("^the title of the page should be \"([^\"]*)\"$")
    public void theTitleOfThePageShouldBe(String title) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains(title));
    }

    @And("^I can see the text \"([^\"]*)\"$")
    public void iCanSeeTheText(String text) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("body")), text));
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver",
                "drivers\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver",
                "drivers\\MicrosoftWebDriver.exe");
        System.setProperty("webdriver.chrome.driver",
                "drivers\\chromedriver.exe");
        System.setProperty("phantomjs.binary.path",
                "drivers\\phantomjs.exe");


        driver = new PhantomJSDriver();
        driver.get("http://35.187.16.192/COSProject/index.php");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }


    @Then("^the field \"([^\"]*)\" should exist$")
    public void theFieldShouldExist(String field) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (field.equals("Name")) {
            assertTrue(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr/td[2]")).getText().matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$"));
        }else if (field.equals("Guid")) {
            assertTrue(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr/td")).getText().length() > 0);
        }else if (field.equals("Actions")) {
            assertTrue(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr/td[3]")).getText().matches("More info"));
        } else {
            fail("Unknown field: " + field);
        }
    }

    @Then("^I click on the button more info$")
    public void iClickOnTheButtonMoreInfo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElement = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr/td[3]/a"));
        guid = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr/td")).getText();
        webElement.click();
        //new WebDriverWait(driver, 2));
    }

    @And("^I can see the profile page$")
    public void iCanSeeTheProfilePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String profile_guid = driver.findElement(By.xpath("//span[@id='guid_value']")).getText();
        assertTrue(profile_guid.equals(guid));
    }
}

