Feature: Search Results

  Background:
    Given user is on the login page


  Scenario: Table columns names
    When user login as a librarian
    And user clicks on "Users" link
    Then table should have following column names:
      | Actions |
      | User ID |
      | Full Name |
      | Email |
      | Group |
      | Status |