
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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class US1StepsDef {

    private WebDriver driver;
    private String guid = "";
    private String profile_href ="";

    @Given("^I access the landing page of COS -1US$")
    public void iAccessTheLandingPageOfCOS() throws Throwable {
        driver.get("http://35.187.16.192/COSProject");
        assertEquals("Contacts Orchestrator Solution", driver.getTitle());
    }

    @Then("^the title of the page should be \"([^\"]*)\" -1US$")
    public void theTitleOfThePageShouldBe(String title) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains(title));
    }

    @And("^I can see the text \"([^\"]*)\" -1US$")
    public void iCanSeeTheText(String text) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("body")), text));
    }


    @Before
    public void setUp() throws Exception {

        System.setProperty("phantomjs.binary.path", "drivers/phantomjs-linux");
    //  System.setProperty("phantomjs.binary.path",  "drivers\\phantomjs.exe");


        driver = new PhantomJSDriver();
        driver.get("http://35.187.16.192:80/COSProject");
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();

    }


    @Then("^the field \"([^\"]*)\" should exists -1US$")
    public void theFieldShouldExists(String field) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (field.equals("Name")) {
            assertTrue(driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td[2]")).getText().matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$"));
        }else if (field.equals("Guid")) {
            assertTrue(driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td")).getText().length() > 0);
        }else if (field.equals("Actions")) {
            assertTrue(driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td[4]")).getText().matches("More info"));
        }
        else if (field.equals("Source")) {
            assertTrue(driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td[3]")).getText().length() > 0);
        }
        else {
            fail("Unknown field: " + field);
        }
    }

    @Then("^I click on the button more info -1US$")
    public void iClickOnTheButtonMoreInfo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElement = driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td[4]/a"));
        guid = driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td")).getText();
        profile_href = webElement.getAttribute("href");
        webElement.click();
        //new WebDriverWait(driver, 2));
    }

    @And("^I can see the profile page -1US$")
    public void iCanSeeTheProfilePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String profile_guid = driver.findElement(By.xpath("//span[@id='guid_value']")).getText();
        assertTrue(profile_guid.equals(guid));
    }

    @And("^the \"([^\"]*)\" message should be displayed -1US$")
    public void theMessageShouldBeDisplayed(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("Error in API RESP", driver.findElement(By.xpath("//p")).getText(),"Error in access Rest Contacts API");
    }

    @Given("^I access the landing page of contacts -1US$")
    public void iAccessTheLandingPageOfContacts() throws Throwable {
        driver.get("http://35.187.16.192/COSProject/index.php");
        assertEquals("Contacts not available", driver.getTitle());
    }

    @And("^The field \"([^\"]*)\" should be valid -1US$")
    public void theFieldShouldBeValid(String arg0) throws Throwable {
        String[] split = profile_href.split("=");
        assertEquals((split.length>0?split[1]:""), guid);
    }

    @Then("^The fields \"([^\"]*)\" should be valid -1US$")
    public void theFieldsShouldBeValid(String arg0) throws Throwable {
        WebElement element = driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td"));
        String Guid = element.getText();
        //Guid = "021a1dc3-5b75-4868-bb03-333170ce9ac";

        Assert.assertTrue(Guid.matches("^[a-zA-Z0-9]{8}+-+[a-zA-Z0-9]{4}+-+[a-zA-Z0-9]{4}+-+[a-zA-Z0-9]{4}+-+[a-zA-Z0-9]{12}$"));
    }

    @Given("^I am on the Contact List page -1US$")
    public void iAmOnTheContactListPageUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://35.187.16.192/COSProject/index.php");

    }

    @When("^I switch off the Facebook Button -1US$")
    public void iClickInTheFacebookButtonUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElement = driver.findElement(By.xpath("//label/span"));
        webElement.click();
    }

    @Then("^on list of users should only appears users that are not from Facebook Source -1US$")
    public void theListShouldNotContainFacebookContactsUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> webElementList =  driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td[3]"));
        for (WebElement element: webElementList)
        {
            if(element.getText().toUpperCase().equals("FACEBOOK")){
                Assert.assertTrue("Teste falhou! Facebook está desligado mas aparecem contactos do Facebook", false);
                return;
            }
        }
        assertTrue(true);
    }

    @Given("^I am on the landing page and both buttons are on -1US$")
    public void iAmOnTheLandingPageAndBothButtonsAreOnUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElementFacebook = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]"));
        WebElement webElementLinkedin = driver.findElement(By.xpath("//a[contains(text(),'Linkedin')]"));
        if(webElementFacebook.getAttribute("class").contains("disabled"))
        {
            WebElement webElementFacebookClick = driver.findElement(By.xpath("//label/span"));
            webElementFacebookClick.click();
        }
        if(webElementLinkedin.getAttribute("class").contains("disabled"))
        {
            WebElement webElementLinkedinClick = driver.findElement(By.xpath("//label[2]/span"));
            webElementLinkedinClick.click();
        }
    }

    @Then("^Button Facebook and Button LinkedIn should be switched on -1US$")
    public void buttonFacebookAndButtonLinkedInShouldBeSwitchedOnUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        WebElement webElmFacebook = driver.findElement(By.id("checkbox_facebook"));
        Assert.assertTrue("Facebook not ON", webElmFacebook.isSelected());
        WebElement webElmLinkedin = driver.findElement(By.id("checkbox_linkedin"));
        Assert.assertTrue("Linkedin not ON", webElmLinkedin.isSelected());

        //  WebElement webElementFacebook = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]"));
        //   WebElement webElementLinkedin = driver.findElement(By.xpath("//a[contains(text(),'Linkedin')]"));
        //   Assert.assertTrue("Facebook not ON", !webElementFacebook.getAttribute("class").contains("disabled"));
        //   Assert.assertTrue("Linkedin not ON", !webElementLinkedin.getAttribute("class").contains("disabled"));
    }

    @When("^I Click on Facebook Label -1US$")
    public void iClickOnFacebookLabelUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElementFacebook = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]"));
        webElementFacebook.click();
    }

    @Then("^on list of users should only appears users from Facebook Source -1US$")
    public void theListOfUsersShouldOnlyAppearsUsersFromFacebookSourceUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> webElementList =  driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td[3]"));
        for (WebElement element: webElementList)
        {
            if(!element.getText().toUpperCase().equals("FACEBOOK")){
                Assert.assertTrue("Teste falhou! Apareceu contactos com a Source diferente do Facebook", false);
                return;
            }
        }
        assertTrue(true);
    }

    @And("^LinkedIn stays ON -1US$")
    public void linkedinStaysONUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElementLinkedin = driver.findElement(By.xpath("//a[contains(text(),'Linkedin')]"));
        Assert.assertTrue("Teste falhou! Linkedin está Offline", !webElementLinkedin.getAttribute("class").contains("disabled"));
    }

    @Then("^the Facebook button should be off -1US$")
    public void theFacebookButtonShouldBeOffUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElementFacebook = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]"));
        Assert.assertTrue("Teste falhou! Facebook está Online",webElementFacebook.getAttribute("class").contains("disabled"));
    }

    @And("^i refresh the page -1US$")
    public void iRefreshThePageUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      driver.navigate().refresh();
    }

    @When("^I switch off the Linkedin Button -1US$")
    public void iSwitchOffTheLinkedinButtonUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElement = driver.findElement(By.xpath("//label[2]/span"));
        webElement.click();
    }

    @When("^I Click on Linkedin Label -1US$")
    public void iClickOnLinkedinLabelUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElementFacebook = driver.findElement(By.xpath("//a[contains(text(),'Linkedin')]"));
        webElementFacebook.click();
    }

    @Then("^on list of users should only appears users that are not from Linkedin Source -1US$")
    public void onListOfUsersShouldOnlyAppearsUsersThatAreNotFromLinkedinSourceUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> webElementList =  driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td[3]"));
        for (WebElement element: webElementList)
        {
            if(element.getText().toUpperCase().equals("LINKEDIN")){
                Assert.assertTrue("Teste falhou! LinkedIn está desligado mas aparecem contactos do Facebook", false);
                return;
            }
        }
        assertTrue(true);
    }

    @Then("^on list of users should only appears users from Linkedin Source -1US$")
    public void onListOfUsersShouldOnlyAppearsUsersFromLinkedinSourceUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> webElementList =  driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td[3]"));
        for (WebElement element: webElementList)
        {
            if(!element.getText().toUpperCase().equals("LINKEDIN")){
                Assert.assertTrue("Teste falhou! Apareceu contactos com a Source diferente do LinkedIn", false);
                return;
            }
        }
        assertTrue(true);
    }

    @And("^Facebook stays ON -1US$")
    public void facebookStaysONUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElementLinkedin = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]"));
        Assert.assertTrue("Teste falhou! Facebook está Offline", !webElementLinkedin.getAttribute("class").contains("disabled"));

    }

    @Then("^the Linkedin button should be off -1US$")
    public void theLinkedinButtonShouldBeOffUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElementFacebook = driver.findElement(By.xpath("//a[contains(text(),'Linkedin')]"));
        Assert.assertTrue("Teste falhou! Linkedin está Online",webElementFacebook.getAttribute("class").contains("disabled"));

    }

    @When("^I Click on both Facebook and Linkedin Buttons -1US$")
    public void iClickOnBothFacebookAndLinkedinButtonsUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElement = driver.findElement(By.xpath("//label[2]/span"));
        webElement.click();
        webElement = driver.findElement(By.xpath("//label/span"));
        webElement.click();
    }

    @Then("^the list should not contains contacts -1US$")
    public void theListShouldNotContainsContactsUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> webElementList =  driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr/td"));
        Assert.assertTrue("Teste falhou! Existem contactos na lista",webElementList.size()==1);

    }


    @Then("^all contacts must have the source column filled in and and if they are valid -1US$")
    public void allContactsMustHaveTheColumnFilledInAndEqualAUS() throws Throwable {
        int i = driver.findElements(By.xpath("//table[@id='data-table-contacts']/tbody/tr")).size();
        String source ="";

        for(int y = 1; y<i; y++){
            source = driver.findElement(By.xpath("//table[@id='data-table-contacts']/tbody/tr["+y+"]/td[3]")).getText();
            assertTrue(source.equals("Facebook") || source.equals("LinkedIn"));
        }

    }

    @When("^I switch the \"([^\"]*)\" button -1US$")
    public void iSwitchTheButtonUS(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement webElement = driver.findElement(By.xpath(arg0));
        webElement.click();
    }


    @Then("^the \"([^\"]*)\" label change state according to the \"([^\"]*)\" state -1US$")
    public void theLabelChangeStateAccordingToTheStateUS(String arg0, String arg1) throws Throwable {

        WebElement webElmLabel = driver.findElement(By.id(arg0)); // facebook_filter or linkedin_filter
        WebElement webElmSwitchInput = driver.findElement(By.id(arg1)); // input checkbox

        if(webElmSwitchInput.isSelected()){
            Assert.assertTrue("Teste falhou! A label não está de acordo com o switch!",webElmLabel.getAttribute("class").contains("enable"));
        }else{
            Assert.assertTrue("Teste falhou! A label não está de acordo com o switch!",webElmLabel.getAttribute("class").contains("disable"));
        }

    }
}

