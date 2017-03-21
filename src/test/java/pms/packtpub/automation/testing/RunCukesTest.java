package pms.packtpub.automation.testing;


import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by sindh on 18/03/2017.
 */
@RunWith(Cucumber.class)
//@Cucumber.options(features="src\\test\\resources", glue={"src\\test\\java\\pms\\packtpub\\automation\\testing\\Steps"}) //did not work
//printing reportsbin different formats
@Cucumber.Options(format = {
        "junit:target/cucumber-junit.xml",
        "usage:target/cucumber-json-usage.json",
        "pretty:target/cucumber-pretty.txt",
        "html:target/cucumber-htmlreport",
        "json-pretty:target/cucumber-report.json"})
//@Cucumber.Options(format = {"pretty", "html:target/cucumber-htmlreport","json-pretty:target/cucumber-report.json"})
public class RunCukesTest {
}

