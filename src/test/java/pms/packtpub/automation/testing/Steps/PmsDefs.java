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
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\chromedriver.exe" );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        // Express the Regexp above with the code you wish you had
       // throw new PendingException();
    }

    @When("^I provide valid  username and password$")
    public void I_provide_valid_username_and_password() throws Throwable {
        pms pmsObj = new pms(driver);
        pmsLogin = pmsObj.trylogin("sunny@gmail.com","12345");
        String actualHeading =  pmsLogin.getCurrentPage();
        String expectedHeading ="http://localhost:8080/pms/viewparish.action";
        assertEquals(expectedHeading, actualHeading);
    }

    @Then("^user should be able to login$")
    public void user_should_be_able_to_login() throws Throwable {
       driver.quit();
    }

}
