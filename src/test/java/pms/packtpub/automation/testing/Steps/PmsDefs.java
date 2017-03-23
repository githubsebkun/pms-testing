package pms.packtpub.automation.testing.Steps;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pms.packtpub.automation.testing.CheckLoginPage;
import pms.packtpub.automation.testing.pms;


import static org.junit.Assert.assertEquals;
/**
 * Created by sindh on 20/03/2017.
 */
public class PmsDefs {
    private WebDriver driver;
    private pms pmsObj;
    private CheckLoginPage pmsLogin;

    @Given("^Open Chrome\\(browser\\) and start application$")
    public void Open_Chrome_browser_and_start_application() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        // Express the Regexp above with the code you wish you had
        // throw new PendingException();
        //TODO: if you are running sauselabs use the three line scripts below
        //make sure sauselab is up by creating tunnels.  details are in notepad file in D:\study
        //make sure URL to login is added properly in class pms
       /* URL url = new URL("http://sibkun:188aa5e3-9799-4c1a-8ff5-f79f87637d2f@ondemand.saucelabs.com:80/wd/hub");
        Capabilities capabilities = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(url, capabilities);*/

    }


    @When("^I provide valid uname \"([^\"]*)\" and valid pwd \"([^\"]*)\"$")
    public void I_provide_valid_uname_and_valid_pwd(String arg1, String arg2) throws Throwable {   // Express the Regexp above with the code you wish you had
       pms pmsObj = new pms(driver);
       pmsLogin = pmsObj.trylogin(arg1, arg2);

   }
    @Then("^user should be able to login$")
    public void user_should_be_able_to_login() throws Throwable {
        String actualHeading = pmsLogin.getCurrentPage();
        String expectedHeading = "http://localhost:8080/pms/viewparish.action";
        assertEquals(expectedHeading, actualHeading);
    }

    @Then("^user should be able to quit and close$")
    public void user_should_be_able_to_quit_and_close() throws Throwable {
        driver.quit();

    }
}