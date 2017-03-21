package pms.packtpub.automation.testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
/**
 * Created by sindh on 20/03/2017.
 */
public class pms {private WebDriver driver;
    private String baseUrl;

    public pms(WebDriver driver) {
        this.driver = driver;
        //driver.manage().window().maximize();
        baseUrl = "http://localhost:8080/pms";
        driver.get(baseUrl + "/");
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginForm1")));
        if (!driver.getTitle().equals("PMS-Parish Management System")) {
           // throw new WrongPageException("Incorrect page for PMS login Check your page");
        }
    }
    public CheckLoginPage trylogin(String uid, String pwd) throws Exception, WrongPageException {
        driver.findElement(By.cssSelector("#loginForm1 > #email")).clear();
        driver.findElement(By.cssSelector("#loginForm1 > #email")).sendKeys(uid);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(pwd);
        Thread.sleep(1000);
//        driver.findElement(By.id("password")).clear();
//        driver.findElement(By.id("password")).sendKeys(cell.getStringCellValue());
//        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input.btn.btn-login")).click();
        return new CheckLoginPage(driver);

    }
}
