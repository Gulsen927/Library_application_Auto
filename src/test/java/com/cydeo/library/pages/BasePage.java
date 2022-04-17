package com.cydeo.library.pages;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement inputEmail;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement signInButton;



    public void loginAsLibrarian(){
      this.inputEmail.sendKeys(ConfigurationReader.getProperty("librarian_username"));
      this.inputPassword.sendKeys(ConfigurationReader.getProperty("librarian_password"));
      this.signInButton.click();

    }


}
