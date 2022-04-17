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

        },
        glue="com/cydeo/library/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        tags = "@wip",
        publish = true

)

public class CukesRunner {





}
