package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US03_VerifyCommonBorrowedBookGenre {

    String   actualBookGenre;

    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        DB_Util.runQuery("select bc.name, count(*) from book_borrow bb inner join books b\n" +
                "    on bb.book_id = b.id\n" +
                "inner join book_categories bc on b.book_category_id = bc.id\n" +
                "group by name order by 2 desc");


        actualBookGenre = DB_Util.getFirstRowFirstColumn();

    }

    @Then("verify that {string} is the most popular book genre.")
    public void verify_that_is_the_most_popular_book_genre(String expectedBookGenre) {


        Assert.assertEquals(expectedBookGenre,actualBookGenre);





    }





}
