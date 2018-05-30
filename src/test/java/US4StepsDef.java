

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US4StepsDef {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("phantomjs.binary.path",
                "drivers/phantomjs-linux");
   //     System.setProperty("phantomjs.binary.path",
     //           "drivers\\phantomjs.exe");




        driver = new PhantomJSDriver();
        //driver = new ChromeDriver();
     //   driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://35.187.16.192:80/COSProject");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }




    @When("^I Change the users per page to (\\d+) -4US$")
    public void iChangeTheUsersPerPageTo(int arg0) throws Throwable {
        ////div[@id='data-table_length']/label/select
        WebElement select = driver.findElement(By.xpath("//div[@id='data-table-contacts_length']/label/select"));
        Select dropDown = new Select(select);

        List<WebElement> Options = dropDown.getOptions();
        for(WebElement option:Options){
            if(option.getText().equals(String.valueOf(arg0))) {
                option.click(); //select option here;
            }
        }
    }

    @Given("^I am on the Contact list page -4US$")
    public void iAmOnTheContactListPage() throws Throwable {
        driver.get("http://35.187.16.192/COSProject/index.php");
    }

    @Then("^the list contain \"([^\"]*)\" contacts -4US$")
    public void theListContainContacts(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       List<WebElement> elementList = driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr"));
       assertTrue(elementList.size()==Integer.parseInt(arg0));
    }
}
