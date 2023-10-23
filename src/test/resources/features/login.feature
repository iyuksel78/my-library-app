
Feature: Library Login Functionality
  User Story:
  As a user, I should be able to login with correct
  credentials to different accounts

  Background:
    Given user is on the login page


  Scenario: Librarian Login Functionality
    When user enters librarian username
    And user enters librarian password
    And user clicks the login button
    Then user sees the dashboard

@smoke
  Scenario: Student Login Functionality
    When user enters student username
    And user enters student password
    And user clicks the login button
    Then user sees the dashboard
