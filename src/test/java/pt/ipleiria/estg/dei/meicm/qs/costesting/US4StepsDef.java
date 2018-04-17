package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class US4StepsDef {
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

       // driver.get("http://35.187.16.192/COSProject/index.php");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Then("^the users per page should be \"([^\"]*)\"$")
    public void theUsersPerPageShouldBe(String results) throws Throwable {
        assertEquals(driver.findElement(By.xpath("//div[@id='data-table_info']")).getText(),results);
    }

    @When("^I Change the users per page to 50$")
    public void iChangeTheUsersPerPage() throws Throwable {
        WebElement select = driver.findElement(By.xpath("//select[@name='data-table_length']"));
        Select dropDown = new Select(select);


        List<WebElement> Options = dropDown.getOptions();
        for(WebElement option:Options){
            if(option.getText().equals("50")) {
                option.click(); //select option here;
            }
        }


    }

}
