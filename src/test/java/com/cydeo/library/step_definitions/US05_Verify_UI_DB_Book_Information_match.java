package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BooksPage;
import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

public class US05_Verify_UI_DB_Book_Information_match {
    DashboardPage dashboardPage = new DashboardPage();
     BooksPage booksPage = new BooksPage();

     String expectedBookName;
     String expectedAuthor;
     String expectedYear;

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        dashboardPage.loginAsLibrarian();


    }

    @Given("I navigate to Books page")
    public void i_navigate_to_books_page() {
     dashboardPage.booksModule.click();

    }

    @When("I open book {string}")
    public void i_open_book(String bookName) {
     booksPage.searchBox.sendKeys(bookName);


    }

    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {

        DB_Util.runQuery("select name, author, year from books where " +
                "name=''Chordeiles minor'");

        String actualBookName= booksPage.booksName.getText();
        String  actualAuthor=booksPage.author.getText();
        String actualYear=booksPage.year.getText();

        List<String> expectedBookInformation = DB_Util.getRowDataAsList(1);

        List<String> actualBookInformation = new ArrayList<>();
        actualBookInformation.add(actualBookName);
        actualBookInformation.add(actualAuthor);
        actualBookInformation.add(actualYear);

        for (int i = 0; i < expectedBookInformation.size() ; i++) {

            Assert.assertEquals(expectedBookInformation.get(i),actualBookInformation.get(i));


        }




    }




}
