import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class US6StepsDef {
    private WebDriver driver;
    private int countListDuplicates;
    private int totalOfDuplicates;
    LinkedList<String> listNames;
    LinkedList<String> listSurNames;
    LinkedList<String> listEmail;
    LinkedList<String> listPhone;
    @Before
    public void setUp() throws Exception {
        System.setProperty("phantomjs.binary.path", "drivers/phantomjs-linux");
       // System.setProperty("phantomjs.binary.path",  "drivers\\phantomjs.exe");

        //System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
       // driver = new ChromeDriver();
        driver = new PhantomJSDriver();
        driver.get("http://35.187.16.192:80/COSProject/duplicate.php");
        countListDuplicates = 0;
        totalOfDuplicates = 0;
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


    @Given("^I am on the duplicate page and the first group of duplicate have every checkbox checked -6US$")
    public void iAmOnTheDuplicatePageAndTheFirstGroupOfDuplicateHaveEveryCheckboxChecked() throws Throwable {
        driver.get("http://35.187.16.192/COSProject/duplicate.php");
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        WebElement column;
        WebElement elCheckbox;
        String color, oldColor = "";

        int i = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            column =  driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[5]"));
            color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color) || oldColor.equals(""))
            {
                elCheckbox = column.findElement(By.xpath("//input[@id="+i+"]"));
                if(!elCheckbox.isSelected()){
                    elCheckbox.click();
                }
                i++;
                oldColor = color;
            }else{
                return;
            }
        }
    }


    @When("^I uncheck checkbox but let one checked of this first group -6US$")
    public void iUncheckCheckboxButLetOneCheckedOfThisFirstGroup() throws Throwable {
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        WebElement column;
        WebElement elCheckbox;
        String color, oldColor = "";

        int i = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            column =  driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[5]"));
            color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color) || oldColor.equals(""))
            {
                elCheckbox = column.findElement(By.xpath("//input[@id="+i+"]"));
                if(i == 0 && elCheckbox.isSelected()){
                    elCheckbox.click();
                }else{
                    if(!elCheckbox.isSelected()){
                        elCheckbox.click();
                    }
                }
                i++;
                oldColor = color;
            }else{
                return;
            }
        }
    }

    @When("^I uncheck every checkbox of this first group -6US$")
    public void iUncheckEveryCheckboxOfThisFirstGroup() throws Throwable {
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        WebElement column;
        WebElement elCheckbox;
        String color, oldColor = "";

        int i = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            column =  driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[5]"));
            color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color) || oldColor.equals(""))
            {
                elCheckbox = column.findElement(By.xpath("//input[@id="+i+"]"));
                if(elCheckbox.isSelected()){
                    elCheckbox.click();
                }
                i++;
                oldColor = color;
            }else{
                return;
            }
        }
    }


    @Then("^The label \"([^\"]*)\" should change to \"([^\"]*)\" -6US$")
    public void theLabelShouldChangeTo(String arg0, String arg1) throws Throwable {
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        String color, oldColor = "";
        int i = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color) || oldColor.equals(""))
            {
                oldColor = color;
            }else{
                if(y > 0){
                    i = y-1;
                }else{
                    Assert.assertTrue("Teste falhou! Link não alterou para a label desejada", false);
                }
                break;
            }
        }


        WebElement column = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + i + "]/td[6]"));
        String label = column.getText();
        Assert.assertTrue("Teste falhou! Link não alterou para a label desejada", label.equals(arg1));
    }

    @Given("^I am on the duplicate page and the first group of duplicate have every checkbox unchecked -6US$")
    public void iAmOnTheDuplicatePageAndTheFirstGroupOfDuplicateHaveEveryCheckboxUnchecked() throws Throwable {
        driver.get("http://35.187.16.192/COSProject/duplicate.php");
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        WebElement column;
        WebElement elCheckbox;
        String color, oldColor = "";

        int i = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            column =  driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[5]"));
            color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color) || oldColor.equals(""))
            {
                elCheckbox = column.findElement(By.xpath("//input[@id="+i+"]"));
                if(elCheckbox.isSelected()){
                    elCheckbox.click();
                }
                i++;
                oldColor = color;
            }else{
                return;
            }
        }
    }

    @When("^I check at least (\\d+) checkbox of this group -6US$")
    public void iCheckAtLeastCheckboxOfThisGroup(int arg0) throws Throwable {
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        WebElement column;
        WebElement elCheckbox;
        String color, oldColor = "";

        int i = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            column =  driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[5]"));
            color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color) || oldColor.equals(""))
            {
                elCheckbox = column.findElement(By.xpath("//input[@id="+i+"]"));
                if(!elCheckbox.isSelected() && i < arg0){
                    elCheckbox.click();
                }
                i++;
                oldColor = color;
            }else{
                return;
            }
        }
    }

    @When("^I uncheck every contacts of this group -6US$")
    public void iUncheckEveryContactsOfThisGroup() throws Throwable {
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        WebElement column;
        WebElement elCheckbox;
        String color, oldColor = "";

        int i = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            column =  driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[5]"));
            color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color) || oldColor.equals(""))
            {
                elCheckbox = column.findElement(By.xpath("//input[@id="+i+"]"));
                if(elCheckbox.isSelected()){
                    elCheckbox.click();
                }
                i++;
                oldColor = color;
            }else{
                return;
            }
        }
    }

    @And("^I click on label Separate -6US$")
    public void iClickOnLabelSeparate() throws Throwable {
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        totalOfDuplicates = Integer.parseInt(driver.findElement(By.xpath("//span[@id='total_contacts']")).getText());
        String color, oldColor = "";
        int i = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color) || oldColor.equals(""))
            {
                oldColor = color;
            }else{
                if(y > 0){
                    i = y-1;
                }else{
                    Assert.assertTrue("Teste falhou! Não é possivél clicar na label desejada", false);
                }
                break;
            }
        }

        countListDuplicates = countListOfGroups();
        WebElement column = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + i + "]/td[6]/button"));
        /*
        String text = column.getText();
        if(!text.equals("Separate")){
            Assert.assertTrue("Teste falhou! Não é possivél clicar na label desejada", false);
        }
        */

        column.click();
    }

    private int countListOfGroups(){
        String oldColor = "";
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        int nrGroups = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            String color1 = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(!oldColor.equals(color1))
            {
                nrGroups++;
                oldColor = color1;
            }
        }
        return nrGroups;
    }

    @Then("^the list of groups on duplicate page should decrease (\\d+) -6US$")
    public void theListOfGroupsOnDuplicatePageShouldDecrease(int arg0) throws Throwable {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().refresh();
        int nrGroups = countListOfGroups();
        boolean status = false;
        if(countListDuplicates == nrGroups+1){
            status = true;
        }
        Assert.assertTrue("Teste falhou! List of duplicate contacts not decrease", status);
    }

    @Then("^the total of contacts duplicated should decrease (\\d+) -6US$")
    public void theTotalOfContactsDuplicatedShouldDecrease(int arg0) throws Throwable {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().refresh();
        String nrTotalGroupsLabel = driver.findElement(By.xpath("//span[@id='total_contacts']")).getText();
        int auxTotal = Integer.parseInt(nrTotalGroupsLabel);

        Assert.assertTrue("Teste falhou! Total of duplicates contacts not decrease", auxTotal+arg0 == totalOfDuplicates);
    }

    @When("^I click on Group button of this first group -6US$")
    public void iClickOnGroupButtonOfThisFirstGroup() throws Throwable {
        List<WebElement> duplicatedList = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
        totalOfDuplicates = Integer.parseInt(driver.findElement(By.xpath("//span[@id='total_contacts']")).getText());
        String color, oldColor = "";
        int i = 0;
        for(int y = 1; y<=duplicatedList.size(); y++){
            color = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]")).getCssValue("background-color");
            if(oldColor.equals(color) || oldColor.equals(""))
            {
                oldColor = color;
            }else{
                if(y > 0){
                    i = y-1;
                }else{
                    Assert.assertTrue("Teste falhou! Não é possivél clicar na label desejada", false);
                }
                break;
            }
        }

        countListDuplicates = countListOfGroups();
        WebElement column = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + i + "]/td[6]/button"));
        listNames = new LinkedList<String>();
        listSurNames = new LinkedList<String>();
        listEmail = new LinkedList<String>();
        listPhone = new LinkedList<String>();
        for(int y = 1; y<=i; y++){
            if(!listNames.contains(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[1]")).getText())){
                listNames.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[1]")).getText());
            }
            if(!listSurNames.contains(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[2]")).getText())){
                listSurNames.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[2]")).getText());
            }
            if(!listEmail.contains(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[3]")).getText())){
                listEmail.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[3]")).getText());
            }
            if(!listPhone.contains(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[4]")).getText())){
                listPhone.add(driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[" + y + "]/td[4]")).getText());
            }
        }
        column.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.urlContains("form_contact"));
    }

    @Then("^page is redirected to a form with title \"([^\"]*)\" -6US$")
    public void pageIsRedirectedToAFormWithTitle(String arg0) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains(arg0));
        assertEquals(arg0, driver.getTitle());
    }

    @Then("^the fields have to be on group page -6US$")
    public void theFieldHasToBeOnGroupPageUS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement element = driver.findElement(By.xpath("//select[@id='givenName']"));
        List<WebElement> list = element.findElements(By.tagName("option"));
        LinkedList<String> listOptions = new LinkedList<String>();
        for(WebElement e: list){
            if(!listNames.contains(e.getText())){
                assertTrue("Given Name não apareceu no formulário de agrupar contactos", false);
            }
            listOptions.add(e.getText());
        }
        for(String e: listNames){
            if(!listOptions.contains(e)){
                assertTrue("Given Name não apareceu no formulário de agrupar contactos", false);
            }
        }

        element = driver.findElement(By.xpath("//select[@id='surname']"));
        list = element.findElements(By.tagName("option"));
        listOptions = new LinkedList<String>();
        for(WebElement e: list){
            if(!listSurNames.contains(e.getText())){
                assertTrue("SurName não apareceu no formulário de agrupar contactos", false);
            }
            listOptions.add(e.getText());
        }
        for(String e: listSurNames){
            if(!listOptions.contains(e)){
                assertTrue("SurName não apareceu no formulário de agrupar contactos", false);
            }
        }

        //element = driver.findElement(By.id("email_0"));
        list = driver.findElements(By.id("email_0"));
        listOptions = new LinkedList<String>();
        for(WebElement e: list){
            if(!listEmail.contains(e.getAttribute("value"))){
                assertTrue("Email não apareceu no formulário de agrupar contactos", false);
            }
            listOptions.add(e.getAttribute("value"));
        }
        for(String e: listEmail){
            if(!listOptions.contains(e)){
                assertTrue("Email não apareceu no formulário de agrupar contactos", false);
            }
        }

        list = driver.findElements(By.id("phone"));
        listOptions = new LinkedList<String>();
        for(WebElement e: list){
            if(!listPhone.contains(e.getAttribute("value"))){
                assertTrue("Phone não apareceu no formulário de agrupar contactos", false);
            }
            listOptions.add(e.getAttribute("value"));
        }
        for(String e: listPhone){
            if(!listOptions.contains(e)){
                assertTrue("Phone não apareceu no formulário de agrupar contactos", false);
            }
        }


    }


    @And("^the form appears -6US$")
    public void theFormAppearsUS() throws Throwable {
        String pageTitle = driver.getTitle();
        Assert.assertTrue("Contacts Form page not found!", pageTitle.equals("Contacts Form"));
    }

    @And("^I click on \"([^\"]*)\" button -6US$")
    public void iClickOnButtonUS(String arg0) throws Throwable {
        WebElement button = driver.findElement(By.id(arg0));
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.urlContains("duplicate"));
    }

    @Then("^i should be redirected to the \"([^\"]*)\" page and the first user should be the same -6US$")
    public void iShouldBeRedirectedToThePageAndTheFirstUserShouldBeTheSameUS(String arg0) throws Throwable {
        String pageTitle = driver.getTitle();
        if(pageTitle.equals(arg0)){
            String name = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[1]/td[1]")).getText();
            String surname = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[1]/td[2]")).getText();
            String email = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[1]/td[3]")).getText();
            String phone =  driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[1]/td[4]")).getText();

            if(! (listNames.contains(name) && listSurNames.contains(surname) && listEmail.contains(email) && listPhone.contains(phone)) ){
                assertTrue("User shouldnt be the same.", false);
            }
        }else{
            Assert.assertTrue("Contacts Duplicate page not found!", false);
        }
    }

    @Then("^i should be redirected to the \"([^\"]*)\" page and the first user shouldnt be the same -6US$")
    public void iShouldBeRedirectedToThePageAndTheFirstUserShouldntBeTheSameUS(String arg0) throws Throwable {
        String pageTitle = driver.getTitle();
        if(pageTitle.equals(arg0)){
            String name = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[1]/td[1]")).getText();
            String surname = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[1]/td[2]")).getText();
            String email = driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[1]/td[3]")).getText();
            String phone =  driver.findElement(By.xpath("//table[@id='data-table']/tbody/tr[1]/td[4]")).getText();

            if((listNames.contains(name) && listSurNames.contains(surname) && listEmail.contains(email) && listPhone.contains(phone)) ){
                assertTrue("User should be the same.", false);
            }
        }else{
            Assert.assertTrue("Contacts Duplicate page not found!", false);
        }
    }
}
