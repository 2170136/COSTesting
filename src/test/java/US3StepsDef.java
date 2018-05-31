

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class US3StepsDef {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("phantomjs.binary.path",
                "drivers/phantomjs-linux");
      //  System.setProperty("phantomjs.binary.path",
        //        "drivers\\phantomjs.exe");

        driver = new PhantomJSDriver();
        //driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://35.187.16.192:80/COSProject");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    @When("^i type \"([^\"]*)\" on the input box -3US$")
    public void iTypeOnTheInputBox(String name) throws Throwable {
        //WebElement searchbox = (new WebDriverWait(driver, 10))
          //      .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='data-table-contacts_filter']/label/input")));
        Thread.sleep(2000);
        WebElement searchbox = driver.findElement(By.xpath("//input[@type='search']"));

        searchbox.sendKeys(name);
    }

    @Then("^the result names should contains \"([^\"]*)\" -3US$")
    public void theResultShould(String aux) throws Throwable {

        int i = driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr")).size();

        for(int y = 1; y<i; y++){
            assertTrue((driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr["+y+"]/td[2]")).getText()).contains(aux));
        }


    }


    @Then("^the result should be \"([^\"]*)\" error message -3US$")
    public void theResultShouldBe(String results) throws Throwable {


        //div[@id='data-table_paginate']/span/a[5]
        assertEquals(driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td")).getText(),results);
    }


    @Given("^I am on the Contact List page -3US$")
    public void iAmOnTheContactListPageUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://35.187.16.192:80/COSProject/index.php");
    }

    @Then("^the result \"([^\"]*)\" should contains \"([^\"]*)\" -3US$")
    public void theResultShouldContainsUS(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int indexCollumn = 0;
        if(arg0.toUpperCase().equals("NAME"))
            indexCollumn = 2;
        else if(arg0.toUpperCase().equals("GUID"))
            indexCollumn = 1;
        else if(arg0.toUpperCase().equals("SOURCE"))
            indexCollumn = 3;

        int i = driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr")).size();

        for(int y = 1; y<i; y++){
            assertTrue((driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr["+y+"]/td["+indexCollumn+"]")).getText()).contains(arg1));
        }

    }
}
