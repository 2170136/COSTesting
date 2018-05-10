

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
                System.getProperty("user.dir")+ "/drivers/phantomjs");


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
        WebElement select = (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='data-table-contacts_next']")));

        select.click();

    }


    @Then("^the text users per page should contain \"([^\"]*)\"$")
    public void theTextUsersPerPageShouldBe(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.findElement(By.xpath(".//div[@id='data-table_info']")).getText().contains(arg0));
    }



    @When("^i click in the first page$")
    public void iClickInTheFirstPage() throws Throwable {
        WebElement select = (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[@id='data-table-contacts_first']")));
        select.click();
    }

    @Then("^the button previous must be disabled$")
    public void theButtonPreviousMustBeDisabled() throws Throwable {
       String aux = driver.findElement(By.xpath(".//a[@id='data-table-contacts_previous']")).getAttribute("class");
       String[] auxClasses = aux.split(" ");
       assertTrue(auxClasses[2].equals("disabled"));
    }

    @When("^i click in the last page$")
    public void iClickInThePageLast() throws Throwable {
        List<WebElement> element = driver.findElements(By.id("data-table-contacts_paginate"));
        WebElement select = (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='data-table-contacts_paginate']/a[@id='data-table-contacts_last']")));
        select.click();
    }

    @Then("^the text users per page should contain the last users$")
    public void theTextUsersPerPageShouldContainTheLastUsers() throws Throwable {
        String total = driver.findElement(By.xpath(".//span[@id='total_contacts']")).getText();
        String aux = "to "+total+ " of "+total+" entries";
        assertTrue(driver.findElement(By.xpath(".//div[@id='data-table-contacts_info']")).getText().contains(aux));
    }

    @Then("^the button next must be disabled$")
    public void theButtonNextMustBeDisabled() throws Throwable {
        String aux = driver.findElement(By.xpath(".//a[@id='data-table-contacts_next']")).getAttribute("class");
        String[] auxClasses = aux.split(" ");
        assertTrue(auxClasses[2].equals("disabled"));
    }


}
