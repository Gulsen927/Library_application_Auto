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
        String dbUrl=ConfigurationReader.getProperty("DB_url");
        String  dbUserName=ConfigurationReader.getProperty("Username");
        String dbPassword=ConfigurationReader.getProperty("Password");

        DB_Util.createConnection(dbUrl,dbUserName,dbPassword);


    }


    @After("@db")
    public void destroyDB() {

        DB_Util.destroy();
        System.out.println("CLOSING DATABASE CONNECTION......");

    }

}
