package pms.packtpub.automation.testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Created by sindh on 20/03/2017.
 */
public class CheckLoginPage {
    private WebDriver driver;

    public CheckLoginPage(WebDriver driver) throws WrongPageException {
        this.driver = driver;
        if (!driver.getTitle().equals("PMS")){
            throw new WrongPageException("Incorrect Login ");
        }
    }

    public String getCurrentPage(){
        String actualHeading = driver.getCurrentUrl();
        return actualHeading;
    }
}
