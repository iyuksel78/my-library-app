package com.my.library.step_definitions;


import com.my.library.pages.LoginPage;
import com.my.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login_StepDefinitions {
    LoginPage loginPage = new LoginPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://library1.cydeo.com/login.html");


    }

    @When("user enters librarian username")
    public void userEntersLibrarianUsername() {
        loginPage.inputUsername.sendKeys("librarian1@library");
    }

    @And("user enters librarian password")
    public void userEntersLibrarianPassword() {
        loginPage.inputPassword.sendKeys("libraryUser");
    }

    @And("user clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.signInButton.click();
    }

    @Then("user sees the dashboard")
    public void userSeesTheDashboard() {
        Assert.assertTrue(loginPage.navbar.isDisplayed());

    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        loginPage.inputUsername.sendKeys("student1@library");
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        loginPage.inputPassword.sendKeys("libraryUser");
    }


    //+++++++++++++++++++++++++++++   TC 3    +++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @When("user enters librarian username {string}")
    public void userEntersLibrarianUsername(String username) {
        loginPage.inputUsername.sendKeys(username);

    }

    @And("user enters librarian password {string}")
    public void userEntersLibrarianPassword(String password) {
        loginPage.inputPassword.sendKeys(password);
    }

    @When("user enters student username {string}")
    public void userEntersStudentUsername(String username) {
        loginPage.inputUsername.sendKeys(username);
    }

    @And("user enters student password {string}")
    public void userEntersStudentPassword(String password) {
        loginPage.inputPassword.sendKeys(password);
    }


    //++++++++++++++++++++++++++TC #4:++++++++++++++++++++++++++++++++++++++++++

    @When("user login using {string} and {string}")
    public void userLoginUsingAnd(String username, String password) throws IOException {
        loginPage.login(username, password);

    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int userNumber) {
        int actualUserNumber = Integer.parseInt(loginPage.userNumber.getText());
        Assert.assertEquals(userNumber, actualUserNumber);

    }

    //++++++++++++++++++++++++++TC #5:++++++++++++++++++++++++++++++++++++++++++
    @When("user login as a librarian")
    public void userLoginAsALibrarian() {
        loginPage.login("librarian1@library", "libraryUser");

    }

    @And("user clicks on {string} link")
    public void userClicksOnLink(String string) {
        for (WebElement each : loginPage.links) {

            if (each.getText().contains(string)) {
                each.click();
            }

        }
    }

    @Then("table should have following column names:")
    public void tableShouldHaveFollowingColumnNames(List<String> expectedHeader) {

        List<String> actualHeader = new ArrayList<>();
        for (WebElement header : loginPage.headers) {
            actualHeader.add(header.getText());
        }

        Assert.assertEquals(actualHeader, expectedHeader);
        System.out.println("actualHeader = " + actualHeader);
        System.out.println("expectedHeader = " + expectedHeader);


    }


    @Then("user sees account username")
    public void userSeesAccountUsername() {

        Assert.assertTrue(loginPage.avatarText.isDisplayed());
        System.out.println("loginPage.avatarText.getText() = " + loginPage.avatarText.getText());
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String username, String password) {
        loginPage.login(username,password);

    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String name) {
        System.out.println("loginPage.avatarText.getText() = " + loginPage.avatarText.getText());

        Assert.assertTrue(loginPage.avatarText.getText().equals(name));
    }
}


