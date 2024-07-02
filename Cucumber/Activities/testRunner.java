package org.example;

public class testRunner {
    package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/Features"
            , glue = {"stepDefinitions"}
            , tags = "@activity4"
            , plugin = "html:src/reports/HTML_Report.html"
    )

    public class testRunner {

    }


}
