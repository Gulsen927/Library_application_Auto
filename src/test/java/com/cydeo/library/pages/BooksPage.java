package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BasePage {

    public BooksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//tbody//td[3]")
    public WebElement booksName;

    @FindBy(xpath = "//tbody//td[4]")
    public WebElement author;

    @FindBy(xpath = "//tbody//td[6]")
    public WebElement year;

    @FindBy(id = "book_categories")
    public WebElement bookCategories;


    public List<String> getAllOptionsFromBookCategories() {

        Select select = new Select(bookCategories);

       List<WebElement> all = select.getOptions();

       List<String> allOptionsAsText = new ArrayList<>();

        for (WebElement each : all) {
            if(each.getText().equalsIgnoreCase("ALL")){
                continue;
            }
            allOptionsAsText.add(each.getText());

        }

       return allOptionsAsText;
    }


}
