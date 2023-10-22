package com.my.library.pages;

import com.my.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUsername;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement navbar;

    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersButton;


    @FindBy(xpath = "//h2[.='232']")
    public WebElement userNumber;

    @FindBy(xpath = "//span[@class='title']")
    public List<WebElement> links;


    @FindBy(xpath = "//tr//th")
    public List<WebElement> headers;

    @FindBy(xpath = "//span[contains(.,'Test Student')]")
    public WebElement avatarText;




    public void login(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        signInButton.click();
    }


}
