import io.cucumber.testng.*;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features"
        ,glue={"Stepdefs"}
        ,plugin = {"pretty:target/cucumber-reports/cucumber-pretty.txt",
        "html:target/cucumber-reports/raw-cucumber-html-report.html",
        "json:target/report.json"}
        ,monochrome = true)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}