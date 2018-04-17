package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class US5StepsDef {
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


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    @When("^i click in the next page$")
    public void iClickInTheNextPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement select = (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='data-table_paginate']/a[2]")));

        select.click();

    }


    @Then("^the text users per page should be \"([^\"]*)\"$")
    public void theTextUsersPerPageShouldBe(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(driver.findElement(By.xpath("//div[@id='data-table_info']")).getText(),arg0);
    }

    @When("^i click in the page (\\d+)$")
    public void iClickInThePage(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement select = (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='data-table_paginate']/span/a[2]")));

        select.click();
    }
}
