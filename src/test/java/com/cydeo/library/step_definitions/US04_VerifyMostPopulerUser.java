package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US04_VerifyMostPopulerUser {

    String expectedUserName="Test Student 1";


    @When("I execute a query to find the most popular user")
    public void i_execute_a_query_to_find_the_most_popular_user() {
        DB_Util.runQuery("select full_name, count(*)\n" +
                "from book_borrow b inner join\n" +
                "    users u on b.user_id = u.id\n" +
                "group by user_id order by 2 desc");


    }
    @Then("verify \"Test Student [number]” is the user who reads the most")
    public void verify_test_student_number_is_the_user_who_reads_the_most() {

        String actualUserName = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedUserName,actualUserName);



    }

}
