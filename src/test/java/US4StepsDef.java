

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
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
//        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
//        System.setProperty("webdriver.edge.driver",
//                "drivers\\MicrosoftWebDriver.exe");
        System.setProperty("webdriver.chrome.driver",
                "/usr/local/bin/chromedriver");
        System.setProperty("phantomjs.binary.path",
                "/opt/bitnami/apps/jenkins/jenkins_home/workspace/Run automated tests/drivers/phantomjs-linux");
        System.setProperty("webdriver.gecko.driver",
                "/usr/local/bin/geckodriver");

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

        driver = new ChromeDriver();
        //driver = new ChromeDriver();
        driver.get("http://35.187.16.192/COSProject/index.php");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }




    @When("^I Change the users per page to (\\d+)$")
    public void iChangeTheUsersPerPageTo(int arg0) throws Throwable {
        ////div[@id='data-table_length']/label/select
        WebElement select = driver.findElement(By.xpath(".//div[@id='data-table-contacts_length']/label/select"));
        Select dropDown = new Select(select);

        List<WebElement> Options = dropDown.getOptions();
        for(WebElement option:Options){
            if(option.getText().equals(String.valueOf(arg0))) {
                option.click(); //select option here;
            }
        }
    }

    @Given("^I am on the Contact list page$")
    public void iAmOnTheContactListPage() throws Throwable {
        driver.get("http://35.187.16.192/COSProject/index.php");
    }

    @Then("^the list contain \"([^\"]*)\" contacts$")
    public void theListContainContacts(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       List<WebElement> elementList = driver.findElements(By.xpath(".//table[@id='data-table-contacts']/tbody/tr"));
       assertTrue(elementList.size()==Integer.parseInt(arg0));
    }
}
