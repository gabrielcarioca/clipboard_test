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
    private static TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

    @Test(suiteName = "Suite", description = "Runs Cucumber Parallel Scenarios", dataProvider = "parallelScenarios")
    public void runParallelScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider(parallel = true)
    public Object[][] parallelScenarios() {
        if (testNGCucumberRunner == null) {
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }
        return testNGCucumberRunner.provideScenarios();
    }
}