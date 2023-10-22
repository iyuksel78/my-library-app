
Feature: Library Login Functionality With Parameters

  Background:
    Given user is on the login page

  @librarian @employee
  Scenario: Library login functionality with parameter
    When user enters librarian username "librarian1@library"
    And user enters librarian password "libraryUser"
    And user clicks the login button
    Then user sees the dashboard

  @student
  Scenario: Student login functionality with parameter
    When user enters student username "student1@library"
    And user enters student password "libraryUser"
    And user clicks the login button
    Then user sees the dashboard


  Scenario: Login as librarian same line
    When user login using "librarian1@library" and "libraryUser"
    Then user sees the dashboard
    And there should be 232 users

