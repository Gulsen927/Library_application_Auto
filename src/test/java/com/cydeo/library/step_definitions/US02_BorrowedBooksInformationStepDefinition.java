package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_BorrowedBooksInformationStepDefinition {

    //BasePage basePage = new BasePage();
    DashboardPage dashboardPage = new DashboardPage();
    String actualBorrowedBooks;
    String expectedBorrowedBooks;
    @Given("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {

        dashboardPage.loginAsLibrarian();

    }
    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() {
      actualBorrowedBooks = dashboardPage.borrowedBooks.getText();


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("select count(*) from book_borrow where returned_date is null");
         expectedBorrowedBooks = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBorrowedBooks,actualBorrowedBooks);

    }

}
