package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class US5StepsDef {
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

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
