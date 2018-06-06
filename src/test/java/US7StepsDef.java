import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US7StepsDef {

    private WebDriver driver;
    private int totalOfNotDuplicates = 0;
    private int totalContacts = 0;

    @Before
    public void setUp() throws Exception {
        System.setProperty("phantomjs.binary.path", "drivers/phantomjs-linux");
        //System.setProperty("phantomjs.binary.path", "drivers\\phantomjs.exe");

        this.driver = new PhantomJSDriver();
        this.driver.get("http://35.187.16.192:80/COSProject/not_duplicate.php");
        this.totalOfNotDuplicates = 0;
    }

    @After
    public void tearDown() throws Exception {
        this.driver.quit();
    }

    @Then("^the total contacts on duplicate page is equal or lower than the total on the landing page -7US$")
    public void theTotalContactsOnDuplicatePageIsEqualOrLowerThanTheTotalOnTheLandingPageUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("the total of not duplicated contacts is wrong!", this.totalContacts >= this.totalOfNotDuplicates);
    }

    @Given("^I am on the \"([^\"]*)\" page -7US$")
    public void iAmOnThePageUS(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String pageTitle = this.driver.getTitle();
        Assert.assertTrue("Não está na página correta!", pageTitle.equals(arg0));
    }

    @And("^i know the total of contacts in landing page -7US$")
    public void iKnowTheTotalOfContactsInLandingPageUS() throws Throwable {
        this.totalOfNotDuplicates = Integer.parseInt(this.driver.findElement(By.xpath("//span[@id='total_contacts']")).getText());
        this.driver.get("http://35.187.16.192:80/COSProject/index.php");
        WebDriverWait wait = new WebDriverWait(this.driver, 3L);
        wait.until(ExpectedConditions.urlContains("index"));
        String pageTitle = this.driver.getTitle();
        this.totalContacts = Integer.parseInt(this.driver.findElement(By.xpath("//span[@id='total_contacts']")).getText());
    }

}
