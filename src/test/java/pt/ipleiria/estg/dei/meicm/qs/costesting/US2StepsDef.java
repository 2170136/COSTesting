package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class US2StepsDef {
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
    }
    @Given("^I am on the Contact List page$")
    public void iAmOnTheContactListPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://35.187.16.192/COSProject/index.php");
    }

    @When("^i click in the first more info button$")
    public void iClickInTheFirstMoreInfoButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement element = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr/td[3]/a"));

        element.click();

    }



    @Then("^the field \"([^\"]*)\" should be in the right format$")
    public void theFieldShouldBeInTheRightFormat(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(arg0.equals("email"))
        {
            WebElement element = driver.findElement(By.xpath("//span[@id='email_value']"));
            String email = element.getText();
            Assert.assertTrue(email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
        }
        else if(arg0.equals("phone"))
        {
            WebElement element = driver.findElement(By.xpath("//span[@id='phone_value']"));
            String phone = element.getText();
            //phone = "97";
            Assert.assertTrue(phone.matches("^[0-9]{9}$"));
        }
    }
}
