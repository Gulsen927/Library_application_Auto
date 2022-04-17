package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01_UserInformationStepDefinition {


    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {

        DB_Util.runQuery("select count(distinct id) from users");

    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        int actualIdCount = 141;

        int expectedIdCount = Integer.parseInt(DB_Util.getFirstRowFirstColumn());

        Assert.assertEquals(expectedIdCount,actualIdCount);


    }


    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
     DB_Util.runQuery("select * from users");


    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> dataTable) {
        List<String> allColumnNamesAsList = DB_Util.getAllColumnNamesAsList();
        Assert.assertEquals(dataTable, allColumnNamesAsList);

    }


}
