
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import net.sourceforge.htmlunit.cyberneko.HTMLElements;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeBinary;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class US1StepsDef {

    private WebDriver driver;
    private String guid = "";
    private String profile_href ="";

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
                "/usr/local/bin/geckodriver");
//        System.setProperty("webdriver.edge.driver",
//                "drivers\\MicrosoftWebDriver.exe");
        System.setProperty("webdriver.chrome.driver",
                "/usr/local/bin/chromedriver");
        System.setProperty("phantomjs.binary.path",
                "/opt/bitnami/apps/jenkins/jenkins_home/workspace/Run automated tests/drivers/phantomjs-linux");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/local/bin/chromedriver");

        //driver = new ChromeDriver();
//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File("/usr/local/bin/chromedriver"))
//                .usingAnyFreePort()
//                .build();
//        try {
//            service.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());

        driver = new ChromeDriver(options);
       // String phantomjsExeutableFilePath = "usr\\drivers\\phantomjs";
        //System.setProperty("phantomjs.binary.path", phantomjsExeutableFilePath);
        //driver = new ChromeDriver();
        driver.get("http://35.187.16.192/COSProject/index.php");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    @Then("^the field \"([^\"]*)\" should exist$")
    public void theFieldShouldExist(String field) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (field.equals("Name")) {
            assertTrue(driver.findElement(By.xpath(".//table[@id='data-table-contacts']/tbody/tr/td[2]")).getText().matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$"));
        }else if (field.equals("Guid")) {
            assertTrue(driver.findElement(By.xpath(".//table[@id='data-table-contacts']/tbody/tr/td")).getText().length() > 0);
        }else if (field.equals("Actions")) {
            assertTrue(driver.findElement(By.xpath(".//table[@id='data-table-contacts']/tbody/tr/td[4]")).getText().matches("More info"));
        } else {
            fail("Unknown field: " + field);
        }
    }

    @Then("^I click on the button more info$")
    public void iClickOnTheButtonMoreInfo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElement = driver.findElement(By.xpath(".//table[@id='data-table-contacts']/tbody/tr/td[4]/a"));
        guid = driver.findElement(By.xpath(".//table[@id='data-table-contacts']/tbody/tr/td")).getText();
        profile_href = webElement.getAttribute("href");
        webElement.click();
        //new WebDriverWait(driver, 2));
    }

    @And("^I can see the profile page$")
    public void iCanSeeTheProfilePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String profile_guid = driver.findElement(By.xpath(".//span[@id='guid_value']")).getText();
        assertTrue(profile_guid.equals(guid));
    }

    @And("^the \"([^\"]*)\" message should be displayed$")
    public void theMessageShouldBeDisplayed(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("Error in API RESP", driver.findElement(By.xpath("//p")).getText(),"Error in access Rest Contacts API");
    }

    @Given("^I access the landing page of contacts$")
    public void iAccessTheLandingPageOfContacts() throws Throwable {
        driver.get("http://35.187.16.192/COSProject/index.php");
        assertEquals("Contacts not available", driver.getTitle());
    }

    @And("^The field \"([^\"]*)\" should be valid$")
    public void theFieldShouldBeValid(String arg0) throws Throwable {
        String[] split = profile_href.split("=");
        assertEquals((split.length>0?split[1]:""), guid);
    }

    @Then("^The fields \"([^\"]*)\" should be valid$")
    public void theFieldsShouldBeValid(String arg0) throws Throwable {
        WebElement element = driver.findElement(By.xpath(".//table[@id='data-table-contacts']/tbody/tr/td"));
        String Guid = element.getText();
        //Guid = "021a1dc3-5b75-4868-bb03-333170ce9ac";

        Assert.assertTrue(Guid.matches("^[a-zA-Z0-9]{8}+-+[a-zA-Z0-9]{4}+-+[a-zA-Z0-9]{4}+-+[a-zA-Z0-9]{4}+-+[a-zA-Z0-9]{12}$"));
    }
}

