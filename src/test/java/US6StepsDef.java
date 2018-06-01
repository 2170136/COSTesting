import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class US6StepsDef {
    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        System.setProperty("phantomjs.binary.path", "drivers/phantomjs-linux");
        //  System.setProperty("phantomjs.binary.path",  "drivers\\phantomjs.exe");

        driver = new PhantomJSDriver();
        driver.get("http://35.187.16.192:80/COSProject/duplicate.php");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }

    @Given("^I am on the duplicate page and there is some group of duplicates -6US$")
    public void Iamontheduplicatepageandthereissomegroupofduplicates() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://35.187.16.192/COSProject/duplicate.php");
    }

    @Then("^For each group of possible duplicates, you must have at least one similar field in all possible duplicates -6US$")
    public void Foreachgroupofpossibleduplicatesyoumusthaveatleastonesimilarfieldinallpossibleduplicates() throws Throwable {
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        String oldColor = "";
        List<String> names  = new LinkedList<String>();
        List<String> emails  = new LinkedList<String>();
        List<String> phones  = new LinkedList<String>();
        Boolean state = true;

        for(int y = 1; y<=duplicatedList.size(); y++){
            WebElement elementName = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[1]"));
            WebElement elementSurname = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[2]"));
            WebElement elementEmail = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[3]"));
            WebElement elementPhone = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[4]"));
            String color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");

            if(oldColor.equals(color) || oldColor.equals(""))
            {
                names.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[1]")).getText()+driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[2]")).getText());
                emails.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[3]")).getText());
                phones.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[4]")).getText());
                oldColor = color;
            }
            else
            {
                if(!(compareElementsList(names) || compareElementsList(emails) || compareElementsList(phones))){
                    state = false;
                }
                if(!state){
                    assertTrue("Contactos apresentados não são possiveis duplicados", state);
                }
                names  = new LinkedList<String>();
                emails  = new LinkedList<String>();
                phones  = new LinkedList<String>();
                names.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[1]")).getText()+driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[2]")).getText());
                emails.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[3]")).getText());
                phones.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[4]")).getText());
                oldColor = color;
            }

        }
        assertTrue("Contactos apresentados não são possiveis duplicados", state);
    }

    @Then("^every group of duplicate should contain at least 2 contacts -6US$")
    public void everygroupofduplicateshouldcontainatleast2contacts() throws Throwable {
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        String oldColor = "";
        int nrContactsInGroup = 0;
        Boolean state = true;

        for(int y = 1; y<=duplicatedList.size(); y++){
            String color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color))
            {
                nrContactsInGroup++;
             }
            else
            {
                if(nrContactsInGroup<= 1 && y > 1){
                    state = false;
                    assertTrue("Número de possiveis duplicados por grupo tem de ser mais que um.", state);
                }
                nrContactsInGroup = 1;
                oldColor = color;
            }
        }
        assertTrue("Número de possiveis duplicados por grupo é invalido.", state);
    }

    private boolean compareElementsList(List<String> list) {
        if(list.size() <2){
            return false;
        }

        for (int i = 0; i < list.size() - 1; i++)
            for (int k = i + 1; k < list.size(); k++)
                if (!list.get(i).equals(list.get(k))) {
                    return false;
                }

        return  true;
    }

    @Then("^the Total of possible duplicated contacts must be consistent to the total groups in list -6US$")
    public void theTotalOfPossibleDuplicatedContactsMustBeConsistentToTheTotalGroupsInListUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String nrTotalGroupsLabel = driver.findElement(By.xpath("//span[@id='total_contacts']")).getText();
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        String oldColor = "";
        int nrGroups = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            String color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(!oldColor.equals(color))
            {
                nrGroups++;
                oldColor = color;
            }
        }
        assertTrue("Número de grupos não está correto.", nrTotalGroupsLabel.equals(Integer.toString(nrGroups)));
    }
}
