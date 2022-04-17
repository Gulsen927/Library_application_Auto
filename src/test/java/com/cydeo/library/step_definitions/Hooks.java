package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.DB_Util;
import com.cydeo.library.utilities.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUpUI(){
        Driver.getDriver().get(ConfigurationReader.getProperty("UI_url"));
    }


    @After
    public void tearDown(Scenario scenario){
        System.out.println("this is coming from AFTER");

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }

        Driver.closeDriver();

    }


    @Before("@db")
    @Given("Establish the database connection")
    public void setUpDB() {

        DB_Util.createConnection(ConfigurationReader.getProperty("DB_url"),
                ConfigurationReader.getProperty("Username"),ConfigurationReader.getProperty("Password"));
        System.out.println("CONNECTING DATABASE......");

    }


    @After("@db")
    public void destroyDB() {

        DB_Util.destroy();
        System.out.println("CLOSING DATABASE CONNECTION......");

    }

}
