package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = {"stepDefinitions"},
        tags = "@activity5",
        publish = true,
        plugin = {"pretty"},
        //plugin = {"json: test-reports/json-report.json"},
        //plugin = {"html: test-reports"},
        monochrome = true)
public class ActivityRunner {
}