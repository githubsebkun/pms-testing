package pms.packtpub.automation.testing;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;

/**
 * Created by sindh on 13/03/2017.
 *  * not in use now as below rule is not working with Cucumber
 * @Rule
 * public ScreenShotRule screenShotRule = new ScreenShotRule(driver);
 */
public class ScreenShotRule implements MethodRule {
    private WebDriver driver;
    public ScreenShotRule(WebDriver driver){
        this.driver = driver;
    }
    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object object) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable throwable) {
                    captureScreenshot(frameworkMethod.getName());
                    throw throwable; // rethrow to allow the failure to be reported to JUnit
                }
            }

            public void captureScreenshot(String fileName) {
                try {
                    FileOutputStream out = new FileOutputStream("C:\\MVN\\pms-testing\\target\\surefire-reports\\" + fileName + ".png");
                    out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                    out.close();
                } catch (Exception e) {
                    //If the screenshot fails no need to interrupt the tests
                }
            }
        };
    }
}