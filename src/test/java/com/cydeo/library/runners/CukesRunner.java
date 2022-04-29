package com.cydeo.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt", //store failed scenario names into rerun.txt file
                "json:target/json-report/cucumber.json"
        },
        glue="com/cydeo/library/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        tags = "@TL-105",
        publish = true

)

public class CukesRunner {





}
