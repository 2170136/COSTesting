

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US5StepsDef {
    private WebDriver driver;
    private LinkedList<String> listContacts;

    @Before
    public void setUp() throws Exception {
       // System.setProperty("phantomjs.binary.path", "drivers/phantomjs-linux");
          System.setProperty("phantomjs.binary.path",  "drivers\\phantomjs.exe");

        driver = new PhantomJSDriver();

        //   driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://35.187.16.192:80/COSProject");
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @When("^i click in the next page -5US$")
    public void iClickInTheNextPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement select = (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(By.id("data-table-contacts_next")));

        select.click();

    }


    @Then("^the text users per page should contain \"([^\"]*)\" -5US$")
    public void theTextUsersPerPageShouldBe(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.findElement(By.xpath("//div[@id='data-table-contacts_info']")).getText().contains(arg0));
    }



    @When("^i click in the first page -5US$")
    public void iClickInTheFirstPage() throws Throwable {
        WebElement select = (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='data-table-contacts_first']")));
        select.click();
    }

    @Then("^the button previous must be disabled -5US$")
    public void theButtonPreviousMustBeDisabled() throws Throwable {
       String aux = driver.findElement(By.xpath("//a[@id='data-table-contacts_previous']")).getAttribute("class");
       String[] auxClasses = aux.split(" ");
       assertTrue(auxClasses[2].equals("disabled"));
    }

    @When("^i click in the last page -5US$")
    public void iClickInThePageLast() throws Throwable {
        List<WebElement> element = driver.findElements(By.id("data-table-contacts_paginate"));
        WebElement select = (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='data-table-contacts_paginate']/a[@id='data-table-contacts_last']")));
        select.click();
    }

    @Then("^the text users per page should contain the last users -5US$")
    public void theTextUsersPerPageShouldContainTheLastUsers() throws Throwable {
        String total = driver.findElement(By.xpath("//span[@id='total_contacts']")).getText();
        String aux = "to "+total+ " of "+total+" entries";
        assertTrue(driver.findElement(By.xpath("//div[@id='data-table-contacts_info']")).getText().contains(aux));
    }

    @Then("^the button next must be disabled -5US$")
    public void theButtonNextMustBeDisabled() throws Throwable {
        String aux = driver.findElement(By.xpath("//a[@id='data-table-contacts_next']")).getAttribute("class");
        String[] auxClasses = aux.split(" ");
        assertTrue(auxClasses[2].equals("disabled"));
    }


    @Given("^I am on the Contact List page -5US$")
    public void iAmOnTheContactListPageUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://35.187.16.192/COSProject/index.php");
        //driver.wait();

        int i = driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr")).size();
        listContacts = new LinkedList<String>();
        for(int y = 1; y<i; y++){
            listContacts.add(driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr["+y+"]/td")).getText());
        }

        //listContacts = driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr"));
    }

    @And("^contacts off the page have to be different from the contacts off the first page -5US$")
    public void contactsOffThePageHaveToBeDifferentFromTheContactsOffTheFirstPageUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   List<WebElement> listContactsnew  = driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr"));
        int i = driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr")).size();

        for(int y = 1; y<i; y++){
            if(listContacts.contains(driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr["+y+"]/td[1]")).getText())){
                assertTrue("Contactos são os mesmo da primeira página.", false);
            }
        }
    }
}
