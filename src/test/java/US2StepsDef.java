

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class US2StepsDef {
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

        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Given("^I am on the Contact List page$")
    public void iAmOnTheContactListPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://35.187.16.192/COSProject/index.php");
    }

    @When("^i click in the first more info button$")
    public void iClickInTheFirstMoreInfoButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement element = driver.findElement(By.xpath(".//table[@id='data-table-contacts']/tbody/tr/td[4]/a"));

        element.click();

    }



    @Then("^the field \"([^\"]*)\" should be in the right format$")
    public void theFieldShouldBeInTheRightFormat(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(arg0.equals("email"))
        {
            WebElement element = driver.findElement(By.xpath(".//span[@id='email_value']"));
            String email = element.getText();
            Assert.assertTrue(email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
        }
        else if(arg0.equals("phone"))
        {
            WebElement element = driver.findElement(By.xpath(".//span[@id='phone_value']"));
            String phone = element.getText();
            //phone = "97";
            Assert.assertTrue(phone.matches("^[0-9]{9}$"));
        }
        else if(arg0.equals("Birthday"))
        {
            WebElement element = driver.findElement(By.xpath(".//span[@id='birthday_value']"));
            String birthday = element.getText();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            try {
                Date date = formatter.parse(birthday);
                Date dateNow = new Date();
                Assert.assertTrue(date.before(dateNow));
            }catch (Exception e)
            {
                Assert.assertTrue(1==2);
            }
        }
        else if(arg0.equals("Guid"))
        {
            WebElement element = driver.findElement(By.xpath(".//span[@id='guid_value']"));
            String Guid = element.getText();
            //Guid = "021a1dc3-5b75-4868-bb03-333170ce9ac";

            Assert.assertTrue(Guid.matches("^[a-zA-Z0-9]{8}+-+[a-zA-Z0-9]{4}+-+[a-zA-Z0-9]{4}+-+[a-zA-Z0-9]{4}+-+[a-zA-Z0-9]{12}$"));
        }
        else if(arg0.equals("photourl"))
        {
            WebElement element = driver.findElement(By.xpath(".//span[@id='photo_url_value']"));
            String photoutl = element.getText();
            //Guid = "021a1dc3-5b75-4868-bb03-333170ce9ac";
            try {
                BufferedImage image = ImageIO.read(new URL(photoutl));
                //BufferedImage image = ImageIO.read(new URL("http://someimage.jpg"));
                if (image != null) {
                    Assert.assertTrue(1==1);
                } else {
                    Assert.assertTrue(2==1);
                }
            } catch(Exception e)
            {
                Assert.assertTrue(2==1);
            }

        }
    }

    @Then("^the field \"([^\"]*)\" should exits$")
    public void theFieldExits(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(arg0.equals("contact_name")){
            WebElement element = driver.findElement(By.xpath(".//h2[@id='contact_name']"));
            String contactName = element.getText();
            Assert.assertTrue(contactName.length()>0);
        }
        else if(arg0.equals("giveName")){
            WebElement element = driver.findElement(By.xpath(".//span[@id='given_name_value']"));
            String giveName = element.getText();
            Assert.assertTrue(giveName.length()>0);
        }
        else if(arg0.equals("surName")){
            WebElement element = driver.findElement(By.xpath(".//span[@id='surname_value']"));
            String surName = element.getText();
            Assert.assertTrue(surName.length()>0);
        }
        else if(arg0.equals("occupation")){
            WebElement element = driver.findElement(By.xpath(".//span[@id='occupation_value']"));
            String occupation = element.getText();
            Assert.assertTrue(occupation.length()>0);
        }
        else if(arg0.equals("streetAddress")){
            WebElement element = driver.findElement(By.xpath(".//span[@id='street_address_value']"));
            String streetAddress = element.getText();
            Assert.assertTrue(streetAddress.length()>0);
        }
        else if(arg0.equals("city")){
            WebElement element = driver.findElement(By.xpath(".//span[@id='city_value']"));
            String city = element.getText();
            Assert.assertTrue(city.length()>0);
        }
        else if(arg0.equals("company")){
            WebElement element = driver.findElement(By.xpath(".//span[@id='company_value']"));
            String company = element.getText();
            Assert.assertTrue(company.length()>0);
        }
    }
}
