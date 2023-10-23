Feature: Data Driven Testing with different user accounts

  Background:
    Given user is on the login page


  Scenario Outline: Verify user information <email>

    When I login using "<email>" and "<password>"
    Then account holder name should be "<name>"
#TEST DATA for library2.env
    @smoke
    Examples:
      | email             | password    | name            |
      | student27@library | libraryUser | Test Student 27 |
      | student28@library | libraryUser | Test Student 28 |
      | student29@library | libraryUser | Test Student 29 |


    @Regression
    Examples:
      | email             | password    | name            |
      | student30@library | libraryUser | Test Student 30 |
      | student31@library | libraryUser | Test Student 31 |
      | student32@library | libraryUser | Test Student 32 |


    @librarians
    Examples:
      | email               | password    | name              |
      | librarian13@library | libraryUser | Test Librarian 13 |
      | librarian14@library | libraryUser | Test Librarian 14 |
      | librarian15@library | libraryUser | Test Librarian 15 |
      | librarian16@library | libraryUser | Test Librarian 16 |
      | librarian17@library | libraryUser | Test Librarian 17 |
      | librarian18@library | libraryUser | Test Librarian 18 |
      | librarian19@library | libraryUser | Test Librarian 19 |
      | librarian20@library | libraryUser | Test Librarian 20 |
      | librarian21@library | libraryUser | Test Librarian 21 |
      | librarian22@library | libraryUser | Test Librarian 22 |

