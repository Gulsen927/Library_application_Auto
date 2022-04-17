package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BooksPage;
import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US06_Verify_UI_DB_Book_Catogories_Match {
    DashboardPage dashboardPage = new DashboardPage();
    BooksPage booksPage = new BooksPage();
    List<String> actualAllOptionsFromBookCategories;
    List<String>expectedAllOptionsFromBookCategories;

    @Given("I log in as a librarian")
    public void i_log_in_as_a_librarian() {
        dashboardPage.loginAsLibrarian();


    }

    @When("I navigate to the Books page")
    public void i_navigate_to_the_Books_page() {
        dashboardPage.booksModule.click();


    }

    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
     actualAllOptionsFromBookCategories = booksPage.getAllOptionsFromBookCategories();


    }

    @When("I execute a query to get book categories")
    public void i_execute_a_query_to_get_book_categories() {
        DB_Util.runQuery("select name from book_categories");
         expectedAllOptionsFromBookCategories = DB_Util.getColumnDataAsList(1);


    }

    @Then("verify book categories must match the book_categories table from DB.")
    public void verify_book_categories_must_match_the_book_categories_table_from_db() {


        for (int i = 0; i <expectedAllOptionsFromBookCategories.size() ; i++) {
            Assert.assertEquals(expectedAllOptionsFromBookCategories.get(i),
                    actualAllOptionsFromBookCategories.get(i));



        }

    }

}
